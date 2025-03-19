// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
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
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.models.Function
import com.braintrustdata.api.models.FunctionCreateParams
import com.braintrustdata.api.models.FunctionDeleteParams
import com.braintrustdata.api.models.FunctionInvokeParams
import com.braintrustdata.api.models.FunctionInvokeResponse
import com.braintrustdata.api.models.FunctionListPageAsync
import com.braintrustdata.api.models.FunctionListParams
import com.braintrustdata.api.models.FunctionReplaceParams
import com.braintrustdata.api.models.FunctionRetrieveParams
import com.braintrustdata.api.models.FunctionUpdateParams

class FunctionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FunctionServiceAsync {

    private val withRawResponse: FunctionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FunctionServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(
        params: FunctionCreateParams,
        requestOptions: RequestOptions,
    ): Function =
        // post /v1/function
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: FunctionRetrieveParams,
        requestOptions: RequestOptions,
    ): Function =
        // get /v1/function/{function_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: FunctionUpdateParams,
        requestOptions: RequestOptions,
    ): Function =
        // patch /v1/function/{function_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: FunctionListParams,
        requestOptions: RequestOptions,
    ): FunctionListPageAsync =
        // get /v1/function
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: FunctionDeleteParams,
        requestOptions: RequestOptions,
    ): Function =
        // delete /v1/function/{function_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun invoke(
        params: FunctionInvokeParams,
        requestOptions: RequestOptions,
    ): FunctionInvokeResponse? =
        // post /v1/function/{function_id}/invoke
        withRawResponse().invoke(params, requestOptions).parse()

    override suspend fun replace(
        params: FunctionReplaceParams,
        requestOptions: RequestOptions,
    ): Function =
        // put /v1/function
        withRawResponse().replace(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FunctionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<Function> =
            jsonHandler<Function>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: FunctionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Function> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "function")
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

        private val retrieveHandler: Handler<Function> =
            jsonHandler<Function>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: FunctionRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Function> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "function", params._pathParam(0))
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

        private val updateHandler: Handler<Function> =
            jsonHandler<Function>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(
            params: FunctionUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Function> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .addPathSegments("v1", "function", params._pathParam(0))
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

        private val listHandler: Handler<FunctionListPageAsync.Response> =
            jsonHandler<FunctionListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: FunctionListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "function")
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
                        FunctionListPageAsync.of(
                            FunctionServiceAsyncImpl(clientOptions),
                            params,
                            it,
                        )
                    }
            }
        }

        private val deleteHandler: Handler<Function> =
            jsonHandler<Function>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: FunctionDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Function> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "function", params._pathParam(0))
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

        private val invokeHandler: Handler<FunctionInvokeResponse?> =
            jsonHandler<FunctionInvokeResponse?>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun invoke(
            params: FunctionInvokeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionInvokeResponse?> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "function", params._pathParam(0), "invoke")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { invokeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it?.validate()
                        }
                    }
            }
        }

        private val replaceHandler: Handler<Function> =
            jsonHandler<Function>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun replace(
            params: FunctionReplaceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Function> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "function")
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
