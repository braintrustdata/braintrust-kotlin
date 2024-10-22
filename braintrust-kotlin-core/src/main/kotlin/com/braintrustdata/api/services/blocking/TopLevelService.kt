// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.TopLevelHelloWorldParams

interface TopLevelService {

    /** Default endpoint. Simply replies with 'Hello, World!'. Authorization is not required */
    fun helloWorld(
        params: TopLevelHelloWorldParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): String
}
