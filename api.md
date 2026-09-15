# Scalar Java API

Complete reference of every operation, grouped by resource. See [the README](./README.md) for usage and configuration.

## Contents

- [`Registry`](#registry)
  - [List all API Documents](#list-all-api-documents)
  - [List API Documents in a namespace](#list-api-documents-in-a-namespace)
  - [Create API Document](#create-api-document)
  - [Update API Document metadata](#update-api-document-metadata)
  - [Delete API Document](#delete-api-document)
  - [Get API Document](#get-api-document)
  - [Update API Document version](#update-api-document-version)
  - [Delete API Document version](#delete-api-document-version)
  - [Get API Document version metadata](#get-api-document-version-metadata)
  - [Create API Document version](#create-api-document-version)
  - [Add access group](#add-access-group)
  - [Remove access group](#remove-access-group)
- [`Schemas`](#schemas)
  - [List all shared components](#list-all-shared-components)
  - [Create a shared component](#create-a-shared-component)
  - [Update shared component metadata](#update-shared-component-metadata)
  - [Delete a shared component](#delete-a-shared-component)
  - [`Schemas Version`](#schemas-version)
    - [Get a shared component document](#get-a-shared-component-document)
    - [Delete a shared component version](#delete-a-shared-component-version)
    - [Create a shared component version](#create-a-shared-component-version)
  - [`Schemas AccessGroup`](#schemas-accessgroup)
    - [Add shared component access group](#add-shared-component-access-group)
    - [Remove shared component access group](#remove-shared-component-access-group)
- [`LoginPortals`](#loginportals)
  - [Get a login portal](#get-a-login-portal)
  - [Update portal metadata](#update-portal-metadata)
  - [Delete a login portal](#delete-a-login-portal)
  - [Create a portal](#create-a-portal)
  - [List all portals](#list-all-portals)
- [`Rules`](#rules)
  - [List all rules](#list-all-rules)
  - [Create a rule](#create-a-rule)
  - [Update rule metadata](#update-rule-metadata)
  - [Delete a rule](#delete-a-rule)
  - [Get a rule](#get-a-rule)
  - [Add rule access group](#add-rule-access-group)
  - [Remove rule access group](#remove-rule-access-group)
- [`Themes`](#themes)
  - [List all themes](#list-all-themes)
  - [Create a theme](#create-a-theme)
  - [Update theme metadata](#update-theme-metadata)
  - [Update theme document](#update-theme-document)
  - [Delete a theme](#delete-a-theme)
  - [Get a theme](#get-a-theme)
- [`Teams`](#teams)
  - [List teams](#list-teams)
- [`ScalarDocs`](#scalardocs)
  - [List all projects](#list-all-projects)
  - [Create a project](#create-a-project)
  - [Publish a project](#publish-a-project)
- [`Namespaces`](#namespaces)
  - [List namespaces](#list-namespaces)
- [`Authentication`](#authentication)
  - [Exchange token](#exchange-token)
  - [Get current user](#get-current-user)

## Setup

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();
```

## `Registry`

Registry

### List all API Documents

List all API documents across every namespace the caller can access.

| Direction | Type |
| --- | --- |
| Request | [`RegistryListAllApiDocumentsParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryListAllApiDocumentsParams.kt) |
| Response | [`List<RegistryListAllApiDocumentsResponse>`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryListAllApiDocumentsResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var registry = client.registry().listAllApiDocuments();

System.out.println(registry);
```

### List API Documents in a namespace

List API documents in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`RegistryListApiDocumentsParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryListApiDocumentsParams.kt) |
| Response | [`List<RegistryListApiDocumentsResponse>`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryListApiDocumentsResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryListApiDocumentsParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryListApiDocumentsParams params =
    RegistryListApiDocumentsParams.builder().namespace("namespace").build();
var registry = client.registry().listApiDocuments(params);

System.out.println(registry);
```

### Create API Document

Create an API document.

| Direction | Type |
| --- | --- |
| Request | [`RegistryCreateApiDocumentParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryCreateApiDocumentParams.kt) |
| Response | [`RegistryCreateApiDocumentResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryCreateApiDocumentResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryCreateApiDocumentParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryCreateApiDocumentParams params =
    RegistryCreateApiDocumentParams.builder()
        .namespace("namespace")
        .title("")
        .version("x")
        .slug("")
        .document("")
        .build();
var registry = client.registry().createApiDocument(params);

System.out.println(registry);
```

### Update API Document metadata

Update metadata for an API document.

| Direction | Type |
| --- | --- |
| Request | [`RegistryUpdateApiDocumentParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryUpdateApiDocumentParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryUpdateApiDocumentParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryUpdateApiDocumentParams params =
    RegistryUpdateApiDocumentParams.builder().namespace("namespace").slug("slug").build();
var registry = client.registry().updateApiDocument(params);

System.out.println(registry);
```

### Delete API Document

Delete an API document and all versions.

| Direction | Type |
| --- | --- |
| Request | [`RegistryDeleteApiDocumentParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryDeleteApiDocumentParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryDeleteApiDocumentParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryDeleteApiDocumentParams params =
    RegistryDeleteApiDocumentParams.builder().namespace("namespace").slug("slug").build();
var registry = client.registry().deleteApiDocument(params);

System.out.println(registry);
```

### Get API Document

Get a specific API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryRetrieveApiDocumentVersionParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryRetrieveApiDocumentVersionParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryRetrieveApiDocumentVersionParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryRetrieveApiDocumentVersionParams params =
    RegistryRetrieveApiDocumentVersionParams.builder()
        .namespace("namespace")
        .slug("slug")
        .semver("semver")
        .build();
var registry = client.registry().retrieveApiDocumentVersion(params);

System.out.println(registry);
```

### Update API Document version

Update the registry file content for an API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryUpdateApiDocumentVersionParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryUpdateApiDocumentVersionParams.kt) |
| Response | [`RegistryUpdateApiDocumentVersionResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryUpdateApiDocumentVersionResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryUpdateApiDocumentVersionParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryUpdateApiDocumentVersionParams params =
    RegistryUpdateApiDocumentVersionParams.builder()
        .namespace("namespace")
        .slug("slug")
        .semver("semver")
        .document("")
        .build();
var registry = client.registry().updateApiDocumentVersion(params);

System.out.println(registry);
```

### Delete API Document version

Delete a specific API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryDeleteApiDocumentVersionParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryDeleteApiDocumentVersionParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryDeleteApiDocumentVersionParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryDeleteApiDocumentVersionParams params =
    RegistryDeleteApiDocumentVersionParams.builder()
        .namespace("namespace")
        .slug("slug")
        .semver("semver")
        .build();
var registry = client.registry().deleteApiDocumentVersion(params);

System.out.println(registry);
```

### Get API Document version metadata

Get metadata (uid, content shas, version sha, tags) for a specific API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryListApiDocumentVersionMetadataParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryListApiDocumentVersionMetadataParams.kt) |
| Response | [`ManagedDocVersion`](./scalar-java-core/src/main/kotlin/com/scalar/models/ManagedDocVersion.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryListApiDocumentVersionMetadataParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryListApiDocumentVersionMetadataParams params =
    RegistryListApiDocumentVersionMetadataParams.builder()
        .namespace("namespace")
        .slug("slug")
        .semver("semver")
        .build();
var registry = client.registry().listApiDocumentVersionMetadata(params);

System.out.println(registry);
```

### Create API Document version

Create a new API document version.

| Direction | Type |
| --- | --- |
| Request | [`RegistryCreateApiDocumentVersionParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryCreateApiDocumentVersionParams.kt) |
| Response | [`ManagedDocVersion`](./scalar-java-core/src/main/kotlin/com/scalar/models/ManagedDocVersion.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.RegistryCreateApiDocumentVersionParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryCreateApiDocumentVersionParams params =
    RegistryCreateApiDocumentVersionParams.builder()
        .namespace("namespace")
        .slug("slug")
        .version("x")
        .document("")
        .build();
var registry = client.registry().createApiDocumentVersion(params);

System.out.println(registry);
```

### Add access group

Add an access group to an API document.

| Direction | Type |
| --- | --- |
| Request | [`RegistryCreateApiDocumentAccessGroupParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryCreateApiDocumentAccessGroupParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.AccessGroup;
import com.scalar.models.registry.RegistryCreateApiDocumentAccessGroupParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryCreateApiDocumentAccessGroupParams params =
    RegistryCreateApiDocumentAccessGroupParams.builder()
        .namespace("namespace")
        .slug("slug")
        .accessGroup(AccessGroup.builder().accessGroupSlug("xxx").build())
        .build();
var registry = client.registry().createApiDocumentAccessGroup(params);

System.out.println(registry);
```

### Remove access group

Remove an access group from an API document.

| Direction | Type |
| --- | --- |
| Request | [`RegistryDeleteApiDocumentAccessGroupParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/RegistryDeleteApiDocumentAccessGroupParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.AccessGroup;
import com.scalar.models.registry.RegistryDeleteApiDocumentAccessGroupParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RegistryDeleteApiDocumentAccessGroupParams params =
    RegistryDeleteApiDocumentAccessGroupParams.builder()
        .namespace("namespace")
        .slug("slug")
        .accessGroup(AccessGroup.builder().accessGroupSlug("xxx").build())
        .build();
var registry = client.registry().deleteApiDocumentAccessGroup(params);

System.out.println(registry);
```

## `Schemas`

Schemas

### List all shared components

List schemas in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`SchemaListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/SchemaListParams.kt) |
| Response | [`List<SchemaListResponse>`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/SchemaListResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.schemas.SchemaListParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SchemaListParams params = SchemaListParams.builder().namespace("namespace").build();
var schema = client.schemas().list(params);

System.out.println(schema);
```

### Create a shared component

Create a schema in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`SchemaCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/SchemaCreateParams.kt) |
| Response | [`Uid`](./scalar-java-core/src/main/kotlin/com/scalar/models/Uid.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.schemas.SchemaCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SchemaCreateParams params =
    SchemaCreateParams.builder()
        .namespace("namespace")
        .title("")
        .version("x")
        .slug("")
        .document("")
        .build();
var schema = client.schemas().create(params);

System.out.println(schema);
```

### Update shared component metadata

Update schema metadata.

| Direction | Type |
| --- | --- |
| Request | [`SchemaUpdateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/SchemaUpdateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.schemas.SchemaUpdateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SchemaUpdateParams params =
    SchemaUpdateParams.builder().namespace("namespace").slug("slug").build();
var schema = client.schemas().update(params);

System.out.println(schema);
```

### Delete a shared component

Delete a schema and all related versions.

| Direction | Type |
| --- | --- |
| Request | [`SchemaDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/SchemaDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.schemas.SchemaDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SchemaDeleteParams params =
    SchemaDeleteParams.builder().namespace("namespace").slug("slug").build();
var schema = client.schemas().delete(params);

System.out.println(schema);
```

### `Schemas Version`

Schemas

#### Get a shared component document

Get a specific schema version document.

| Direction | Type |
| --- | --- |
| Request | [`VersionRetrieveParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/version/VersionRetrieveParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.schemas.version.VersionRetrieveParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

VersionRetrieveParams params =
    VersionRetrieveParams.builder()
        .namespace("namespace")
        .slug("slug")
        .semver("semver")
        .build();
var version = client.schemas().version().retrieve(params);

System.out.println(version);
```

#### Delete a shared component version

Delete a schema version.

| Direction | Type |
| --- | --- |
| Request | [`VersionDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/version/VersionDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.schemas.version.VersionDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

VersionDeleteParams params =
    VersionDeleteParams.builder().namespace("namespace").slug("slug").semver("semver").build();
var version = client.schemas().version().delete(params);

System.out.println(version);
```

#### Create a shared component version

Create a schema version.

| Direction | Type |
| --- | --- |
| Request | [`VersionCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/version/VersionCreateParams.kt) |
| Response | [`Uid`](./scalar-java-core/src/main/kotlin/com/scalar/models/Uid.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.schemas.version.VersionCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

VersionCreateParams params =
    VersionCreateParams.builder()
        .namespace("namespace")
        .slug("slug")
        .version("x")
        .document("")
        .build();
var version = client.schemas().version().create(params);

System.out.println(version);
```

### `Schemas AccessGroup`

Schemas

#### Add shared component access group

Add an access group to a schema.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/accessGroup/AccessGroupCreateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.AccessGroup;
import com.scalar.models.schemas.accessGroup.AccessGroupCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

AccessGroupCreateParams params =
    AccessGroupCreateParams.builder()
        .namespace("namespace")
        .slug("slug")
        .accessGroup(AccessGroup.builder().accessGroupSlug("xxx").build())
        .build();
var accessGroup = client.schemas().accessGroup().create(params);

System.out.println(accessGroup);
```

#### Remove shared component access group

Remove an access group from a schema.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/accessGroup/AccessGroupDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.AccessGroup;
import com.scalar.models.schemas.accessGroup.AccessGroupDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

AccessGroupDeleteParams params =
    AccessGroupDeleteParams.builder()
        .namespace("namespace")
        .slug("slug")
        .accessGroup(AccessGroup.builder().accessGroupSlug("xxx").build())
        .build();
var accessGroup = client.schemas().accessGroup().delete(params);

System.out.println(accessGroup);
```

## `LoginPortals`

Login Portals

### Get a login portal

Get a login portal by slug.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalRetrieveParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/loginPortals/LoginPortalRetrieveParams.kt) |
| Response | [`LoginPortalRetrieveResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/loginPortals/LoginPortalRetrieveResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.loginPortals.LoginPortalRetrieveParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

LoginPortalRetrieveParams params = LoginPortalRetrieveParams.builder().slug("slug").build();
var loginPortal = client.loginPortals().retrieve(params);

System.out.println(loginPortal);
```

### Update portal metadata

Update metadata for a login portal.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalUpdateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/loginPortals/LoginPortalUpdateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.loginPortals.LoginPortalUpdateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

LoginPortalUpdateParams params = LoginPortalUpdateParams.builder().slug("slug").build();
var loginPortal = client.loginPortals().update(params);

System.out.println(loginPortal);
```

### Delete a login portal

Delete a login portal.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/loginPortals/LoginPortalDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.loginPortals.LoginPortalDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

LoginPortalDeleteParams params = LoginPortalDeleteParams.builder().slug("slug").build();
var loginPortal = client.loginPortals().delete(params);

System.out.println(loginPortal);
```

### Create a portal

Create a login portal for the current team.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/loginPortals/LoginPortalCreateParams.kt) |
| Response | [`Uid`](./scalar-java-core/src/main/kotlin/com/scalar/models/Uid.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.loginPortals.LoginPortalCreateParams;
import com.scalar.models.loginPortals.LoginPortalEmail;
import com.scalar.models.loginPortals.LoginPortalPage;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

LoginPortalCreateParams params =
    LoginPortalCreateParams.builder()
        .title("")
        .slug("")
        .email(
            LoginPortalEmail.builder()
                .logo("")
                .logoSize("100")
                .buttonText("Login")
                .message("Click to access private documentation hosted by scalar.com")
                .title("Private Docs")
                .mainColor("#2a2f45")
                .mainBackground("#f6f6f6")
                .cardColor("2a2f45")
                .cardBackground("#fff")
                .buttonColor("#fff")
                .buttonBackground("#0f0f0f")
                .build())
        .page(
            LoginPortalPage.builder()
                .title("Scalar Private Docs")
                .description("Login to access your documentation")
                .head("")
                .script("")
                .theme("")
                .companyName("")
                .logo("")
                .logoUrl("")
                .favicon("")
                .termsLink("")
                .privacyLink("")
                .formTitle("Scalar Private Docs")
                .formDescription("Login to access your documentation")
                .formImage("")
                .build())
        .build();
var loginPortal = client.loginPortals().create(params);

System.out.println(loginPortal);
```

### List all portals

List all login portals for the current team.

| Direction | Type |
| --- | --- |
| Request | [`LoginPortalListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/loginPortals/LoginPortalListParams.kt) |
| Response | [`List<LoginPortalListResponse>`](./scalar-java-core/src/main/kotlin/com/scalar/models/loginPortals/LoginPortalListResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var loginPortal = client.loginPortals().list();

System.out.println(loginPortal);
```

## `Rules`

Rules

### List all rules

List all rulesets in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`RuleListRulesetsParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleListRulesetsParams.kt) |
| Response | [`List<RuleListRulesetsResponse>`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleListRulesetsResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.rules.RuleListRulesetsParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RuleListRulesetsParams params = RuleListRulesetsParams.builder().namespace("namespace").build();
var rule = client.rules().listRulesets(params);

System.out.println(rule);
```

### Create a rule

Create a rule in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`RuleCreateRulesetParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleCreateRulesetParams.kt) |
| Response | [`Uid`](./scalar-java-core/src/main/kotlin/com/scalar/models/Uid.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.rules.RuleCreateRulesetParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RuleCreateRulesetParams params =
    RuleCreateRulesetParams.builder()
        .namespace("namespace")
        .title("")
        .slug("")
        .document("")
        .build();
var rule = client.rules().createRuleset(params);

System.out.println(rule);
```

### Update rule metadata

Update rule metadata by slug.

| Direction | Type |
| --- | --- |
| Request | [`RuleUpdateRulesetParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleUpdateRulesetParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.rules.RuleUpdateRulesetParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RuleUpdateRulesetParams params =
    RuleUpdateRulesetParams.builder()
        .pathNamespace("pathNamespace")
        .pathSlug("pathSlug")
        .build();
var rule = client.rules().updateRuleset(params);

System.out.println(rule);
```

### Delete a rule

Delete a rule by slug.

| Direction | Type |
| --- | --- |
| Request | [`RuleDeleteRulesetParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleDeleteRulesetParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.rules.RuleDeleteRulesetParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RuleDeleteRulesetParams params =
    RuleDeleteRulesetParams.builder().namespace("namespace").slug("slug").build();
var rule = client.rules().deleteRuleset(params);

System.out.println(rule);
```

### Get a rule

Get a rule document by slug.

| Direction | Type |
| --- | --- |
| Request | [`RuleRetrieveRulesetDocumentParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleRetrieveRulesetDocumentParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.rules.RuleRetrieveRulesetDocumentParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RuleRetrieveRulesetDocumentParams params =
    RuleRetrieveRulesetDocumentParams.builder().namespace("namespace").slug("slug").build();
var rule = client.rules().retrieveRulesetDocument(params);

System.out.println(rule);
```

### Add rule access group

Grant an access group to a rule.

| Direction | Type |
| --- | --- |
| Request | [`RuleCreateRulesetAccessGroupParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleCreateRulesetAccessGroupParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.AccessGroup;
import com.scalar.models.rules.RuleCreateRulesetAccessGroupParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RuleCreateRulesetAccessGroupParams params =
    RuleCreateRulesetAccessGroupParams.builder()
        .namespace("namespace")
        .slug("slug")
        .accessGroup(AccessGroup.builder().accessGroupSlug("xxx").build())
        .build();
var rule = client.rules().createRulesetAccessGroup(params);

System.out.println(rule);
```

### Remove rule access group

Remove an access group from a rule.

| Direction | Type |
| --- | --- |
| Request | [`RuleDeleteRulesetAccessGroupParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleDeleteRulesetAccessGroupParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.registry.AccessGroup;
import com.scalar.models.rules.RuleDeleteRulesetAccessGroupParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RuleDeleteRulesetAccessGroupParams params =
    RuleDeleteRulesetAccessGroupParams.builder()
        .namespace("namespace")
        .slug("slug")
        .accessGroup(AccessGroup.builder().accessGroupSlug("xxx").build())
        .build();
var rule = client.rules().deleteRulesetAccessGroup(params);

System.out.println(rule);
```

## `Themes`

Themes

### List all themes

List all team themes.

| Direction | Type |
| --- | --- |
| Request | [`ThemeListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/themes/ThemeListParams.kt) |
| Response | [`List<ThemeListResponse>`](./scalar-java-core/src/main/kotlin/com/scalar/models/themes/ThemeListResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var theme = client.themes().list();

System.out.println(theme);
```

### Create a theme

Create a team theme.

| Direction | Type |
| --- | --- |
| Request | [`ThemeCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/themes/ThemeCreateParams.kt) |
| Response | [`Uid`](./scalar-java-core/src/main/kotlin/com/scalar/models/Uid.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.themes.ThemeCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ThemeCreateParams params = ThemeCreateParams.builder().name("").slug("").document("").build();
var theme = client.themes().create(params);

System.out.println(theme);
```

### Update theme metadata

Update theme metadata.

| Direction | Type |
| --- | --- |
| Request | [`ThemeUpdateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/themes/ThemeUpdateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.themes.ThemeUpdateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ThemeUpdateParams params = ThemeUpdateParams.builder().slug("slug").build();
var theme = client.themes().update(params);

System.out.println(theme);
```

### Update theme document

Replace the theme document.

| Direction | Type |
| --- | --- |
| Request | [`ThemeReplaceDocumentParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/themes/ThemeReplaceDocumentParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.themes.ThemeReplaceDocumentParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ThemeReplaceDocumentParams params =
    ThemeReplaceDocumentParams.builder().slug("slug").document("").build();
var theme = client.themes().replaceDocument(params);

System.out.println(theme);
```

### Delete a theme

Delete a theme by slug.

| Direction | Type |
| --- | --- |
| Request | [`ThemeDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/themes/ThemeDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.themes.ThemeDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ThemeDeleteParams params = ThemeDeleteParams.builder().slug("slug").build();
var theme = client.themes().delete(params);

System.out.println(theme);
```

### Get a theme

Get the theme document by slug.

| Direction | Type |
| --- | --- |
| Request | [`ThemeRetrieveParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/themes/ThemeRetrieveParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.themes.ThemeRetrieveParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ThemeRetrieveParams params = ThemeRetrieveParams.builder().slug("slug").build();
var theme = client.themes().retrieve(params);

System.out.println(theme);
```

## `Teams`

Teams

### List teams

List all available teams

| Direction | Type |
| --- | --- |
| Request | [`TeamListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/TeamListParams.kt) |
| Response | [`List<TeamListResponse>`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/TeamListResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var team = client.teams().list();

System.out.println(team);
```

## `ScalarDocs`

Scalar Docs

### List all projects

List all guide projects.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListGuidesParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListGuidesParams.kt) |
| Response | [`List<ScalarDocListGuidesResponse>`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListGuidesResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var scalarDoc = client.scalarDocs().listGuides();

System.out.println(scalarDoc);
```

### Create a project

Create a guide project.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocCreateGuideParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocCreateGuideParams.kt) |
| Response | [`ScalarDocCreateGuideResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocCreateGuideResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocCreateGuideParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocCreateGuideParams params =
    ScalarDocCreateGuideParams.builder()
        .name("")
        .isPrivate(false)
        .allowedUsers(java.util.List.of())
        .allowedDomains(java.util.List.of())
        .build();
var scalarDoc = client.scalarDocs().createGuide(params);

System.out.println(scalarDoc);
```

### Publish a project

Start a new publish process.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocPublishGuideParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocPublishGuideParams.kt) |
| Response | [`ScalarDocPublishGuideResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocPublishGuideResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocPublishGuideParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocPublishGuideParams params = ScalarDocPublishGuideParams.builder().slug("slug").build();
var scalarDoc = client.scalarDocs().publishGuide(params);

System.out.println(scalarDoc);
```

## `Namespaces`

Namespaces

### List namespaces

Get all namespaces for the current team

| Direction | Type |
| --- | --- |
| Request | [`NamespaceListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/namespaces/NamespaceListParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var namespace = client.namespaces().list();

System.out.println(namespace);
```

## `Authentication`

Authentication

### Exchange token

Exchange an API key for an access token.

| Direction | Type |
| --- | --- |
| Request | [`AuthenticationExchangePersonalTokenParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/authentication/AuthenticationExchangePersonalTokenParams.kt) |
| Response | [`AuthenticationExchangePersonalTokenResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/authentication/AuthenticationExchangePersonalTokenResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.authentication.AuthenticationExchangePersonalTokenParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

AuthenticationExchangePersonalTokenParams params =
    AuthenticationExchangePersonalTokenParams.builder().personalToken("").build();
var authentication = client.authentication().exchangePersonalToken(params);

System.out.println(authentication);
```

### Get current user

Get the authenticated user, including their available teams and theme.

| Direction | Type |
| --- | --- |
| Request | [`AuthenticationListCurrentUserParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/authentication/AuthenticationListCurrentUserParams.kt) |
| Response | [`AuthenticationListCurrentUserResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/authentication/AuthenticationListCurrentUserResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var authentication = client.authentication().listCurrentUser();

System.out.println(authentication);
```
