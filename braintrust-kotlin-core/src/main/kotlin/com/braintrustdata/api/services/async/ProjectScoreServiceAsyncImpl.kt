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
import com.braintrustdata.api.models.ProjectScore
import com.braintrustdata.api.models.ProjectScoreCreateParams
import com.braintrustdata.api.models.ProjectScoreDeleteParams
import com.braintrustdata.api.models.ProjectScoreListPageAsync
import com.braintrustdata.api.models.ProjectScoreListPageResponse
import com.braintrustdata.api.models.ProjectScoreListParams
import com.braintrustdata.api.models.ProjectScoreReplaceParams
import com.braintrustdata.api.models.ProjectScoreRetrieveParams
import com.braintrustdata.api.models.ProjectScoreUpdateParams

class ProjectScoreServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ProjectScoreServiceAsync {

    private val withRawResponse: ProjectScoreServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ProjectScoreServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ProjectScoreServiceAsync =
        ProjectScoreServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: ProjectScoreCreateParams,
        requestOptions: RequestOptions,
    ): ProjectScore =
        // post /v1/project_score
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: ProjectScoreRetrieveParams,
        requestOptions: RequestOptions,
    ): ProjectScore =
        // get /v1/project_score/{project_score_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: ProjectScoreUpdateParams,
        requestOptions: RequestOptions,
    ): ProjectScore =
        // patch /v1/project_score/{project_score_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: ProjectScoreListParams,
        requestOptions: RequestOptions,
    ): ProjectScoreListPageAsync =
        // get /v1/project_score
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: ProjectScoreDeleteParams,
        requestOptions: RequestOptions,
    ): ProjectScore =
        // delete /v1/project_score/{project_score_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun replace(
        params: ProjectScoreReplaceParams,
        requestOptions: RequestOptions,
    ): ProjectScore =
        // put /v1/project_score
        withRawResponse().replace(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ProjectScoreServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ProjectScoreServiceAsync.WithRawResponse =
            ProjectScoreServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<ProjectScore> =
            jsonHandler<ProjectScore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: ProjectScoreCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScore> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "project_score")
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

        private val retrieveHandler: Handler<ProjectScore> =
            jsonHandler<ProjectScore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: ProjectScoreRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScore> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectScoreId", params.projectScoreId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "project_score", params._pathParam(0))
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

        private val updateHandler: Handler<ProjectScore> =
            jsonHandler<ProjectScore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(
            params: ProjectScoreUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScore> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectScoreId", params.projectScoreId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "project_score", params._pathParam(0))
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

        private val listHandler: Handler<ProjectScoreListPageResponse> =
            jsonHandler<ProjectScoreListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: ProjectScoreListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScoreListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "project_score")
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
                        ProjectScoreListPageAsync.builder()
                            .service(ProjectScoreServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<ProjectScore> =
            jsonHandler<ProjectScore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: ProjectScoreDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScore> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectScoreId", params.projectScoreId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "project_score", params._pathParam(0))
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

        private val replaceHandler: Handler<ProjectScore> =
            jsonHandler<ProjectScore>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun replace(
            params: ProjectScoreReplaceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScore> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "project_score")
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
