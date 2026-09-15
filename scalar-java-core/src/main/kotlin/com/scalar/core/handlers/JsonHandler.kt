@file:JvmName("JsonHandler")

package com.scalar.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scalar.core.http.HttpResponse
import com.scalar.core.http.HttpResponse.Handler
import com.scalar.errors.ScalarInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw ScalarInvalidDataException("Error reading response", e)
            }
    }
