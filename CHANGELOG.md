# Changelog

## [0.4.0](https://github.com/scalar/scalar-java/compare/v0.3.0...v0.4.0) (2026-11-25)


### ⚠ BREAKING CHANGES

* **api:** request-shape post /v1/sdks body.languages — required in before only (review: direction-dependent; read the hunk)
* **api:** 27 breaking changes to the SDK surface.
    - operation-coverage delete /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage delete /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage delete /v1/mcp/servers/{}/installations/{}/access-group — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{}/installations — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage patch /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage patch /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage post /v1/mcp/servers/{}/installations/{}/access-group — operation only in before (breaking: the new snapshot no longer has it)
    - response-shape get /v1/mcp/servers→[].createdAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape get /v1/mcp/servers→[].updatedAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape get /v1/mcp/servers→[].id — field only in before (breaking: removed; uid, domain, namespace (and 1 more) appeared in its place, likely a rename)
    - response-shape post /v1/mcp/servers→.server.createdAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape post /v1/mcp/servers→.server.updatedAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape post /v1/mcp/servers→.server.id — field only in before (breaking: removed; uid, domain, namespace appeared in its place, likely a rename)
    - response-shape post /v1/mcp/servers→.installation — field only in before (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/McpInstallation.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerDeleteParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerRetrieveParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerUpdateParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/installations/InstallationCreateAccessGroupParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationDeleteAccessGroupParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationDeleteParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationListParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationRetrieveParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationUpdateParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/McpInstallationListItem.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
* **api:** 9 breaking changes to the SDK surface.
    - Added required property `sdk.current`.
    - Property `sdk.currentVersion` type changed from `version` to `string`.
    - Added required property `sdk.latestVersion`.
    - Removed optional property `sdk.apiVersion`.
    - Property `sdk_version.version` type changed from `version` to `string`.
    - Property `sdk_version.createdAt` is now required.
    - Removed required property `sdk_version.apiVersion`.
    - Removed required property `sdk_version.status`.
    - Removed optional property `sdk_version.publishedAt`.
* **api:** Added required property `github_project.chatInsightsEnabled`.
* **api:** 3 breaking changes to the SDK surface.
    - Property `api_document.tags` type changed from `string` to `unknown`.
    - Property `github_project.accessGroups` type changed from `string` to `unknown`.
    - Property `docs_project.accessGroups` type changed from `string` to `unknown`.
* **api:** 8 breaking changes to the SDK surface.
    - Removed body field `autoAddOperations` from `mcp.servers.update`.
    - Removed body field `isPrivate` from `mcp.servers.installations.update`.
    - Removed body field `loginPortalUid` from `mcp.servers.installations.update`.
    - Removed body field `documentAuth` from `mcp.servers.installations.update`.
    - Removed operation `mcp.servers.installations.create` (`POST /v1/mcp/servers/{id}/installations`).
    - Removed required property `mcp_server.autoAddOperations`.
    - Removed required property `mcp_installation.isPrivate`.
    - Removed required property `mcp_installation_list_item.isPrivate`.
* **api:** Schema `method` changed from `enum(delete | get | head | …)` to `string`.
* **api:** Configuration of `oauth2` auth scheme `OAuth2` changed.
* **api:** 10 breaking changes to the SDK surface.
    - Removed operation `oAuth.oauthAuthorize` (`GET /v1/oauth/authorize`).
    - Removed operation `oAuth.oauthToken` (`POST /v1/oauth/token`).
    - Removed operation `oAuth.oauthRevoke` (`POST /v1/oauth/revoke`).
    - Removed operation `oAuth.oauthAuthorizationServerMetadata` (`GET /.well-known/oauth-authorization-server`).
    - Removed schema `oauth_token`.
    - Removed schema `oauth_scope`.
    - Removed schema `oauth_error`.
    - Removed schema `oauth_token_request`.
    - Removed schema `oauth_revoke_request`.
    - Removed schema `oauth_authorization_server_metadata`.
* **api:** 4 breaking changes to the SDK surface.
    - Property `api_document.tags` type changed from `unknown` to `string`.
    - Property `managed_doc_version.tools` type changed from `Array<object>` to `Array<object>`.
    - Property `github_project.accessGroups` type changed from `unknown` to `string`.
    - Property `docs_project.accessGroups` type changed from `unknown` to `string`.
* **api:** 10 breaking changes to the SDK surface.
    - Removed body field `lastKnownVersionSha` from `registry.updateApiDocumentVersion`.
    - Removed body field `lastKnownVersionSha` from `registry.createApiDocumentVersion`.
    - Response of `schemas.version.create` changed from `uid` to `none`.
    - Schema `slug` shape changed.
    - Schema `namespace` shape changed.
    - Added required property `managed_doc_version.endpointCount`.
    - Removed optional property `managed_doc_version.versionSha`.
    - Schema `method` shape changed.
    - Added required property `github_project.userInfoHookUrl`.
    - Added required property `github_project.analyticsEnabled`.

### Features

* **api:** add operation accessGroups.create (+66 more changes) ([443f8c3](https://github.com/scalar/scalar-java/commit/443f8c3daf74a9380e383d3db6632ab0fb339797))
* **api:** add property github_project.chatInsightsEnabled ([510cbc0](https://github.com/scalar/scalar-java/commit/510cbc06ca9eb81d7f79b872e1aa0531733ed4b0))
* **api:** add property sdk.current (+9 more changes) ([2e8c5d3](https://github.com/scalar/scalar-java/commit/2e8c5d36b0515a8ef9b03fc86c7151485e43a356))
* **api:** initial SDK generation ([d527660](https://github.com/scalar/scalar-java/commit/d5276604fa7864c6a70601236e41a71801ef67ec))
* **api:** remove operation oAuth.oauthAuthorize (+9 more changes) ([8f31264](https://github.com/scalar/scalar-java/commit/8f312641dd13dba604c46eb7e9400410a6fff274))
* **api:** update auth scheme OAuth2 (+1 more change) ([86d2896](https://github.com/scalar/scalar-java/commit/86d28966eee4d839e1dbc58a4c8355dce595b220))
* **api:** update property api_document.tags (+3 more changes) ([9109640](https://github.com/scalar/scalar-java/commit/9109640575a424a1a9f97c2934a21080bb6d8993))
* **api:** update property api_document.tags (+3 more changes) ([0d0a8f1](https://github.com/scalar/scalar-java/commit/0d0a8f14a335b0ee8fc4b933bfef086d36035621))
* **api:** update schema method ([9e3114a](https://github.com/scalar/scalar-java/commit/9e3114afe998f12f712b7d22ef3696b72a09be70))
* **api:** update SDK surface (14 changes) ([261ab56](https://github.com/scalar/scalar-java/commit/261ab56f997caff358f804b28bdaad28d6ab3470))
* **api:** update SDK surface (15 changes) ([582f867](https://github.com/scalar/scalar-java/commit/582f867e84e41d0046e9b23a6fa8fa38d6d32e62))
* **api:** update SDK surface (2 changes) ([e188565](https://github.com/scalar/scalar-java/commit/e188565299aa808add296849db4d9c5e59af5608))
* **api:** update SDK surface (3 changes) ([3df9c0f](https://github.com/scalar/scalar-java/commit/3df9c0fde741f0fd83e27acced8b5ecd3b7ba4fe))
* **api:** update SDK surface (35 changes) ([b723f78](https://github.com/scalar/scalar-java/commit/b723f783f5b5d871691512e30790d7f0fbd2eba9))
* **api:** update SDK surface (4 changes) ([36b184e](https://github.com/scalar/scalar-java/commit/36b184ead9f825a0e8c42cc9b289a769f2463e5f))


### Chores

* **api:** regenerate SDK ([ea24e00](https://github.com/scalar/scalar-java/commit/ea24e005f3b6a58daa26401e39c1c62bba4e570f))
* **api:** regenerate SDK ([5a2e674](https://github.com/scalar/scalar-java/commit/5a2e674cfcfe7fa1e3b802f066eedd9d5018044b))
* **api:** regenerate SDK ([32ac377](https://github.com/scalar/scalar-java/commit/32ac377c48101d833437c12b0ab97be68832f87c))
* **api:** regenerate SDK ([2fc2d3a](https://github.com/scalar/scalar-java/commit/2fc2d3ac316f804992bf6d4b51547413b3665b47))
* **api:** update generated SDK content ([89ce5e5](https://github.com/scalar/scalar-java/commit/89ce5e5585f91ad7c5ccc390b118385fe7733256))
* **api:** update generated SDK content ([21b4e39](https://github.com/scalar/scalar-java/commit/21b4e3970b87090291a7aab5e5630ba1a2472f5a))
* **api:** update generated SDK content ([6700dbb](https://github.com/scalar/scalar-java/commit/6700dbb2fa21cb80112573765b623c2a03035960))

## [0.3.0](https://github.com/scalar/scalar-java/compare/v0.2.1...v0.3.0) (2026-11-25)


### ⚠ BREAKING CHANGES

* **api:** request-shape post /v1/sdks body.languages — required in before only (review: direction-dependent; read the hunk)
* **api:** 27 breaking changes to the SDK surface.
    - operation-coverage delete /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage delete /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage delete /v1/mcp/servers/{}/installations/{}/access-group — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{}/installations — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage get /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage patch /v1/mcp/servers/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage patch /v1/mcp/servers/{}/installations/{} — operation only in before (breaking: the new snapshot no longer has it)
    - operation-coverage post /v1/mcp/servers/{}/installations/{}/access-group — operation only in before (breaking: the new snapshot no longer has it)
    - response-shape get /v1/mcp/servers→[].createdAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape get /v1/mcp/servers→[].updatedAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape get /v1/mcp/servers→[].id — field only in before (breaking: removed; uid, domain, namespace (and 1 more) appeared in its place, likely a rename)
    - response-shape post /v1/mcp/servers→.server.createdAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape post /v1/mcp/servers→.server.updatedAt — typed int in after, string in before (breaking: retyped; values of the old type no longer fit)
    - response-shape post /v1/mcp/servers→.server.id — field only in before (breaking: removed; uid, domain, namespace appeared in its place, likely a rename)
    - response-shape post /v1/mcp/servers→.installation — field only in before (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/McpInstallation.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerDeleteParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerRetrieveParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/ServerUpdateParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: removed; ServerListResponse.kt appeared in its place, likely a rename)
    - types-files models/mcp/servers/installations/InstallationCreateAccessGroupParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationDeleteAccessGroupParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationDeleteParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationListParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationRetrieveParams.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/InstallationUpdateParams.kt — type file only in before (2 members: 0 matched by name and kind elsewhere in after, 2 not found) (breaking: the new snapshot no longer has it)
    - types-files models/mcp/servers/installations/McpInstallationListItem.kt — type file only in before (1 member: 0 matched by name and kind elsewhere in after, 1 not found) (breaking: the new snapshot no longer has it)
* **api:** 9 breaking changes to the SDK surface.
    - Added required property `sdk.current`.
    - Property `sdk.currentVersion` type changed from `version` to `string`.
    - Added required property `sdk.latestVersion`.
    - Removed optional property `sdk.apiVersion`.
    - Property `sdk_version.version` type changed from `version` to `string`.
    - Property `sdk_version.createdAt` is now required.
    - Removed required property `sdk_version.apiVersion`.
    - Removed required property `sdk_version.status`.
    - Removed optional property `sdk_version.publishedAt`.
* **api:** Added required property `github_project.chatInsightsEnabled`.

### Features

* **api:** add property github_project.chatInsightsEnabled ([510cbc0](https://github.com/scalar/scalar-java/commit/510cbc06ca9eb81d7f79b872e1aa0531733ed4b0))
* **api:** add property sdk.current (+9 more changes) ([2e8c5d3](https://github.com/scalar/scalar-java/commit/2e8c5d36b0515a8ef9b03fc86c7151485e43a356))
* **api:** update SDK surface (2 changes) ([e188565](https://github.com/scalar/scalar-java/commit/e188565299aa808add296849db4d9c5e59af5608))
* **api:** update SDK surface (3 changes) ([3df9c0f](https://github.com/scalar/scalar-java/commit/3df9c0fde741f0fd83e27acced8b5ecd3b7ba4fe))
* **api:** update SDK surface (35 changes) ([b723f78](https://github.com/scalar/scalar-java/commit/b723f783f5b5d871691512e30790d7f0fbd2eba9))
* **api:** update SDK surface (4 changes) ([36b184e](https://github.com/scalar/scalar-java/commit/36b184ead9f825a0e8c42cc9b289a769f2463e5f))


### Chores

* **api:** regenerate SDK ([ea24e00](https://github.com/scalar/scalar-java/commit/ea24e005f3b6a58daa26401e39c1c62bba4e570f))
* **api:** regenerate SDK ([5a2e674](https://github.com/scalar/scalar-java/commit/5a2e674cfcfe7fa1e3b802f066eedd9d5018044b))
* **api:** regenerate SDK ([32ac377](https://github.com/scalar/scalar-java/commit/32ac377c48101d833437c12b0ab97be68832f87c))
* **api:** update generated SDK content ([89ce5e5](https://github.com/scalar/scalar-java/commit/89ce5e5585f91ad7c5ccc390b118385fe7733256))
* **api:** update generated SDK content ([21b4e39](https://github.com/scalar/scalar-java/commit/21b4e3970b87090291a7aab5e5630ba1a2472f5a))

## [0.2.1](https://github.com/scalar/scalar-java/compare/v0.2.0...v0.2.1) (2026-10-16)


### Chores

* **api:** regenerate SDK ([2fc2d3a](https://github.com/scalar/scalar-java/commit/2fc2d3ac316f804992bf6d4b51547413b3665b47))

## [0.2.0](https://github.com/scalar/scalar-java/compare/v0.1.0...v0.2.0) (2026-10-14)


### ⚠ BREAKING CHANGES

* **api:** 3 breaking changes to the SDK surface.
    - Property `api_document.tags` type changed from `string` to `unknown`.
    - Property `github_project.accessGroups` type changed from `string` to `unknown`.
    - Property `docs_project.accessGroups` type changed from `string` to `unknown`.
* **api:** 8 breaking changes to the SDK surface.
    - Removed body field `autoAddOperations` from `mcp.servers.update`.
    - Removed body field `isPrivate` from `mcp.servers.installations.update`.
    - Removed body field `loginPortalUid` from `mcp.servers.installations.update`.
    - Removed body field `documentAuth` from `mcp.servers.installations.update`.
    - Removed operation `mcp.servers.installations.create` (`POST /v1/mcp/servers/{id}/installations`).
    - Removed required property `mcp_server.autoAddOperations`.
    - Removed required property `mcp_installation.isPrivate`.
    - Removed required property `mcp_installation_list_item.isPrivate`.
* **api:** Schema `method` changed from `enum(delete | get | head | …)` to `string`.
* **api:** Configuration of `oauth2` auth scheme `OAuth2` changed.
* **api:** 10 breaking changes to the SDK surface.
    - Removed operation `oAuth.oauthAuthorize` (`GET /v1/oauth/authorize`).
    - Removed operation `oAuth.oauthToken` (`POST /v1/oauth/token`).
    - Removed operation `oAuth.oauthRevoke` (`POST /v1/oauth/revoke`).
    - Removed operation `oAuth.oauthAuthorizationServerMetadata` (`GET /.well-known/oauth-authorization-server`).
    - Removed schema `oauth_token`.
    - Removed schema `oauth_scope`.
    - Removed schema `oauth_error`.
    - Removed schema `oauth_token_request`.
    - Removed schema `oauth_revoke_request`.
    - Removed schema `oauth_authorization_server_metadata`.
* **api:** 4 breaking changes to the SDK surface.
    - Property `api_document.tags` type changed from `unknown` to `string`.
    - Property `managed_doc_version.tools` type changed from `Array<object>` to `Array<object>`.
    - Property `github_project.accessGroups` type changed from `unknown` to `string`.
    - Property `docs_project.accessGroups` type changed from `unknown` to `string`.
* **api:** 10 breaking changes to the SDK surface.
    - Removed body field `lastKnownVersionSha` from `registry.updateApiDocumentVersion`.
    - Removed body field `lastKnownVersionSha` from `registry.createApiDocumentVersion`.
    - Response of `schemas.version.create` changed from `uid` to `none`.
    - Schema `slug` shape changed.
    - Schema `namespace` shape changed.
    - Added required property `managed_doc_version.endpointCount`.
    - Removed optional property `managed_doc_version.versionSha`.
    - Schema `method` shape changed.
    - Added required property `github_project.userInfoHookUrl`.
    - Added required property `github_project.analyticsEnabled`.

### Features

* **api:** add operation accessGroups.create (+66 more changes) ([443f8c3](https://github.com/scalar/scalar-java/commit/443f8c3daf74a9380e383d3db6632ab0fb339797))
* **api:** initial SDK generation ([d527660](https://github.com/scalar/scalar-java/commit/d5276604fa7864c6a70601236e41a71801ef67ec))
* **api:** remove operation oAuth.oauthAuthorize (+9 more changes) ([8f31264](https://github.com/scalar/scalar-java/commit/8f312641dd13dba604c46eb7e9400410a6fff274))
* **api:** update auth scheme OAuth2 (+1 more change) ([86d2896](https://github.com/scalar/scalar-java/commit/86d28966eee4d839e1dbc58a4c8355dce595b220))
* **api:** update property api_document.tags (+3 more changes) ([9109640](https://github.com/scalar/scalar-java/commit/9109640575a424a1a9f97c2934a21080bb6d8993))
* **api:** update property api_document.tags (+3 more changes) ([0d0a8f1](https://github.com/scalar/scalar-java/commit/0d0a8f14a335b0ee8fc4b933bfef086d36035621))
* **api:** update schema method ([9e3114a](https://github.com/scalar/scalar-java/commit/9e3114afe998f12f712b7d22ef3696b72a09be70))
* **api:** update SDK surface (14 changes) ([261ab56](https://github.com/scalar/scalar-java/commit/261ab56f997caff358f804b28bdaad28d6ab3470))
* **api:** update SDK surface (15 changes) ([582f867](https://github.com/scalar/scalar-java/commit/582f867e84e41d0046e9b23a6fa8fa38d6d32e62))


### Chores

* **api:** update generated SDK content ([6700dbb](https://github.com/scalar/scalar-java/commit/6700dbb2fa21cb80112573765b623c2a03035960))
