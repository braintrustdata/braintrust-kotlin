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
import com.braintrustdata.api.models.View
import com.braintrustdata.api.models.ViewCreateParams
import com.braintrustdata.api.models.ViewDeleteParams
import com.braintrustdata.api.models.ViewListPageAsync
import com.braintrustdata.api.models.ViewListPageResponse
import com.braintrustdata.api.models.ViewListParams
import com.braintrustdata.api.models.ViewReplaceParams
import com.braintrustdata.api.models.ViewRetrieveParams
import com.braintrustdata.api.models.ViewUpdateParams

class ViewServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ViewServiceAsync {

    private val withRawResponse: ViewServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ViewServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(params: ViewCreateParams, requestOptions: RequestOptions): View =
        // post /v1/view
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: ViewRetrieveParams,
        requestOptions: RequestOptions,
    ): View =
        // get /v1/view/{view_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(params: ViewUpdateParams, requestOptions: RequestOptions): View =
        // patch /v1/view/{view_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: ViewListParams,
        requestOptions: RequestOptions,
    ): ViewListPageAsync =
        // get /v1/view
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: ViewDeleteParams, requestOptions: RequestOptions): View =
        // delete /v1/view/{view_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun replace(params: ViewReplaceParams, requestOptions: RequestOptions): View =
        // put /v1/view
        withRawResponse().replace(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ViewServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<View> =
            jsonHandler<View>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: ViewCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<View> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "view")
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

        private val retrieveHandler: Handler<View> =
            jsonHandler<View>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: ViewRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<View> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("viewId", params.viewId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "view", params._pathParam(0))
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

        private val updateHandler: Handler<View> =
            jsonHandler<View>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(
            params: ViewUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<View> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("viewId", params.viewId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .addPathSegments("v1", "view", params._pathParam(0))
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

        private val listHandler: Handler<ViewListPageResponse> =
            jsonHandler<ViewListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: ViewListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ViewListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "view")
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
                        ViewListPageAsync.builder()
                            .service(ViewServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<View> =
            jsonHandler<View>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: ViewDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<View> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("viewId", params.viewId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "view", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
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

        private val replaceHandler: Handler<View> =
            jsonHandler<View>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun replace(
            params: ViewReplaceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<View> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "view")
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
