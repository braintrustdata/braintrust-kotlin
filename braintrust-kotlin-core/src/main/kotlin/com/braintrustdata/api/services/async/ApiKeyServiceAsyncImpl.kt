// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.handlers.errorHandler
import com.braintrustdata.api.core.handlers.jsonHandler
import com.braintrustdata.api.core.handlers.withErrorHandler
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.core.http.json
import com.braintrustdata.api.core.http.parseable
import com.braintrustdata.api.core.prepareAsync
import com.braintrustdata.api.models.ApiKey
import com.braintrustdata.api.models.ApiKeyCreateParams
import com.braintrustdata.api.models.ApiKeyDeleteParams
import com.braintrustdata.api.models.ApiKeyListPageAsync
import com.braintrustdata.api.models.ApiKeyListParams
import com.braintrustdata.api.models.ApiKeyRetrieveParams
import com.braintrustdata.api.models.CreateApiKeyOutput

class ApiKeyServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ApiKeyServiceAsync {

    private val withRawResponse: ApiKeyServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ApiKeyServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions,
    ): CreateApiKeyOutput =
        // post /v1/api_key
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions,
    ): ApiKey =
        // get /v1/api_key/{api_key_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: ApiKeyListParams,
        requestOptions: RequestOptions,
    ): ApiKeyListPageAsync =
        // get /v1/api_key
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions,
    ): ApiKey =
        // delete /v1/api_key/{api_key_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ApiKeyServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<CreateApiKeyOutput> =
            jsonHandler<CreateApiKeyOutput>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CreateApiKeyOutput> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "api_key")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<ApiKey> =
            jsonHandler<ApiKey>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKey> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "api_key", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<ApiKeyListPageAsync.Response> =
            jsonHandler<ApiKeyListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: ApiKeyListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "api_key")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        ApiKeyListPageAsync.of(ApiKeyServiceAsyncImpl(clientOptions), params, it)
                    }
            }
        }

        private val deleteHandler: Handler<ApiKey> =
            jsonHandler<ApiKey>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKey> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "api_key", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
