@file:JvmName("StringHandler")

package com.scalar.core.handlers

import com.scalar.core.http.HttpResponse
import com.scalar.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
