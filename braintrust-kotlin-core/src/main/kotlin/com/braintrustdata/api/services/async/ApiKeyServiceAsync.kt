// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.ApiKey
import com.braintrustdata.api.models.ApiKeyCreateParams
import com.braintrustdata.api.models.ApiKeyDeleteParams
import com.braintrustdata.api.models.ApiKeyListPageAsync
import com.braintrustdata.api.models.ApiKeyListParams
import com.braintrustdata.api.models.ApiKeyRetrieveParams
import com.braintrustdata.api.models.CreateApiKeyOutput
import com.google.errorprone.annotations.MustBeClosed

interface ApiKeyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Create a new api_key. It is possible to have multiple API keys with the same name. There is
     * no de-duplication
     */
    suspend fun create(
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreateApiKeyOutput

    /** Get an api_key object by its id */
    suspend fun retrieve(
        params: ApiKeyRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKey

    /**
     * List out all api_keys. The api_keys are sorted by creation date, with the most
     * recently-created api_keys coming first
     */
    suspend fun list(
        params: ApiKeyListParams = ApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): ApiKeyListPageAsync =
        list(ApiKeyListParams.none(), requestOptions)

    /** Delete an api_key object by its id */
    suspend fun delete(
        params: ApiKeyDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKey

    /**
     * A view of [ApiKeyServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/api_key`, but is otherwise the same as
         * [ApiKeyServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreateApiKeyOutput>

        /**
         * Returns a raw HTTP response for `get /v1/api_key/{api_key_id}`, but is otherwise the same
         * as [ApiKeyServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: ApiKeyRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKey>

        /**
         * Returns a raw HTTP response for `get /v1/api_key`, but is otherwise the same as
         * [ApiKeyServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ApiKeyListParams = ApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<ApiKeyListPageAsync> =
            list(ApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/api_key/{api_key_id}`, but is otherwise the
         * same as [ApiKeyServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: ApiKeyDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKey>
    }
}
