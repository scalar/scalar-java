@file:JvmName("PrepareRequest")

package com.scalar.api.core

import com.scalar.api.core.http.HttpRequest
import java.util.concurrent.CompletableFuture

@JvmSynthetic
internal fun HttpRequest.prepare(clientOptions: ClientOptions, params: Params): HttpRequest =
    checkPathSegments()
        .toBuilder()
        .putAllQueryParams(clientOptions.queryParams)
        .replaceAllQueryParams(params._queryParams())
        .putAllHeaders(clientOptions.headers)
        .replaceAllHeaders(params._headers())
        .build()

@JvmSynthetic
internal fun HttpRequest.prepareAsync(
    clientOptions: ClientOptions,
    params: Params,
): CompletableFuture<HttpRequest> =
    // This async version exists to make it easier to add async specific preparation logic in the
    // future.
    CompletableFuture.completedFuture(prepare(clientOptions, params))

/**
 * Returns this request, refusing it when a path parameter left a segment empty, `.` or `..`.
 *
 * Percent-encoding cannot help: a URL library resolves `..` by dropping the segment before it and
 * `.` by dropping itself, and an empty segment addresses the parent collection, so each would send
 * the request, with the client's credentials, to another endpoint on the same host. A path
 * parameter forwarded from end-user input is exactly where such a value comes from. The path's
 * literal segments are never any of the three, so a segment that is one was filled in by a
 * parameter.
 */
private fun HttpRequest.checkPathSegments(): HttpRequest = apply {
    pathSegments.forEach { segment ->
        require(segment.isNotEmpty() && segment != "." && segment != "..") {
            "A path parameter cannot be empty, `.` or `..`, which would address another endpoint, but the path was `${pathSegments.joinToString("/", "/")}`"
        }
    }
}
