@file:JvmName("HttpRequestBodies")

package com.braintrustdata.api.services

import com.braintrustdata.api.core.http.HttpRequestBody
import com.braintrustdata.api.errors.BraintrustException
import com.fasterxml.jackson.databind.json.JsonMapper
import java.io.OutputStream
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder

internal inline fun <reified T> json(
    jsonMapper: JsonMapper,
    value: T,
): HttpRequestBody {
    return object : HttpRequestBody {
        override fun writeTo(outputStream: OutputStream) {
            try {
                return jsonMapper.writeValue(outputStream, value)
            } catch (e: Exception) {
                throw BraintrustException("Error writing request", e)
            }
        }

        override fun contentType(): String = "application/json"

        override fun repeatable(): Boolean = true

        override fun close() {}
    }
}

internal fun multipartFormData(
    files: Map<String, ByteArray>,
): HttpRequestBody {
    val builder = MultipartEntityBuilder.create()
    files.forEach { file, bytes -> builder.addBinaryBody(file, bytes) }
    val entity = builder.build()

    return object : HttpRequestBody {
        override fun writeTo(outputStream: OutputStream) {
            try {
                return entity.writeTo(outputStream)
            } catch (e: Exception) {
                throw BraintrustException("Error writing request", e)
            }
        }

        override fun contentType(): String = entity.contentType

        override fun repeatable(): Boolean = entity.isRepeatable

        override fun close() = entity.close()
    }
}
