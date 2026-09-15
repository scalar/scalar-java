# Scalar

This library provides convenient access to the Scalar REST API from Java.

The full API of this library can be found in [api.md](./api.md).

<br />

## Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Reference](./api.md)
- [Async](#async)
- [Requests and responses](#requests-and-responses)
- [Immutability](#immutability)
- [Raw responses](#raw-responses)
- [Network options](#network-options)
- [ProGuard and R8](#proguard-and-r8)
- [Jackson](#jackson)
- [Undocumented API functionality](#undocumented-api-functionality)
- [Authentication](#authentication)
- [Errors](#errors)
- [Client Options](#client-options)
- [Request Options](#request-options)
- [Retries and Timeouts](#retries-and-timeouts)
- [Helpers](#helpers)
- [Logging](#logging)
- [Requirements](#requirements)
- [FAQ](#faq)
- [Semantic versioning](#semantic-versioning)

<br />

## Installation

```sh
./gradlew :scalar-java:build
```

<br />

## Usage

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var registry = client.registry().listAllApiDocuments();

System.out.println(registry);
```

The examples in the following sections assume a `client` configured as shown above.

See the [API reference](./api.md) for every available operation.

<br />

## Async

Use `ScalarOkHttpClientAsync.builder()` or call `client.async()` when you want `CompletableFuture` services. Call `sync()` on the async client to switch back; both clients share one connection and thread pool.

```java
import com.scalar.client.ScalarClientAsync;
import com.scalar.client.okhttp.ScalarOkHttpClientAsync;

ScalarClientAsync client =
    ScalarOkHttpClientAsync.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var registry = client.registry().listAllApiDocuments();

System.out.println(registry);
```

<br />

## Requests and responses

Every operation takes a generated `*Params` class, built through its `builder()`, and is named after the
operation it belongs to — a resource method `update` takes a `<Resource>UpdateParams`. Most operations
return a generated response class; an operation with no body returns nothing, a binary download returns the
live `HttpResponse`, and a streaming one returns a `StreamResponse`.

Response classes store each field as a `JsonField<T>` and expose two accessors for it: a typed one
(`response.name()`) that throws if the server sent something the schema does not describe, and a raw one
(`response._name()`) that hands back whatever arrived. Call `validate()` on a response to check every field
at once instead of field by field.

A field the schema does not require is returned as a `java.util.Optional<T>`.

<br />

## Immutability

Generated classes are immutable once built. Each one is constructed through a builder, and each one that
has a builder also has a `toBuilder()` that returns a fresh builder seeded from the instance — so a
modified copy never mutates the instance it was derived from.

Collections handed out by a generated class are immutable too, so a list read off a response cannot be
changed underneath the class that returned it.

<br />

## Raw responses

Call `withRawResponse()` on the client or on any service to reach the HTTP response alongside the parsed
value. Every method on that view takes the same arguments as its ordinary counterpart and returns an
`HttpResponseFor<T>`, which adds `statusCode()`, `headers()`, and `body()` to the `parse()` that yields the
value the ordinary method would have returned. An operation with nothing to parse returns the plain
`HttpResponse` from the raw view; a `204` returns nothing at all from the ordinary one, while a binary
download the caller streams returns the live `HttpResponse` from both.

The raw view hands back a live response, so it must be closed — wrap it in try-with-resources. On the
blocking surface every raw method is annotated `@MustBeClosed` to enforce that, as are streaming and
binary methods on its ordinary counterpart. The asynchronous surface returns a `CompletableFuture`,
which is not itself closeable, so only its raw view of a streaming method carries the annotation —
close whatever a future completes with, annotated or not.

<br />

## Network options

Beyond the timeout and retry settings documented under Retries and Timeouts,
`ScalarOkHttpClient.builder()` exposes the transport settings of the underlying OkHttp client:

- `proxy(…)` and `proxyAuthenticator(…)` route requests through an HTTP proxy, the second one supplying
  credentials when the proxy answers `407 Proxy Authentication Required`.
- `maxIdleConnections(…)` with `keepAliveDuration(…)` size the connection pool; both must be set together.
- `sslSocketFactory(…)` with `trustManager(…)`, and `hostnameVerifier(…)`, secure HTTPS connections.
- `dispatcherExecutorService(…)` supplies the executor requests run on. The client takes ownership of it and
  shuts it down when closed.

To replace the transport entirely, implement `HttpClient` and pass it to `ClientOptions.builder().httpClient(…)`;
the generated OkHttp builders are one implementation of that interface, not a requirement.

<br />

## ProGuard and R8

The SDK deserializes with reflection, so shrinkers need to be told which members to keep. The
`scalar-java-core` module publishes those keep rules at
`scalar-java-core/src/main/resources/META-INF/proguard/scalar-java-core.pro`, and ProGuard and R8 pick them up
from the artifact automatically. Copy them into your own configuration only if your build does not read
rules published by dependencies.

Note that those rules keep the whole generated SDK package, so a minified build does not shrink or obfuscate
the generated classes. That is deliberate: a narrower rule set drops the annotations the SDK uses to omit unset
properties, and a shrunk build then fails at runtime on the first optional property a caller leaves out.

The `scalar-java-proguard-test` module checks those rules hold: `./gradlew testProGuard testR8` shrinks the SDK
with each shrinker under exactly the published rules and runs the compatibility test out of the shrunk jar.

<br />

## Jackson

The SDK serializes and deserializes with [Jackson](https://github.com/FasterXML/jackson). It depends on
version 2.18.2 and accepts any Jackson 2.x from 2.13.4 upward,
except the versions listed below. Jackson 3 and newer majors are not supported.

- `2.18.1` is rejected due to https://github.com/FasterXML/jackson-databind/issues/4639.

A different Jackson version reaching the runtime — usually pulled in transitively by another dependency —
is detected on client construction and reported as an error rather than as a deserialization failure later.
If you are certain your version is compatible, turn the check off with
`checkJacksonVersionCompatibility(false)` on `ScalarOkHttpClient` or `ScalarOkHttpClientAsync`.

> [!CAUTION]
> The SDK is not guaranteed to work correctly once the version check is disabled.

<br />

## Undocumented API functionality

The SDK is generated from an OpenAPI document, so it types exactly what that document describes. Anything
the API accepts or returns beyond it is still reachable:

- **Undocumented request fields.** `*Params.Builder` carries `putAdditionalHeader(…)` and
  `putAdditionalQueryParam(…)`, and a params class with a request body adds `putAdditionalBodyProperty(…)`.
  A body property takes a `JsonValue`, built with `JsonValue.from(…)`.
- **Undocumented response fields.** Every generated model exposes `_additionalProperties()`, a
  `Map<String, JsonValue>` of everything the server sent that the schema did not declare.
- **Undocumented values.** A generated enum is open: an unrecognized value round-trips through
  `Value._UNKNOWN` and is readable with `asString()`, so a value the API adds later does not throw.

Responses are not validated up front by default; a field is only checked when it is read. Set
`responseValidation(true)` on the client builder, or on a single call through `RequestOptions`, to validate
the whole payload as soon as it arrives.

These escape hatches are the supported way to reach undocumented behavior from Java too.

<br />

## Authentication

Pass credentials to the generated client constructor. Environment variables are read automatically when supported by the target runtime.

| Option | Type | Default | Description |
| --- | --- | --- | --- |
| `bearerAuth` | `string \| provider` | - | Credential for the BearerAuth client option. Defaults to BEARER_AUTH. |

Declared schemes:

- `BearerAuth` bearer token

<br />

## Errors

Non-success responses throw generated API errors. Error objects expose status, headers, response body, and request metadata where the target runtime supports it.

```java
import com.scalar.errors.ScalarServiceException;

try {
  var registry = client.registry().listAllApiDocuments();
} catch (ScalarServiceException err) {
  System.out.println(err.statusCode() + " " + err.body());
  throw err;
}
```

Documented error statuses: `400`, `401`, `403`, `404`, `422`, `500`.

<br />

## Client Options

Configure the generated client by setting any of these options when you create it.

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import java.time.Duration;

ScalarClient client =
    ScalarOkHttpClient.builder()
        .baseUrl("https://access.scalar.com")
        .timeout(Duration.ofSeconds(60))
        .maxRetries(2)
        .build();
```

| Option | Type | Default | Description |
| --- | --- | --- | --- |
| `bearerAuth` | `String` | `System.getenv("BEARER_AUTH")` | Credential for the BearerAuth client option. |
| `baseUrl` | `String` | - | Override the default API base URL. |
| `putHeader` | `(String, String) -> Builder` | - | Set a header sent with every request. |
| `putQueryParam` | `(String, String) -> Builder` | - | Set a query parameter sent with every request. |
| `timeout` | `java.time.Duration` | `Duration.ofMinutes(1)` | Maximum time to wait for a response before aborting a request. |
| `maxRetries` | `int` | `2` | Number of retries for temporary failures. |
| `responseValidation` | `boolean` | `false` | Validate response data before returning it. |
| `jsonMapper` | `JsonMapper` | - | Custom Jackson mapper for JSON serialization and deserialization. |
| `httpClient` | `HttpClient` | - | Custom HTTP transport; the generated OkHttp builder supplies the standard implementation. |

<br />

## Request Options

| Option | Type | Default | Description |
| --- | --- | --- | --- |
| `RequestOptions.builder().timeout` | `java.time.Duration` | - | Override the timeout for a single request. |
| `RequestOptions.builder().responseValidation` | `Boolean` | - | Override response validation for a single request. |
| `*Params.Builder.putAdditionalHeader` | `(String, String) -> Builder` | - | Set an operation-specific additional header. |
| `*Params.Builder.putAdditionalQueryParam` | `(String, String) -> Builder` | - | Set an operation-specific additional query parameter. |
| `*Params.Builder.putAdditionalBodyProperty` | `(String, Any?) -> Builder` | - | Add an extra JSON body property without changing the generated params type. |

<br />

## Retries and Timeouts

Generated clients support request timeouts and retry temporary failures such as network errors, 408, 409, 429, and 5xx responses. Retry delays honor `Retry-After` headers when present. Tune the retry and timeout client options shown above, or override them per request.

<br />

## Helpers

- Call `withRawResponse()` on a client or service to inspect the parsed value alongside response metadata.
- Use generated `*Params.builder()` helpers to set operation parameters, additional headers, additional query parameters, and extra JSON body properties.

<br />

## Logging

- Set `logLevel` on `ClientOptions.Builder` to control request, response, and retry logging.
- Use `fromEnv()` to seed generated auth options from environment variables and JVM system properties.

<br />

## Requirements

- Java 8 or later
- Gradle multi-module project rooted at `scalar-java-root`, built with JDK 21

<br />

## FAQ

### Why are enums not `enum`?

A closed enum cannot represent a value the API adds after the SDK was published — deserialization would
throw on a response that is otherwise perfectly valid. Generated enums are classes wrapping the raw string,
with the known values as constants, `asString()` for the wire value, and `Value._UNKNOWN` for everything else.

### Why is every field a `JsonField<T>`?

It keeps "absent", "explicitly null", and "present but the wrong type" apart, which a plain `T` cannot. The
typed accessor gives you the value or an error; the raw `_field()` accessor gives you what actually arrived.

### Why are models not records?

A record derives its members from its constructor parameters, so
adding a field to one is a binary-incompatible change — and a generated model gains fields whenever the API
does. The generated builder also validates on `build()`, which a generated constructor or `copy` would bypass.

### Why are there no checked exceptions?

Every error the SDK raises is unchecked, so callers catch what they intend to handle rather than being forced
to declare or swallow the rest. Failures are subclasses of the generated SDK exception type.

<br />

## Semantic versioning

The SDK follows [SemVer](https://semver.org/spec/v2.0.0.html), with two documented exceptions: changes that
affect only static types and not runtime behavior, and changes to members marked internal or documented as
unstable, may ship in a minor release.

Additive changes — a new operation, a new field on a response, a new enum constant — are always minor: every
generated class is designed to accept values it did not know about at build time.

Powered by Scalar.
