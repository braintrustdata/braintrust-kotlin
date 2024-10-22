// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.ApiKey
import com.braintrustdata.api.models.ApiKeyCreateParams
import com.braintrustdata.api.models.ApiKeyDeleteParams
import com.braintrustdata.api.models.ApiKeyListPage
import com.braintrustdata.api.models.ApiKeyListParams
import com.braintrustdata.api.models.ApiKeyRetrieveParams
import com.braintrustdata.api.models.CreateApiKeyOutput

interface ApiKeyService {

    /**
     * Create a new api_key. It is possible to have multiple API keys with the same name. There is
     * no de-duplication
     */
    fun create(
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CreateApiKeyOutput

    /** Get an api_key object by its id */
    fun retrieve(
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ApiKey

    /**
     * List out all api_keys. The api_keys are sorted by creation date, with the most
     * recently-created api_keys coming first
     */
    fun list(
        params: ApiKeyListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ApiKeyListPage

    /** Delete an api_key object by its id */
    fun delete(
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ApiKey
}
