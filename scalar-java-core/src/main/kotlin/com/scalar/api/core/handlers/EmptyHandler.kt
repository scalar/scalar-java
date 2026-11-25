@file:JvmName("EmptyHandler")

package com.scalar.api.core.handlers

import com.scalar.api.core.http.HttpResponse
import com.scalar.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
