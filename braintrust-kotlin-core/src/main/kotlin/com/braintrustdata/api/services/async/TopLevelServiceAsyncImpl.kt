// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.errors.BraintrustError
import com.braintrustdata.api.models.TopLevelHelloWorldParams
import com.braintrustdata.api.services.errorHandler
import com.braintrustdata.api.services.stringHandler
import com.braintrustdata.api.services.withErrorHandler

class TopLevelServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : TopLevelServiceAsync {

    private val errorHandler: Handler<BraintrustError> = errorHandler(clientOptions.jsonMapper)

    private val helloWorldHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

    /** Default endpoint. Simply replies with 'Hello, World!'. Authorization is not required */
    override suspend fun helloWorld(
        params: TopLevelHelloWorldParams,
        requestOptions: RequestOptions
    ): String {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("v1")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { helloWorldHandler.handle(it) }
        }
    }
}
