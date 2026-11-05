@file:JvmName("StringHandler")

package com.scalar.api.core.handlers

import com.scalar.api.core.http.HttpResponse
import com.scalar.api.core.http.HttpResponse.Handler
import com.scalar.api.core.http.boundedBody

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        // Bounded, since the whole body is held as one string.
        response.boundedBody().readBytes().toString(Charsets.UTF_8)
}
