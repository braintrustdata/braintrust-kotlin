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
import com.braintrustdata.api.models.Experiment
import com.braintrustdata.api.models.ExperimentCreateParams
import com.braintrustdata.api.models.ExperimentDeleteParams
import com.braintrustdata.api.models.ExperimentFeedbackParams
import com.braintrustdata.api.models.ExperimentFetchParams
import com.braintrustdata.api.models.ExperimentFetchPostParams
import com.braintrustdata.api.models.ExperimentInsertParams
import com.braintrustdata.api.models.ExperimentListPageAsync
import com.braintrustdata.api.models.ExperimentListPageResponse
import com.braintrustdata.api.models.ExperimentListParams
import com.braintrustdata.api.models.ExperimentRetrieveParams
import com.braintrustdata.api.models.ExperimentSummarizeParams
import com.braintrustdata.api.models.ExperimentUpdateParams
import com.braintrustdata.api.models.FeedbackResponseSchema
import com.braintrustdata.api.models.FetchExperimentEventsResponse
import com.braintrustdata.api.models.InsertEventsResponse
import com.braintrustdata.api.models.SummarizeExperimentResponse

class ExperimentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ExperimentServiceAsync {

    private val withRawResponse: ExperimentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ExperimentServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(
        params: ExperimentCreateParams,
        requestOptions: RequestOptions,
    ): Experiment =
        // post /v1/experiment
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: ExperimentRetrieveParams,
        requestOptions: RequestOptions,
    ): Experiment =
        // get /v1/experiment/{experiment_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: ExperimentUpdateParams,
        requestOptions: RequestOptions,
    ): Experiment =
        // patch /v1/experiment/{experiment_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: ExperimentListParams,
        requestOptions: RequestOptions,
    ): ExperimentListPageAsync =
        // get /v1/experiment
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: ExperimentDeleteParams,
        requestOptions: RequestOptions,
    ): Experiment =
        // delete /v1/experiment/{experiment_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun feedback(
        params: ExperimentFeedbackParams,
        requestOptions: RequestOptions,
    ): FeedbackResponseSchema =
        // post /v1/experiment/{experiment_id}/feedback
        withRawResponse().feedback(params, requestOptions).parse()

    override suspend fun fetch(
        params: ExperimentFetchParams,
        requestOptions: RequestOptions,
    ): FetchExperimentEventsResponse =
        // get /v1/experiment/{experiment_id}/fetch
        withRawResponse().fetch(params, requestOptions).parse()

    override suspend fun fetchPost(
        params: ExperimentFetchPostParams,
        requestOptions: RequestOptions,
    ): FetchExperimentEventsResponse =
        // post /v1/experiment/{experiment_id}/fetch
        withRawResponse().fetchPost(params, requestOptions).parse()

    override suspend fun insert(
        params: ExperimentInsertParams,
        requestOptions: RequestOptions,
    ): InsertEventsResponse =
        // post /v1/experiment/{experiment_id}/insert
        withRawResponse().insert(params, requestOptions).parse()

    override suspend fun summarize(
        params: ExperimentSummarizeParams,
        requestOptions: RequestOptions,
    ): SummarizeExperimentResponse =
        // get /v1/experiment/{experiment_id}/summarize
        withRawResponse().summarize(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ExperimentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<Experiment> =
            jsonHandler<Experiment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: ExperimentCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Experiment> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "experiment")
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

        private val retrieveHandler: Handler<Experiment> =
            jsonHandler<Experiment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: ExperimentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Experiment> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "experiment", params._pathParam(0))
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

        private val updateHandler: Handler<Experiment> =
            jsonHandler<Experiment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(
            params: ExperimentUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Experiment> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .addPathSegments("v1", "experiment", params._pathParam(0))
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

        private val listHandler: Handler<ExperimentListPageResponse> =
            jsonHandler<ExperimentListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: ExperimentListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExperimentListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "experiment")
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
                        ExperimentListPageAsync.builder()
                            .service(ExperimentServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Experiment> =
            jsonHandler<Experiment>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: ExperimentDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Experiment> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "experiment", params._pathParam(0))
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

        private val feedbackHandler: Handler<FeedbackResponseSchema> =
            jsonHandler<FeedbackResponseSchema>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun feedback(
            params: ExperimentFeedbackParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FeedbackResponseSchema> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "experiment", params._pathParam(0), "feedback")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { feedbackHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val fetchHandler: Handler<FetchExperimentEventsResponse> =
            jsonHandler<FetchExperimentEventsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun fetch(
            params: ExperimentFetchParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchExperimentEventsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "experiment", params._pathParam(0), "fetch")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { fetchHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val fetchPostHandler: Handler<FetchExperimentEventsResponse> =
            jsonHandler<FetchExperimentEventsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun fetchPost(
            params: ExperimentFetchPostParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchExperimentEventsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "experiment", params._pathParam(0), "fetch")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { fetchPostHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val insertHandler: Handler<InsertEventsResponse> =
            jsonHandler<InsertEventsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun insert(
            params: ExperimentInsertParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InsertEventsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "experiment", params._pathParam(0), "insert")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { insertHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val summarizeHandler: Handler<SummarizeExperimentResponse> =
            jsonHandler<SummarizeExperimentResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun summarize(
            params: ExperimentSummarizeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SummarizeExperimentResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "experiment", params._pathParam(0), "summarize")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { summarizeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
