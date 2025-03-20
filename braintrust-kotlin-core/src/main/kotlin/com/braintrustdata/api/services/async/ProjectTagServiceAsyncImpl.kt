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
import com.braintrustdata.api.models.ProjectTag
import com.braintrustdata.api.models.ProjectTagCreateParams
import com.braintrustdata.api.models.ProjectTagDeleteParams
import com.braintrustdata.api.models.ProjectTagListPageAsync
import com.braintrustdata.api.models.ProjectTagListParams
import com.braintrustdata.api.models.ProjectTagReplaceParams
import com.braintrustdata.api.models.ProjectTagRetrieveParams
import com.braintrustdata.api.models.ProjectTagUpdateParams

class ProjectTagServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ProjectTagServiceAsync {

    private val withRawResponse: ProjectTagServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ProjectTagServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(
        params: ProjectTagCreateParams,
        requestOptions: RequestOptions,
    ): ProjectTag =
        // post /v1/project_tag
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: ProjectTagRetrieveParams,
        requestOptions: RequestOptions,
    ): ProjectTag =
        // get /v1/project_tag/{project_tag_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: ProjectTagUpdateParams,
        requestOptions: RequestOptions,
    ): ProjectTag =
        // patch /v1/project_tag/{project_tag_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: ProjectTagListParams,
        requestOptions: RequestOptions,
    ): ProjectTagListPageAsync =
        // get /v1/project_tag
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: ProjectTagDeleteParams,
        requestOptions: RequestOptions,
    ): ProjectTag =
        // delete /v1/project_tag/{project_tag_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun replace(
        params: ProjectTagReplaceParams,
        requestOptions: RequestOptions,
    ): ProjectTag =
        // put /v1/project_tag
        withRawResponse().replace(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ProjectTagServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<ProjectTag> =
            jsonHandler<ProjectTag>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: ProjectTagCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "project_tag")
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

        private val retrieveHandler: Handler<ProjectTag> =
            jsonHandler<ProjectTag>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: ProjectTagRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "project_tag", params._pathParam(0))
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

        private val updateHandler: Handler<ProjectTag> =
            jsonHandler<ProjectTag>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(
            params: ProjectTagUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .addPathSegments("v1", "project_tag", params._pathParam(0))
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

        private val listHandler: Handler<ProjectTagListPageAsync.Response> =
            jsonHandler<ProjectTagListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: ProjectTagListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTagListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "project_tag")
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
                        ProjectTagListPageAsync.of(
                            ProjectTagServiceAsyncImpl(clientOptions),
                            params,
                            it,
                        )
                    }
            }
        }

        private val deleteHandler: Handler<ProjectTag> =
            jsonHandler<ProjectTag>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: ProjectTagDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "project_tag", params._pathParam(0))
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

        private val replaceHandler: Handler<ProjectTag> =
            jsonHandler<ProjectTag>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun replace(
            params: ProjectTagReplaceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "project_tag")
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
