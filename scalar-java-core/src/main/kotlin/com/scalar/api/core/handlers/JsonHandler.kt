@file:JvmName("JsonHandler")

package com.scalar.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.scalar.api.core.http.HttpResponse
import com.scalar.api.core.http.HttpResponse.Handler
import com.scalar.api.core.http.boundedBody
import com.scalar.api.errors.ScalarInvalidDataException

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                // Bounded: a body is parsed whole, so its size is the memory it costs.
                jsonMapper.readValue(response.boundedBody(), jacksonTypeRef())
            } catch (e: Exception) {
                throw ScalarInvalidDataException("Error reading response", e)
            }
    }
