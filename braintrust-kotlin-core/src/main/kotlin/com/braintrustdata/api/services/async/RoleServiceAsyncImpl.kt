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
import com.braintrustdata.api.models.Role
import com.braintrustdata.api.models.RoleCreateParams
import com.braintrustdata.api.models.RoleDeleteParams
import com.braintrustdata.api.models.RoleListPageAsync
import com.braintrustdata.api.models.RoleListPageResponse
import com.braintrustdata.api.models.RoleListParams
import com.braintrustdata.api.models.RoleReplaceParams
import com.braintrustdata.api.models.RoleRetrieveParams
import com.braintrustdata.api.models.RoleUpdateParams

class RoleServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RoleServiceAsync {

    private val withRawResponse: RoleServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RoleServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(params: RoleCreateParams, requestOptions: RequestOptions): Role =
        // post /v1/role
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: RoleRetrieveParams,
        requestOptions: RequestOptions,
    ): Role =
        // get /v1/role/{role_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(params: RoleUpdateParams, requestOptions: RequestOptions): Role =
        // patch /v1/role/{role_id}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: RoleListParams,
        requestOptions: RequestOptions,
    ): RoleListPageAsync =
        // get /v1/role
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: RoleDeleteParams, requestOptions: RequestOptions): Role =
        // delete /v1/role/{role_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun replace(params: RoleReplaceParams, requestOptions: RequestOptions): Role =
        // put /v1/role
        withRawResponse().replace(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RoleServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<Role> =
            jsonHandler<Role>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Role> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "role")
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

        private val retrieveHandler: Handler<Role> =
            jsonHandler<Role>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: RoleRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Role> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("roleId", params.roleId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "role", params._pathParam(0))
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

        private val updateHandler: Handler<Role> =
            jsonHandler<Role>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun update(
            params: RoleUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Role> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("roleId", params.roleId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .addPathSegments("v1", "role", params._pathParam(0))
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

        private val listHandler: Handler<RoleListPageResponse> =
            jsonHandler<RoleListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: RoleListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RoleListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "role")
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
                        RoleListPageAsync.builder()
                            .service(RoleServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Role> =
            jsonHandler<Role>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Role> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("roleId", params.roleId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "role", params._pathParam(0))
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

        private val replaceHandler: Handler<Role> =
            jsonHandler<Role>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun replace(
            params: RoleReplaceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Role> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PUT)
                    .addPathSegments("v1", "role")
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
