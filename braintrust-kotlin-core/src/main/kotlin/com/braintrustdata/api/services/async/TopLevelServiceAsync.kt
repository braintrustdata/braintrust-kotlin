// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.TopLevelHelloWorldParams

interface TopLevelServiceAsync {

    /** Default endpoint. Simply replies with 'Hello, World!'. Authorization is not required */
    suspend fun helloWorld(
        params: TopLevelHelloWorldParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): String
}
