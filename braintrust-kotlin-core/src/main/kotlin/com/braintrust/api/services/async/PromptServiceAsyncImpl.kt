// File generated from our OpenAPI spec by Stainless.

package com.braintrust.api.services.async

import com.braintrust.api.core.ClientOptions
import com.braintrust.api.core.RequestOptions
import com.braintrust.api.core.http.HttpMethod
import com.braintrust.api.core.http.HttpRequest
import com.braintrust.api.core.http.HttpResponse.Handler
import com.braintrust.api.errors.BraintrustError
import com.braintrust.api.models.PromptCreateParams
import com.braintrust.api.models.PromptCreateResponse
import com.braintrust.api.models.PromptDeleteParams
import com.braintrust.api.models.PromptDeleteResponse
import com.braintrust.api.models.PromptFeedbackParams
import com.braintrust.api.models.PromptListPageAsync
import com.braintrust.api.models.PromptListParams
import com.braintrust.api.models.PromptReplaceParams
import com.braintrust.api.models.PromptReplaceResponse
import com.braintrust.api.models.PromptRetrieveParams
import com.braintrust.api.models.PromptRetrieveResponse
import com.braintrust.api.models.PromptUpdateParams
import com.braintrust.api.models.PromptUpdateResponse
import com.braintrust.api.services.emptyHandler
import com.braintrust.api.services.errorHandler
import com.braintrust.api.services.json
import com.braintrust.api.services.jsonHandler
import com.braintrust.api.services.withErrorHandler

class PromptServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : PromptServiceAsync {

    private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<PromptCreateResponse> =
        jsonHandler<PromptCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Create a new prompt. If there is an existing prompt in the project with the same slug as the
     * one specified in the request, will return the existing prompt unmodified
     */
    override suspend fun create(
        params: PromptCreateParams,
        requestOptions: RequestOptions
    ): PromptCreateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("v1", "prompt")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<PromptRetrieveResponse> =
        jsonHandler<PromptRetrieveResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get a prompt object by its id */
    override suspend fun retrieve(
        params: PromptRetrieveParams,
        requestOptions: RequestOptions
    ): PromptRetrieveResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "prompt", params.getPathParam(0))
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

    private val updateHandler: Handler<PromptUpdateResponse> =
        jsonHandler<PromptUpdateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Partially update a prompt object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    override suspend fun update(
        params: PromptUpdateParams,
        requestOptions: RequestOptions
    ): PromptUpdateResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PATCH)
                .addPathSegments("v1", "prompt", params.getPathParam(0))
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

    private val listHandler: Handler<PromptListPageAsync.Response> =
        jsonHandler<PromptListPageAsync.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * List out all prompts. The prompts are sorted by creation date, with the most recently-created
     * prompts coming first
     */
    override suspend fun list(
        params: PromptListParams,
        requestOptions: RequestOptions
    ): PromptListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1", "prompt")
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
                .let { PromptListPageAsync.of(this, params, it) }
        }
    }

    private val deleteHandler: Handler<PromptDeleteResponse> =
        jsonHandler<PromptDeleteResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Delete a prompt object by its id */
    override suspend fun delete(
        params: PromptDeleteParams,
        requestOptions: RequestOptions
    ): PromptDeleteResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("v1", "prompt", params.getPathParam(0))
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

    private val feedbackHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /** Log feedback for a set of prompt events */
    override suspend fun feedback(params: PromptFeedbackParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("v1", "prompt", params.getPathParam(0), "feedback")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { feedbackHandler.handle(it) }
        }
    }

    private val replaceHandler: Handler<PromptReplaceResponse> =
        jsonHandler<PromptReplaceResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * NOTE: This operation is deprecated and will be removed in a future revision of the API.
     * Create or replace a new prompt. If there is an existing prompt in the project with the same
     * slug as the one specified in the request, will return the existing prompt unmodified, will
     * replace the existing prompt with the provided fields
     */
    override suspend fun replace(
        params: PromptReplaceParams,
        requestOptions: RequestOptions
    ): PromptReplaceResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PUT)
                .addPathSegments("v1", "prompt")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { replaceHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
