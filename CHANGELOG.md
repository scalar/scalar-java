# Changelog

## [0.2.0](https://github.com/scalar/scalar-java/compare/v0.1.0...v0.2.0) (2026-10-09)


### ⚠ BREAKING CHANGES

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
* **api:** update property api_document.tags (+3 more changes) ([0d0a8f1](https://github.com/scalar/scalar-java/commit/0d0a8f14a335b0ee8fc4b933bfef086d36035621))
* **api:** update schema method ([9e3114a](https://github.com/scalar/scalar-java/commit/9e3114afe998f12f712b7d22ef3696b72a09be70))
* **api:** update SDK surface (15 changes) ([582f867](https://github.com/scalar/scalar-java/commit/582f867e84e41d0046e9b23a6fa8fa38d6d32e62))


### Chores

* **api:** update generated SDK content ([6700dbb](https://github.com/scalar/scalar-java/commit/6700dbb2fa21cb80112573765b623c2a03035960))
