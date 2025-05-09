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
import com.braintrustdata.api.models.SpanIFrame
import com.braintrustdata.api.models.SpanIframeCreateParams
import com.braintrustdata.api.models.SpanIframeDeleteParams
import com.braintrustdata.api.models.SpanIframeListPageAsync
import com.braintrustdata.api.models.SpanIframeListPageResponse
import com.braintrustdata.api.models.SpanIframeListParams
import com.braintrustdata.api.models.SpanIframeReplaceParams
import com.braintrustdata.api.models.SpanIframeRetrieveParams
import com.braintrustdata.api.models.SpanIframeUpdateParams

class SpanIframeServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SpanIframeServiceAsync {

    private val withRawResponse: SpanIframeServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SpanIframeServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(
        params: SpanIframeCreateParams,
        requestOptions: RequestOptions,
    ): SpanIFrame =
        // post /v1/span_iframe
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: SpanIframeRetrieveParams,
        requestOptions: RequestOptions,
    ): SpanIFrame =
        // get /v1/span_iframe/{span_iframe_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: SpanIframeUpdateParams,
        requestOptions: RequestOptions,
    ): SpanIFrame =
        // patch /v1/span_iframe/{span_iframe_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: SpanIframeListParams,
        requestOptions: RequestOptions,
    ): SpanIframeListPageAsync =
        // get /v1/span_iframe
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: SpanIframeDeleteParams,
        requestOptions: RequestOptions,
    ): SpanIFrame =
        // delete /v1/span_iframe/{span_iframe_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun replace(
        params: SpanIframeReplaceParams,
        requestOptions: RequestOptions,
    ): SpanIFrame =
        // put /v1/span_iframe
        withRawResponse().replace(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpanIframeServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<SpanIFrame> =
            jsonHandler<SpanIFrame>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: SpanIframeCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIFrame> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "span_iframe")
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

        private val retrieveHandler: Handler<SpanIFrame> =
            jsonHandler<SpanIFrame>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: SpanIframeRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIFrame> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("spanIframeId", params.spanIframeId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "span_iframe", params._pathParam(0))
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

        private val updateHandler: Handler<SpanIFrame> =
            jsonHandler<SpanIFrame>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(
            params: SpanIframeUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIFrame> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("spanIframeId", params.spanIframeId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .addPathSegments("v1", "span_iframe", params._pathParam(0))
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

        private val listHandler: Handler<SpanIframeListPageResponse> =
            jsonHandler<SpanIframeListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: SpanIframeListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIframeListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "span_iframe")
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
                        SpanIframeListPageAsync.builder()
                            .service(SpanIframeServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<SpanIFrame> =
            jsonHandler<SpanIFrame>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: SpanIframeDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIFrame> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("spanIframeId", params.spanIframeId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "span_iframe", params._pathParam(0))
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

        private val replaceHandler: Handler<SpanIFrame> =
            jsonHandler<SpanIFrame>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun replace(
            params: SpanIframeReplaceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIFrame> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "span_iframe")
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
