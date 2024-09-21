// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.models.Organization
import com.braintrustdata.api.models.OrganizationDeleteParams
import com.braintrustdata.api.models.OrganizationListPageAsync
import com.braintrustdata.api.models.OrganizationListParams
import com.braintrustdata.api.models.OrganizationRetrieveParams
import com.braintrustdata.api.models.OrganizationUpdateParams
import com.braintrustdata.api.services.async.organization.MemberServiceAsync
import com.braintrustdata.api.services.async.organization.MemberServiceAsyncImpl
import com.braintrustdata.api.services.errorHandler
import com.braintrustdata.api.services.json
import com.braintrustdata.api.services.jsonHandler
import com.braintrustdata.api.services.withErrorHandler

class OrganizationServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : OrganizationServiceAsync {

    private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

    private val members: MemberServiceAsync by lazy { MemberServiceAsyncImpl(clientOptions) }

    override fun members(): MemberServiceAsync = members

    private val retrieveHandler: Handler<Organization> =
        jsonHandler<Organization>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get an organization object by its id */
    override suspend fun retrieve(
        params: OrganizationRetrieveParams,
        requestOptions: RequestOptions
    ): Organization {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "organization", params.getPathParam(0))
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

    private val updateHandler: Handler<Organization> =
        jsonHandler<Organization>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Partially update an organization object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    override suspend fun update(
        params: OrganizationUpdateParams,
        requestOptions: RequestOptions
    ): Organization {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("v1", "organization", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { updateHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<OrganizationListPageAsync.Response> =
        jsonHandler<OrganizationListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * List out all organizations. The organizations are sorted by creation date, with the most
     * recently-created organizations coming first
     */
    override suspend fun list(
        params: OrganizationListParams,
        requestOptions: RequestOptions
    ): OrganizationListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "organization")
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
                .let { OrganizationListPageAsync.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<Organization> =
        jsonHandler<Organization>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete an organization object by its id */
    override suspend fun delete(
        params: OrganizationDeleteParams,
        requestOptions: RequestOptions
    ): Organization {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("v1", "organization", params.getPathParam(0))
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