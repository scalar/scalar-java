package com.scalar.core.http

import java.util.stream.Stream

interface StreamResponse<T> : AutoCloseable {

    // A `Stream`, not a `Sequence`: a Java consumer cannot iterate a Kotlin sequence, so the stream
    // is the only iteration bridge and is declared here rather than derived from one.
    fun stream(): Stream<T>

    /** Overridden from [AutoCloseable] to not have a checked exception in its signature. */
    override fun close()
}

// `@JvmSynthetic` keeps the mangled `internal` name out of the published Java surface — a Kotlin
// `internal` member is public bytecode without it.
@JvmSynthetic
internal fun <T, R> StreamResponse<T>.map(transform: (T) -> R): StreamResponse<R> =
    object : StreamResponse<R> {
        override fun stream(): Stream<R> = this@map.stream().map(transform)

        override fun close() = this@map.close()
    }
