// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.models.AISecret
import com.braintrustdata.api.models.AiSecretCreateParams
import com.braintrustdata.api.models.AiSecretDeleteParams
import com.braintrustdata.api.models.AiSecretFindAndDeleteParams
import com.braintrustdata.api.models.AiSecretListPageAsync
import com.braintrustdata.api.models.AiSecretListParams
import com.braintrustdata.api.models.AiSecretReplaceParams
import com.braintrustdata.api.models.AiSecretRetrieveParams
import com.braintrustdata.api.models.AiSecretUpdateParams
import com.braintrustdata.api.services.errorHandler
import com.braintrustdata.api.services.json
import com.braintrustdata.api.services.jsonHandler
import com.braintrustdata.api.services.withErrorHandler

class AiSecretServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AiSecretServiceAsync {

    private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<AISecret> =
        jsonHandler<AISecret>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Create a new ai_secret. If there is an existing ai_secret with the same name as the one
     * specified in the request, will return the existing ai_secret unmodified
     */
    override suspend fun create(
        params: AiSecretCreateParams,
        requestOptions: RequestOptions
    ): AISecret {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("v1", "ai_secret")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<AISecret> =
        jsonHandler<AISecret>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get an ai_secret object by its id */
    override suspend fun retrieve(
        params: AiSecretRetrieveParams,
        requestOptions: RequestOptions
    ): AISecret {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "ai_secret", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val updateHandler: Handler<AISecret> =
        jsonHandler<AISecret>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Partially update an ai_secret object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    override suspend fun update(
        params: AiSecretUpdateParams,
        requestOptions: RequestOptions
    ): AISecret {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("v1", "ai_secret", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<AiSecretListPageAsync.Response> =
        jsonHandler<AiSecretListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * List out all ai_secrets. The ai_secrets are sorted by creation date, with the most
     * recently-created ai_secrets coming first
     */
    override suspend fun list(
        params: AiSecretListParams,
        requestOptions: RequestOptions
    ): AiSecretListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "ai_secret")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { AiSecretListPageAsync.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<AISecret> =
        jsonHandler<AISecret>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete an ai_secret object by its id */
    override suspend fun delete(
        params: AiSecretDeleteParams,
        requestOptions: RequestOptions
    ): AISecret {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("v1", "ai_secret", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { deleteHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val findAndDeleteHandler: Handler<AISecret> =
        jsonHandler<AISecret>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete a single ai_secret */
    override suspend fun findAndDelete(
        params: AiSecretFindAndDeleteParams,
        requestOptions: RequestOptions
    ): AISecret {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("v1", "ai_secret")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { findAndDeleteHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val replaceHandler: Handler<AISecret> =
        jsonHandler<AISecret>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Create or replace ai_secret. If there is an existing ai_secret with the same name as the one
     * specified in the request, will replace the existing ai_secret with the provided fields
     */
    override suspend fun replace(
        params: AiSecretReplaceParams,
        requestOptions: RequestOptions
    ): AISecret {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PUT)
                .addPathSegments("v1", "ai_secret")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { replaceHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
