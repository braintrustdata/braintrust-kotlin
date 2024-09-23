// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.ApiKey
import com.braintrustdata.api.models.ApiKeyResourceCreateParams
import com.braintrustdata.api.models.ApiKeyResourceDeleteParams
import com.braintrustdata.api.models.ApiKeyResourceListPageAsync
import com.braintrustdata.api.models.ApiKeyResourceListParams
import com.braintrustdata.api.models.ApiKeyResourceRetrieveParams
import com.braintrustdata.api.models.CreateApiKeyOutput

interface ApiKeyResourceServiceAsync {

    /**
     * Create a new api_key. It is possible to have multiple API keys with the same name. There is
     * no de-duplication
     */
    suspend fun create(
        params: ApiKeyResourceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CreateApiKeyOutput

    /** Get an api_key object by its id */
    suspend fun retrieve(
        params: ApiKeyResourceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ApiKey

    /**
     * List out all api_keys. The api_keys are sorted by creation date, with the most
     * recently-created api_keys coming first
     */
    suspend fun list(
        params: ApiKeyResourceListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ApiKeyResourceListPageAsync

    /** Delete an api_key object by its id */
    suspend fun delete(
        params: ApiKeyResourceDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ApiKey
}
