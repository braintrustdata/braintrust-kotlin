// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.TopLevelHelloWorldParams
import com.google.errorprone.annotations.MustBeClosed

interface TopLevelServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Default endpoint. Simply replies with 'Hello, World!'. Authorization is not
     * required
     */
    suspend fun helloWorld(params: TopLevelHelloWorldParams = TopLevelHelloWorldParams.none(), requestOptions: RequestOptions = RequestOptions.none()): String

    /** @see [helloWorld] */
    suspend fun helloWorld(requestOptions: RequestOptions): String = helloWorld(TopLevelHelloWorldParams.none(), requestOptions)

    /**
     * A view of [TopLevelServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1`, but is otherwise the same as
         * [TopLevelServiceAsync.helloWorld].
         */
        @MustBeClosed
        suspend fun helloWorld(params: TopLevelHelloWorldParams = TopLevelHelloWorldParams.none(), requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<String>

        /** @see [helloWorld] */
        @MustBeClosed
        suspend fun helloWorld(requestOptions: RequestOptions): HttpResponseFor<String> = helloWorld(TopLevelHelloWorldParams.none(), requestOptions)
    }
}
