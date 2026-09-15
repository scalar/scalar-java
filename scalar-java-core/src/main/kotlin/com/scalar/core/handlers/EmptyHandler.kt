@file:JvmName("EmptyHandler")

package com.scalar.core.handlers

import com.scalar.core.http.HttpResponse
import com.scalar.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
