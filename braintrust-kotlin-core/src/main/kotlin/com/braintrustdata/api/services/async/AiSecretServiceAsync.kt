// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.AISecret
import com.braintrustdata.api.models.AiSecretCreateParams
import com.braintrustdata.api.models.AiSecretDeleteParams
import com.braintrustdata.api.models.AiSecretFindAndDeleteParams
import com.braintrustdata.api.models.AiSecretListPageAsync
import com.braintrustdata.api.models.AiSecretListParams
import com.braintrustdata.api.models.AiSecretReplaceParams
import com.braintrustdata.api.models.AiSecretRetrieveParams
import com.braintrustdata.api.models.AiSecretUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface AiSecretServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Create a new ai_secret. If there is an existing ai_secret with the same name as the one
     * specified in the request, will return the existing ai_secret unmodified
     */
    suspend fun create(
        params: AiSecretCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AISecret

    /** Get an ai_secret object by its id */
    suspend fun retrieve(
        params: AiSecretRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AISecret

    /**
     * Partially update an ai_secret object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        params: AiSecretUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AISecret

    /**
     * List out all ai_secrets. The ai_secrets are sorted by creation date, with the most
     * recently-created ai_secrets coming first
     */
    suspend fun list(
        params: AiSecretListParams = AiSecretListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AiSecretListPageAsync

    /**
     * List out all ai_secrets. The ai_secrets are sorted by creation date, with the most
     * recently-created ai_secrets coming first
     */
    suspend fun list(requestOptions: RequestOptions): AiSecretListPageAsync =
        list(AiSecretListParams.none(), requestOptions)

    /** Delete an ai_secret object by its id */
    suspend fun delete(
        params: AiSecretDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AISecret

    /** Delete a single ai_secret */
    suspend fun findAndDelete(
        params: AiSecretFindAndDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AISecret

    /**
     * Create or replace ai_secret. If there is an existing ai_secret with the same name as the one
     * specified in the request, will replace the existing ai_secret with the provided fields
     */
    suspend fun replace(
        params: AiSecretReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AISecret

    /**
     * A view of [AiSecretServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/ai_secret`, but is otherwise the same as
         * [AiSecretServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: AiSecretCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AISecret>

        /**
         * Returns a raw HTTP response for `get /v1/ai_secret/{ai_secret_id}`, but is otherwise the
         * same as [AiSecretServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: AiSecretRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AISecret>

        /**
         * Returns a raw HTTP response for `patch /v1/ai_secret/{ai_secret_id}`, but is otherwise
         * the same as [AiSecretServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            params: AiSecretUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AISecret>

        /**
         * Returns a raw HTTP response for `get /v1/ai_secret`, but is otherwise the same as
         * [AiSecretServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: AiSecretListParams = AiSecretListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AiSecretListPageAsync>

        /**
         * Returns a raw HTTP response for `get /v1/ai_secret`, but is otherwise the same as
         * [AiSecretServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<AiSecretListPageAsync> =
            list(AiSecretListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/ai_secret/{ai_secret_id}`, but is otherwise
         * the same as [AiSecretServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: AiSecretDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AISecret>

        /**
         * Returns a raw HTTP response for `delete /v1/ai_secret`, but is otherwise the same as
         * [AiSecretServiceAsync.findAndDelete].
         */
        @MustBeClosed
        suspend fun findAndDelete(
            params: AiSecretFindAndDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AISecret>

        /**
         * Returns a raw HTTP response for `put /v1/ai_secret`, but is otherwise the same as
         * [AiSecretServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: AiSecretReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AISecret>
    }
}
