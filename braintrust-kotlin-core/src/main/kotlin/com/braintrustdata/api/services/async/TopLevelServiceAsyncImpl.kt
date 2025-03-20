// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.handlers.errorHandler
import com.braintrustdata.api.core.handlers.stringHandler
import com.braintrustdata.api.core.handlers.withErrorHandler
import com.braintrustdata.api.core.http.HttpMethod
import com.braintrustdata.api.core.http.HttpRequest
import com.braintrustdata.api.core.http.HttpResponse.Handler
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.core.http.parseable
import com.braintrustdata.api.core.prepareAsync
import com.braintrustdata.api.models.TopLevelHelloWorldParams

class TopLevelServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TopLevelServiceAsync {

    private val withRawResponse: TopLevelServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TopLevelServiceAsync.WithRawResponse = withRawResponse

    override suspend fun helloWorld(
        params: TopLevelHelloWorldParams,
        requestOptions: RequestOptions,
    ): String =
        // get /v1
        withRawResponse().helloWorld(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TopLevelServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val helloWorldHandler: Handler<String> =
            stringHandler().withErrorHandler(errorHandler)

        override suspend fun helloWorld(
            params: TopLevelHelloWorldParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<String> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable { response.use { helloWorldHandler.handle(it) } }
        }
    }
}
