package com.scalar.core.http

import com.scalar.core.closeWhenPhantomReachable
import com.scalar.core.http.AsyncStreamResponse.Handler
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

/**
 * A delegating wrapper around an `AsyncStreamResponse` that closes it once it's only phantom
 * reachable.
 *
 * This class ensures the `AsyncStreamResponse` is closed even if the user forgets to close it.
 */
internal class PhantomReachableClosingAsyncStreamResponse<T>(
    private val asyncStreamResponse: AsyncStreamResponse<T>
) : AsyncStreamResponse<T> {

    /**
     * An object used for keeping `asyncStreamResponse` open while the object is still reachable.
     */
    // `Any()`, not the reference's `Object()`: the two compile to the same `new java.lang.Object`,
    // but kotlinc warns on the latter, and this is the only file in the generated runtime that
    // would raise one — which would stand in the way of ever building generated SDKs with -Werror.
    private val reachabilityTracker = Any()

    init {
        closeWhenPhantomReachable(reachabilityTracker, asyncStreamResponse::close)
    }

    override fun subscribe(handler: Handler<T>): AsyncStreamResponse<T> = apply {
        asyncStreamResponse.subscribe(TrackedHandler(handler, reachabilityTracker))
    }

    override fun subscribe(handler: Handler<T>, executor: Executor): AsyncStreamResponse<T> =
        apply {
            asyncStreamResponse.subscribe(TrackedHandler(handler, reachabilityTracker), executor)
        }

    override fun onCompleteFuture(): CompletableFuture<Void?> =
        asyncStreamResponse.onCompleteFuture()

    override fun close() = asyncStreamResponse.close()
}

/**
 * A wrapper around a `Handler` that also references a `reachabilityTracker` object.
 *
 * Referencing the `reachabilityTracker` object prevents it from getting reclaimed while the handler
 * is still reachable.
 */
private class TrackedHandler<T>(
    private val handler: Handler<T>,
    private val reachabilityTracker: Any,
) : Handler<T> {
    override fun onNext(value: T) = handler.onNext(value)

    override fun onComplete(error: Optional<Throwable>) = handler.onComplete(error)
}
