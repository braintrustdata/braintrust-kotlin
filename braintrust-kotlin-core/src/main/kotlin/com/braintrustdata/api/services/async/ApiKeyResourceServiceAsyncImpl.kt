// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.models.ApiKey
import com.braintrustdata.api.models.ApiKeyResourceCreateParams
import com.braintrustdata.api.models.ApiKeyResourceDeleteParams
import com.braintrustdata.api.models.ApiKeyResourceListPageAsync
import com.braintrustdata.api.models.ApiKeyResourceListParams
import com.braintrustdata.api.models.ApiKeyResourceRetrieveParams
import com.braintrustdata.api.models.CreateApiKeyOutput
import com.braintrustdata.api.services.errorHandler
import com.braintrustdata.api.services.json
import com.braintrustdata.api.services.jsonHandler
import com.braintrustdata.api.services.withErrorHandler

class ApiKeyResourceServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ApiKeyResourceServiceAsync {

    private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<CreateApiKeyOutput> =
        jsonHandler<CreateApiKeyOutput>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Create a new api_key. It is possible to have multiple API keys with the same name. There is
     * no de-duplication
     */
    override suspend fun create(
        params: ApiKeyResourceCreateParams,
        requestOptions: RequestOptions
    ): CreateApiKeyOutput {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("v1", "api_key")
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

    private val retrieveHandler: Handler<ApiKey> =
        jsonHandler<ApiKey>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get an api_key object by its id */
    override suspend fun retrieve(
        params: ApiKeyResourceRetrieveParams,
        requestOptions: RequestOptions
    ): ApiKey {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "api_key", params.getPathParam(0))
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

    private val listHandler: Handler<ApiKeyResourceListPageAsync.Response> =
        jsonHandler<ApiKeyResourceListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * List out all api_keys. The api_keys are sorted by creation date, with the most
     * recently-created api_keys coming first
     */
    override suspend fun list(
        params: ApiKeyResourceListParams,
        requestOptions: RequestOptions
    ): ApiKeyResourceListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "api_key")
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
                .let { ApiKeyResourceListPageAsync.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<ApiKey> =
        jsonHandler<ApiKey>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete an api_key object by its id */
    override suspend fun delete(
        params: ApiKeyResourceDeleteParams,
        requestOptions: RequestOptions
    ): ApiKey {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("v1", "api_key", params.getPathParam(0))
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
}