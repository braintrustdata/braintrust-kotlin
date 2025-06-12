// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.checkRequired
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
import com.braintrustdata.api.models.EnvVar
import com.braintrustdata.api.models.EnvVarCreateParams
import com.braintrustdata.api.models.EnvVarDeleteParams
import com.braintrustdata.api.models.EnvVarListParams
import com.braintrustdata.api.models.EnvVarListResponse
import com.braintrustdata.api.models.EnvVarReplaceParams
import com.braintrustdata.api.models.EnvVarRetrieveParams
import com.braintrustdata.api.models.EnvVarUpdateParams

class EnvVarServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    EnvVarServiceAsync {

    private val withRawResponse: EnvVarServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): EnvVarServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(
        params: EnvVarCreateParams,
        requestOptions: RequestOptions,
    ): EnvVar =
        // post /v1/env_var
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: EnvVarRetrieveParams,
        requestOptions: RequestOptions,
    ): EnvVar =
        // get /v1/env_var/{env_var_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: EnvVarUpdateParams,
        requestOptions: RequestOptions,
    ): EnvVar =
        // patch /v1/env_var/{env_var_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: EnvVarListParams,
        requestOptions: RequestOptions,
    ): EnvVarListResponse =
        // get /v1/env_var
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: EnvVarDeleteParams,
        requestOptions: RequestOptions,
    ): EnvVar =
        // delete /v1/env_var/{env_var_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun replace(
        params: EnvVarReplaceParams,
        requestOptions: RequestOptions,
    ): EnvVar =
        // put /v1/env_var
        withRawResponse().replace(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EnvVarServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<EnvVar> =
            jsonHandler<EnvVar>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: EnvVarCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvVar> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "env_var")
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

        private val retrieveHandler: Handler<EnvVar> =
            jsonHandler<EnvVar>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: EnvVarRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvVar> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("envVarId", params.envVarId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "env_var", params._pathParam(0))
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

        private val updateHandler: Handler<EnvVar> =
            jsonHandler<EnvVar>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(
            params: EnvVarUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvVar> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("envVarId", params.envVarId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "env_var", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<EnvVarListResponse> =
            jsonHandler<EnvVarListResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun list(
            params: EnvVarListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvVarListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "env_var")
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
            }
        }

        private val deleteHandler: Handler<EnvVar> =
            jsonHandler<EnvVar>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: EnvVarDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvVar> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("envVarId", params.envVarId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "env_var", params._pathParam(0))
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

        private val replaceHandler: Handler<EnvVar> =
            jsonHandler<EnvVar>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun replace(
            params: EnvVarReplaceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvVar> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "env_var")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { replaceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
