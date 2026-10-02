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
- [`AccessGroups`](#accessgroups)
  - [Create an access group](#create-an-access-group)
  - [Get an access group](#get-an-access-group)
  - [Update an access group](#update-an-access-group)
  - [Delete an access group](#delete-an-access-group)
  - [`AccessGroups Domains`](#accessgroups-domains)
    - [Add an allowed email domain](#add-an-allowed-email-domain)
    - [Remove an allowed email domain](#remove-an-allowed-email-domain)
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
  - [`Teams Members`](#teams-members)
    - [List team members](#list-team-members)
    - [Change a member role](#change-a-member-role)
    - [Remove a member](#remove-a-member)
  - [`Teams Invites`](#teams-invites)
    - [Invite a member](#invite-a-member)
    - [Resend an invite](#resend-an-invite)
    - [Cancel an invite](#cancel-an-invite)
- [`ScalarDocs`](#scalardocs)
  - [List all projects](#list-all-projects)
  - [Create a project](#create-a-project)
  - [Publish a project](#publish-a-project)
  - [List all docs projects](#list-all-docs-projects)
  - [Create a docs project](#create-a-docs-project)
  - [Get a docs project](#get-a-docs-project)
  - [Update a docs project](#update-a-docs-project)
  - [Delete a docs project](#delete-a-docs-project)
  - [Publish a docs project](#publish-a-docs-project)
  - [Read the site config](#read-the-site-config)
  - [Write the site config](#write-the-site-config)
  - [Get the site domains](#get-the-site-domains)
  - [Check domain DNS](#check-domain-dns)
- [`Namespaces`](#namespaces)
  - [List namespaces](#list-namespaces)
- [`Authentication`](#authentication)
  - [Exchange token](#exchange-token)
  - [Get current user](#get-current-user)
- [`Sdks`](#sdks)
  - [List all SDKs](#list-all-sdks)
  - [Create an SDK](#create-an-sdk)
  - [Get an SDK](#get-an-sdk)
  - [Update an SDK](#update-an-sdk)
  - [Delete an SDK](#delete-an-sdk)
  - [Build an SDK](#build-an-sdk)
  - [`Sdks Versions`](#sdks-versions)
    - [Create an SDK version](#create-an-sdk-version)
    - [Delete an SDK version](#delete-an-sdk-version)
  - [`Sdks Repositories`](#sdks-repositories)
    - [Link a repository](#link-a-repository)
    - [Unlink a repository](#unlink-a-repository)
    - [Update publishing settings](#update-publishing-settings)
- [`Mcp`](#mcp)
  - [`Mcp Servers`](#mcp-servers)
    - [List all MCP servers](#list-all-mcp-servers)
    - [Create an MCP server](#create-an-mcp-server)
    - [Get an MCP server](#get-an-mcp-server)
    - [Update an MCP server](#update-an-mcp-server)
    - [Delete an MCP server](#delete-an-mcp-server)
    - [`Mcp Servers Installations`](#mcp-servers-installations)
      - [List installations](#list-installations)
      - [Create an installation](#create-an-installation)
      - [Get an installation](#get-an-installation)
      - [Update an installation](#update-an-installation)
      - [Delete an installation](#delete-an-installation)
      - [Add an access group](#add-an-access-group)
      - [Remove an access group](#remove-an-access-group)
- [`OAuth`](#oauth)
  - [Start an OAuth authorization](#start-an-oauth-authorization)
  - [Exchange a code or refresh token](#exchange-a-code-or-refresh-token)
  - [Revoke a refresh token](#revoke-a-refresh-token)
  - [Authorization server metadata](#authorization-server-metadata)

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
| Response | [`List<ApiDocument>`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/ApiDocument.kt) |

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
| Response | [`List<ApiDocument>`](./scalar-java-core/src/main/kotlin/com/scalar/models/registry/ApiDocument.kt) |

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
        .accessGroup(AccessGroup.builder().accessGroupSlug("x").build())
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
        .accessGroup(AccessGroup.builder().accessGroupSlug("x").build())
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
| Response | [`List<Schema>`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/Schema.kt) |

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
| Response | [`VersionCreateResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/schemas/version/VersionCreateResponse.kt) |

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
        .accessGroup(AccessGroup.builder().accessGroupSlug("x").build())
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
        .accessGroup(AccessGroup.builder().accessGroupSlug("x").build())
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
                .cardColor("#2a2f45")
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
| Response | [`List<LoginPortal>`](./scalar-java-core/src/main/kotlin/com/scalar/models/loginPortals/LoginPortal.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var loginPortal = client.loginPortals().list();

System.out.println(loginPortal);
```

## `AccessGroups`

Access Groups

### Create an access group

Create a group for the current team. Requires docs edit permission and the access groups billing feature. Domains are exact email domains, without wildcards or implicit subdomain matching.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/accessGroups/AccessGroupCreateParams.kt) |
| Response | [`AccessGroupCreateResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/accessGroups/AccessGroupCreateResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var accessGroup = client.accessGroups().create();

System.out.println(accessGroup);
```

### Get an access group

Get a group and its email and domain allowlists by slug.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupRetrieveParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/accessGroups/AccessGroupRetrieveParams.kt) |
| Response | [`AccessGroupRetrieveResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/accessGroups/AccessGroupRetrieveResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.accessGroups.AccessGroupRetrieveParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

AccessGroupRetrieveParams params = AccessGroupRetrieveParams.builder().slug("slug").build();
var accessGroup = client.accessGroups().retrieve(params);

System.out.println(accessGroup);
```

### Update an access group

Update group metadata. Requires docs edit permission. After changing the slug, use the new slug in subsequent requests.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupUpdateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/accessGroups/AccessGroupUpdateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.accessGroups.AccessGroupUpdateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

AccessGroupUpdateParams params = AccessGroupUpdateParams.builder().pathSlug("pathSlug").build();
var accessGroup = client.accessGroups().update(params);

System.out.println(accessGroup);
```

### Delete an access group

Delete a group and remove its project assignments. Requires docs edit permission.

| Direction | Type |
| --- | --- |
| Request | [`AccessGroupDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/accessGroups/AccessGroupDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.accessGroups.AccessGroupDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

AccessGroupDeleteParams params = AccessGroupDeleteParams.builder().slug("slug").build();
var accessGroup = client.accessGroups().delete(params);

System.out.println(accessGroup);
```

### `AccessGroups Domains`

Access Groups

#### Add an allowed email domain

Allow an exact email domain in a group. Requires docs edit permission. A group supports up to 1000 domains.

| Direction | Type |
| --- | --- |
| Request | [`DomainCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/accessGroups/domains/DomainCreateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.accessGroups.domains.DomainCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

DomainCreateParams params = DomainCreateParams.builder().slug("slug").domain("").build();
var domain = client.accessGroups().domains().create(params);

System.out.println(domain);
```

#### Remove an allowed email domain

Remove an exact email domain from a group. Requires docs edit permission. Other allowed domains and emails are preserved.

| Direction | Type |
| --- | --- |
| Request | [`DomainDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/accessGroups/domains/DomainDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.accessGroups.domains.DomainDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

DomainDeleteParams params = DomainDeleteParams.builder().slug("slug").domain("").build();
var domain = client.accessGroups().domains().delete(params);

System.out.println(domain);
```

## `Rules`

Rules

### List all rules

List all rulesets in a namespace.

| Direction | Type |
| --- | --- |
| Request | [`RuleListRulesetsParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/RuleListRulesetsParams.kt) |
| Response | [`List<Rule>`](./scalar-java-core/src/main/kotlin/com/scalar/models/rules/Rule.kt) |

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
        .accessGroup(AccessGroup.builder().accessGroupSlug("x").build())
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
        .accessGroup(AccessGroup.builder().accessGroupSlug("x").build())
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
| Response | [`List<Theme>`](./scalar-java-core/src/main/kotlin/com/scalar/models/themes/Theme.kt) |

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
| Response | [`List<Team>`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/Team.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var team = client.teams().list();

System.out.println(team);
```

### `Teams Members`

Teams

#### List team members

List the members of the current team, along with the invites still outstanding.

| Direction | Type |
| --- | --- |
| Request | [`MemberListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/members/MemberListParams.kt) |
| Response | [`MemberListResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/members/MemberListResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var member = client.teams().members().list();

System.out.println(member);
```

#### Change a member role

Change what a member of the current team is allowed to do.

| Direction | Type |
| --- | --- |
| Request | [`MemberUpdateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/members/MemberUpdateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.teams.invites.Role;
import com.scalar.models.teams.members.MemberUpdateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

MemberUpdateParams params = MemberUpdateParams.builder().uid("uidxx").role(Role.OWNER).build();
var member = client.teams().members().update(params);

System.out.println(member);
```

#### Remove a member

Remove someone from the current team.

| Direction | Type |
| --- | --- |
| Request | [`MemberDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/members/MemberDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.teams.members.MemberDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

MemberDeleteParams params = MemberDeleteParams.builder().uid("uidxx").build();
var member = client.teams().members().delete(params);

System.out.println(member);
```

### `Teams Invites`

Teams

#### Invite a member

Invite someone to the current team by email.

| Direction | Type |
| --- | --- |
| Request | [`InviteMemberParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/invites/InviteMemberParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.teams.invites.InviteMemberParams;
import com.scalar.models.teams.invites.Role;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InviteMemberParams params =
    InviteMemberParams.builder().email("user@example.com").role(Role.OWNER).build();
var invite = client.teams().invites().member(params);

System.out.println(invite);
```

#### Resend an invite

Send the invite email again.

| Direction | Type |
| --- | --- |
| Request | [`InviteResendParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/invites/InviteResendParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.teams.invites.InviteResendParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InviteResendParams params = InviteResendParams.builder().uid("uidxx").build();
var invite = client.teams().invites().resend(params);

System.out.println(invite);
```

#### Cancel an invite

Withdraw an invite that has not been accepted.

| Direction | Type |
| --- | --- |
| Request | [`InviteCancelParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/teams/invites/InviteCancelParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.teams.invites.InviteCancelParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InviteCancelParams params = InviteCancelParams.builder().uid("uidxx").build();
var invite = client.teams().invites().cancel(params);

System.out.println(invite);
```

## `ScalarDocs`

Scalar Docs

### List all projects

List all guide projects.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListGuidesParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListGuidesParams.kt) |
| Response | [`List<GithubProject>`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/GithubProject.kt) |

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

### List all docs projects

List every docs project on the team.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListProjectsParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListProjectsParams.kt) |
| Response | [`ScalarDocListProjectsResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListProjectsResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var scalarDoc = client.scalarDocs().listProjects();

System.out.println(scalarDoc);
```

### Create a docs project

Create a docs project. Omit `provider` to have Scalar host the repository.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocCreateProjectParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocCreateProjectParams.kt) |
| Response | [`DocsProject`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/DocsProject.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocCreateProjectParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocCreateProjectParams params =
    ScalarDocCreateProjectParams.builder()
        .name("")
        .provider(ScalarDocCreateProjectParams.Provider.of("forgejo"))
        .build();
var scalarDoc = client.scalarDocs().createProject(params);

System.out.println(scalarDoc);
```

### Get a docs project

Get a single docs project by its slug.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocRetrieveProjectParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocRetrieveProjectParams.kt) |
| Response | [`DocsProject`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/DocsProject.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocRetrieveProjectParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocRetrieveProjectParams params =
    ScalarDocRetrieveProjectParams.builder().slug("slug").build();
var scalarDoc = client.scalarDocs().retrieveProject(params);

System.out.println(scalarDoc);
```

### Update a docs project

Update project settings. Set `isPrivate` with `accessGroups` to put the site behind a login.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocUpdateProjectParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocUpdateProjectParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocUpdateProjectParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocUpdateProjectParams params =
    ScalarDocUpdateProjectParams.builder().slug("slug").build();
var scalarDoc = client.scalarDocs().updateProject(params);

System.out.println(scalarDoc);
```

### Delete a docs project

Delete a docs project, its deploys, its publish records and its cached builds.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocDeleteProjectParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocDeleteProjectParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocDeleteProjectParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocDeleteProjectParams params =
    ScalarDocDeleteProjectParams.builder().slug("slug").build();
var scalarDoc = client.scalarDocs().deleteProject(params);

System.out.println(scalarDoc);
```

### Publish a docs project

Start a build and deploy. The returned `publishUid` identifies the publish record.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocPublishProjectParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocPublishProjectParams.kt) |
| Response | [`ScalarDocPublishProjectResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocPublishProjectResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocPublishProjectParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocPublishProjectParams params =
    ScalarDocPublishProjectParams.builder().slug("slug").build();
var scalarDoc = client.scalarDocs().publishProject(params);

System.out.println(scalarDoc);
```

### Read the site config

Read `scalar.config.json` straight from the project repository, without cloning it. `baseToken` is the compare-and-swap handle for a later write.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListProjectConfigParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListProjectConfigParams.kt) |
| Response | [`ScalarDocListProjectConfigResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListProjectConfigResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocListProjectConfigParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocListProjectConfigParams params =
    ScalarDocListProjectConfigParams.builder().slug("slug").build();
var scalarDoc = client.scalarDocs().listProjectConfig(params);

System.out.println(scalarDoc);
```

### Write the site config

Commit `scalar.config.json` straight to the project repository. Pass the `baseToken` from the read this edit was based on; a conflict means the file moved underneath it.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocUpdateProjectConfigParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocUpdateProjectConfigParams.kt) |
| Response | [`ScalarDocUpdateProjectConfigResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocUpdateProjectConfigResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocUpdateProjectConfigParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocUpdateProjectConfigParams params =
    ScalarDocUpdateProjectConfigParams.builder().slug("slug").content("").build();
var scalarDoc = client.scalarDocs().updateProjectConfig(params);

System.out.println(scalarDoc);
```

### Get the site domains

The domains the project serves on — the Scalar-hosted one and the custom one, when set.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListProjectDomainParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListProjectDomainParams.kt) |
| Response | [`ScalarDocListProjectDomainResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListProjectDomainResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocListProjectDomainParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocListProjectDomainParams params =
    ScalarDocListProjectDomainParams.builder().slug("slug").build();
var scalarDoc = client.scalarDocs().listProjectDomain(params);

System.out.println(scalarDoc);
```

### Check domain DNS

Whether the project custom domain points at Scalar yet. `expected` is the CNAME record to create; `found` is what resolves today. A project with no custom domain reports `verified` with no expected record, because Scalar serves its own subdomain directly.

| Direction | Type |
| --- | --- |
| Request | [`ScalarDocListProjectDomainStatusParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListProjectDomainStatusParams.kt) |
| Response | [`ScalarDocListProjectDomainStatusResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/scalarDocs/ScalarDocListProjectDomainStatusResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.scalarDocs.ScalarDocListProjectDomainStatusParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ScalarDocListProjectDomainStatusParams params =
    ScalarDocListProjectDomainStatusParams.builder().slug("slug").build();
var scalarDoc = client.scalarDocs().listProjectDomainStatus(params);

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
| Response | [`User`](./scalar-java-core/src/main/kotlin/com/scalar/models/authentication/User.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var authentication = client.authentication().listCurrentUser();

System.out.println(authentication);
```

## `Sdks`

SDKs

### List all SDKs

List every SDK on the team.

| Direction | Type |
| --- | --- |
| Request | [`SdkListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/SdkListParams.kt) |
| Response | [`SdkListResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/SdkListResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var sdk = client.sdks().list();

System.out.println(sdk);
```

### Create an SDK

Create an SDK from an API document, targeting one or more languages.

| Direction | Type |
| --- | --- |
| Request | [`SdkCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/SdkCreateParams.kt) |
| Response | [`Uid`](./scalar-java-core/src/main/kotlin/com/scalar/models/Uid.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.SdkCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SdkCreateParams params =
    SdkCreateParams.builder()
        .apiUid("xxxxx")
        .languages(java.util.List.of(SdkCreateParams.Language.of("typescript")))
        .build();
var sdk = client.sdks().create(params);

System.out.println(sdk);
```

### Get an SDK

Get a single SDK by its uid.

| Direction | Type |
| --- | --- |
| Request | [`SdkRetrieveParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/SdkRetrieveParams.kt) |
| Response | [`Sdk`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/Sdk.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.SdkRetrieveParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SdkRetrieveParams params = SdkRetrieveParams.builder().uid("uidxx").build();
var sdk = client.sdks().retrieve(params);

System.out.println(sdk);
```

### Update an SDK

Update SDK metadata, its linked API, or its config.

| Direction | Type |
| --- | --- |
| Request | [`SdkUpdateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/SdkUpdateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.SdkUpdateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SdkUpdateParams params = SdkUpdateParams.builder().uid("uidxx").build();
var sdk = client.sdks().update(params);

System.out.println(sdk);
```

### Delete an SDK

Delete an SDK and every version it holds.

| Direction | Type |
| --- | --- |
| Request | [`SdkDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/SdkDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.SdkDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SdkDeleteParams params = SdkDeleteParams.builder().uid("uidxx").build();
var sdk = client.sdks().delete(params);

System.out.println(sdk);
```

### Build an SDK

Start a build. Omit `version` to build the current work — the open draft, else the latest version — and the resolved version comes back in the response.

| Direction | Type |
| --- | --- |
| Request | [`SdkBuildParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/SdkBuildParams.kt) |
| Response | [`SdkBuildResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/SdkBuildResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.SdkBuildParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

SdkBuildParams params = SdkBuildParams.builder().uid("uidxx").build();
var sdk = client.sdks().build(params);

System.out.println(sdk);
```

### `Sdks Versions`

SDKs

#### Create an SDK version

Create a new SDK version against a specific API version.

| Direction | Type |
| --- | --- |
| Request | [`VersionCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/versions/VersionCreateParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.versions.VersionCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

VersionCreateParams params =
    VersionCreateParams.builder().uid("uidxx").version("").apiVersion("").build();
var version = client.sdks().versions().create(params);

System.out.println(version);
```

#### Delete an SDK version

Permanently delete one version of an SDK.

| Direction | Type |
| --- | --- |
| Request | [`VersionDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/versions/VersionDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.versions.VersionDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

VersionDeleteParams params =
    VersionDeleteParams.builder().uid("uidxx").version("version").build();
var version = client.sdks().versions().delete(params);

System.out.println(version);
```

### `Sdks Repositories`

SDKs

#### Link a repository

Link one language target to a GitHub repository, so builds sync there.

| Direction | Type |
| --- | --- |
| Request | [`RepositoryLinkParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/repositories/RepositoryLinkParams.kt) |
| Response | [`RepositoryLinkResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/repositories/RepositoryLinkResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.repositories.RepositoryLinkParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RepositoryLinkParams params =
    RepositoryLinkParams.builder()
        .uid("uidxx")
        .language(RepositoryLinkParams.Language.of("typescript"))
        .repositoryId(0L)
        .baseBranch("")
        .build();
var repository = client.sdks().repositories().link(params);

System.out.println(repository);
```

#### Unlink a repository

Unlink one language target from its repository.

| Direction | Type |
| --- | --- |
| Request | [`RepositoryUnlinkParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/repositories/RepositoryUnlinkParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.repositories.RepositoryUnlinkParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RepositoryUnlinkParams params =
    RepositoryUnlinkParams.builder()
        .uid("uidxx")
        .language(RepositoryUnlinkParams.Language.of("typescript"))
        .build();
var repository = client.sdks().repositories().unlink(params);

System.out.println(repository);
```

#### Update publishing settings

Toggle publish-on-merge and the release settings for a linked target.

| Direction | Type |
| --- | --- |
| Request | [`RepositoryUpdatePublishingParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/sdks/repositories/RepositoryUpdatePublishingParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.sdks.repositories.RepositoryUpdatePublishingParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

RepositoryUpdatePublishingParams params =
    RepositoryUpdatePublishingParams.builder()
        .uid("uidxx")
        .language(RepositoryUpdatePublishingParams.Language.of("typescript"))
        .publishOnMerge(false)
        .build();
var repository = client.sdks().repositories().updatePublishing(params);

System.out.println(repository);
```

## `Mcp`

### `Mcp Servers`

MCP

#### List all MCP servers

List every MCP server on the team.

| Direction | Type |
| --- | --- |
| Request | [`ServerListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/ServerListParams.kt) |
| Response | [`List<McpServer>`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/McpServer.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var server = client.mcp().servers().list();

System.out.println(server);
```

#### Create an MCP server

Create an MCP server over one or more API document versions. The response carries the server and its first installation.

| Direction | Type |
| --- | --- |
| Request | [`ServerCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/ServerCreateParams.kt) |
| Response | [`ServerCreateResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/ServerCreateResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.ServerCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ServerCreateParams params = ServerCreateParams.builder().name("x").build();
var server = client.mcp().servers().create(params);

System.out.println(server);
```

#### Get an MCP server

Get a single MCP server by its id.

| Direction | Type |
| --- | --- |
| Request | [`ServerRetrieveParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/ServerRetrieveParams.kt) |
| Response | [`McpServer`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/McpServer.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.ServerRetrieveParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ServerRetrieveParams params = ServerRetrieveParams.builder().id("id").build();
var server = client.mcp().servers().retrieve(params);

System.out.println(server);
```

#### Update an MCP server

Update MCP server metadata and which tools it exposes.

| Direction | Type |
| --- | --- |
| Request | [`ServerUpdateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/ServerUpdateParams.kt) |
| Response | [`McpServer`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/McpServer.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.ServerUpdateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ServerUpdateParams params = ServerUpdateParams.builder().id("id").build();
var server = client.mcp().servers().update(params);

System.out.println(server);
```

#### Delete an MCP server

Delete an MCP server and every installation it serves.

| Direction | Type |
| --- | --- |
| Request | [`ServerDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/ServerDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.ServerDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

ServerDeleteParams params = ServerDeleteParams.builder().id("id").build();
var server = client.mcp().servers().delete(params);

System.out.println(server);
```

#### `Mcp Servers Installations`

MCP

##### List installations

List the installations of an MCP server. An installation is what an MCP client connects to.

| Direction | Type |
| --- | --- |
| Request | [`InstallationListParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/installations/InstallationListParams.kt) |
| Response | [`List<McpInstallationListItem>`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/installations/McpInstallationListItem.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.installations.InstallationListParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InstallationListParams params = InstallationListParams.builder().id("id").build();
var installation = client.mcp().servers().installations().list(params);

System.out.println(installation);
```

##### Create an installation

Create an installation of an MCP server. `documentAuth` holds the credentials the server presents to the upstream API and is never returned.

| Direction | Type |
| --- | --- |
| Request | [`InstallationCreateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/installations/InstallationCreateParams.kt) |
| Response | [`McpInstallation`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/McpInstallation.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.installations.InstallationCreateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InstallationCreateParams params =
    InstallationCreateParams.builder()
        .id("id")
        .name("x")
        .documentAuth(InstallationCreateParams.DocumentAuth.builder().build())
        .build();
var installation = client.mcp().servers().installations().create(params);

System.out.println(installation);
```

##### Get an installation

Get a single installation of an MCP server.

| Direction | Type |
| --- | --- |
| Request | [`InstallationRetrieveParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/installations/InstallationRetrieveParams.kt) |
| Response | [`McpInstallation`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/McpInstallation.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.installations.InstallationRetrieveParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InstallationRetrieveParams params =
    InstallationRetrieveParams.builder().id("id").installationId("installationId").build();
var installation = client.mcp().servers().installations().retrieve(params);

System.out.println(installation);
```

##### Update an installation

Update an installation. Set `isPrivate` and add access groups to put it behind a login.

| Direction | Type |
| --- | --- |
| Request | [`InstallationUpdateParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/installations/InstallationUpdateParams.kt) |
| Response | [`McpInstallation`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/McpInstallation.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.installations.InstallationUpdateParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InstallationUpdateParams params =
    InstallationUpdateParams.builder().id("id").installationId("installationId").build();
var installation = client.mcp().servers().installations().update(params);

System.out.println(installation);
```

##### Delete an installation

Delete an installation of an MCP server.

| Direction | Type |
| --- | --- |
| Request | [`InstallationDeleteParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/installations/InstallationDeleteParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.installations.InstallationDeleteParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InstallationDeleteParams params =
    InstallationDeleteParams.builder().id("id").installationId("installationId").build();
var installation = client.mcp().servers().installations().delete(params);

System.out.println(installation);
```

##### Add an access group

Let an access group reach a private installation.

| Direction | Type |
| --- | --- |
| Request | [`InstallationCreateAccessGroupParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/installations/InstallationCreateAccessGroupParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.installations.InstallationCreateAccessGroupParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InstallationCreateAccessGroupParams params =
    InstallationCreateAccessGroupParams.builder()
        .id("id")
        .installationId("installationId")
        .accessGroupUid("xxxxx")
        .build();
var installation = client.mcp().servers().installations().createAccessGroup(params);

System.out.println(installation);
```

##### Remove an access group

Stop an access group reaching a private installation.

| Direction | Type |
| --- | --- |
| Request | [`InstallationDeleteAccessGroupParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/mcp/servers/installations/InstallationDeleteAccessGroupParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.mcp.servers.installations.InstallationDeleteAccessGroupParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

InstallationDeleteAccessGroupParams params =
    InstallationDeleteAccessGroupParams.builder()
        .id("id")
        .installationId("installationId")
        .accessGroupUid("xxxxx")
        .build();
var installation = client.mcp().servers().installations().deleteAccessGroup(params);

System.out.println(installation);
```

## `OAuth`

OAuth

### Start an OAuth authorization

Authorization endpoint (RFC 6749 §4.1.1 with PKCE, RFC 7636). Validates the request and sends the user to the Scalar dashboard to approve it; the user returns to `redirect_uri` with a `code` to exchange at the token endpoint. Only `response_type=code` with `code_challenge_method=S256` is supported.

| Direction | Type |
| --- | --- |
| Request | [`OAuthOauthAuthorizeParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/oAuth/OAuthOauthAuthorizeParams.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var oAuth = client.oAuth().oauthAuthorize();

System.out.println(oAuth);
```

### Exchange a code or refresh token

Token endpoint (RFC 6749 §4.1.3 and §6). Accepts `application/x-www-form-urlencoded`. Confidential clients authenticate with HTTP Basic or `client_secret` in the body; public clients send `client_id` alone. The `authorization_code` grant needs `code`, `redirect_uri` and `code_verifier`; the `refresh_token` grant needs `refresh_token` and may narrow `scope`.

| Direction | Type |
| --- | --- |
| Request | [`OAuthOauthTokenParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/oAuth/OAuthOauthTokenParams.kt) |
| Response | [`OAuthOauthTokenResponse`](./scalar-java-core/src/main/kotlin/com/scalar/models/oAuth/OAuthOauthTokenResponse.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.oAuth.OAuthOauthTokenParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

OAuthOauthTokenParams params = OAuthOauthTokenParams.builder().grantType("").build();
var oAuth = client.oAuth().oauthToken(params);

System.out.println(oAuth);
```

### Revoke a refresh token

Revocation endpoint (RFC 7009). Revokes the refresh token and every token issued alongside it. The client authenticates as it does at the token endpoint. Responds 200 whether or not the token was live, as the RFC requires.

| Direction | Type |
| --- | --- |
| Request | [`OAuthOauthRevokeParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/oAuth/OAuthOauthRevokeParams.kt) |
| Response | [`OauthError?`](./scalar-java-core/src/main/kotlin/com/scalar/models/oAuth/OauthError.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;
import com.scalar.models.oAuth.OAuthOauthRevokeParams;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

OAuthOauthRevokeParams params = OAuthOauthRevokeParams.builder().token("").build();
var oAuth = client.oAuth().oauthRevoke(params);

System.out.println(oAuth);
```

### Authorization server metadata

Discovery document for OAuth clients (RFC 8414): where the endpoints are and what they support.

| Direction | Type |
| --- | --- |
| Request | [`OAuthOauthAuthorizationServerMetadataParams`](./scalar-java-core/src/main/kotlin/com/scalar/models/oAuth/OAuthOauthAuthorizationServerMetadataParams.kt) |
| Response | [`OauthAuthorizationServerMetadata`](./scalar-java-core/src/main/kotlin/com/scalar/models/oAuth/OauthAuthorizationServerMetadata.kt) |

```java
import com.scalar.client.ScalarClient;
import com.scalar.client.okhttp.ScalarOkHttpClient;

ScalarClient client =
    ScalarOkHttpClient.builder().bearerAuth(System.getenv("BEARER_AUTH")).build();

var oAuth = client.oAuth().oauthAuthorizationServerMetadata();

System.out.println(oAuth);
```
