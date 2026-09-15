---
name: scalar-java-sdk
description: "Java SDK for Scalar API. Use when writing Java code that calls Scalar API with the com.scalar package: installing it, constructing and authenticating the client, and calling API operations."
---

# Scalar Java SDK

Generated Java client for Scalar API, published as `com.scalar`. Use the generated client instead of hand-writing HTTP requests.

## Install

```sh
./gradlew :scalar-java:build
```

## Client setup and authentication

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();
```

Provide credentials using the options below. Environment variables are read automatically when the target runtime supports them:

- `bearerAuth` (env: `BEARER_AUTH`) — Credential for the BearerAuth client option.

## Calling operations

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var registry = client.registry().listAllApiDocuments();

System.out.println(registry);
```

Method names, parameter shapes, and response types are generated from the API description — do not guess them. Look up the exact call signature in [api.md](./api.md) before writing a call.

## Error handling

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

## Requirements

- Java 8 or later
- Gradle multi-module project rooted at `scalar-java-root`, built with JDK 21

## Reference files

- [README.md](./README.md) — full feature tour: client options, request options, retries and timeouts, logging.
- [api.md](./api.md) — complete catalogue of every operation with request and response types.
