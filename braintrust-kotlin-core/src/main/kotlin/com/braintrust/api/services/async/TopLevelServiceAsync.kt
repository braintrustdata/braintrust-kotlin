// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrust.api.services.async

import com.braintrust.api.core.RequestOptions
import com.braintrust.api.models.TopLevelHelloWorldParams

interface TopLevelServiceAsync {

    /** Default endpoint. Simply replies with 'Hello, World!'. Authorization is not required */
    suspend fun helloWorld(
        params: TopLevelHelloWorldParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): String
}
