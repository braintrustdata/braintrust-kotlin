// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Prompt
import com.braintrustdata.api.models.PromptCreateParams
import com.braintrustdata.api.models.PromptDeleteParams
import com.braintrustdata.api.models.PromptListPageAsync
import com.braintrustdata.api.models.PromptListParams
import com.braintrustdata.api.models.PromptReplaceParams
import com.braintrustdata.api.models.PromptRetrieveParams
import com.braintrustdata.api.models.PromptUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface PromptServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PromptServiceAsync

    /**
     * Create a new prompt. If there is an existing prompt in the project with the same slug as the
     * one specified in the request, will return the existing prompt unmodified
     */
    suspend fun create(
        params: PromptCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Prompt

    /** Get a prompt object by its id */
    suspend fun retrieve(
        promptId: String,
        params: PromptRetrieveParams = PromptRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Prompt = retrieve(params.toBuilder().promptId(promptId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: PromptRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Prompt

    /** @see [retrieve] */
    suspend fun retrieve(promptId: String, requestOptions: RequestOptions): Prompt =
        retrieve(promptId, PromptRetrieveParams.none(), requestOptions)

    /**
     * Partially update a prompt object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        promptId: String,
        params: PromptUpdateParams = PromptUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Prompt = update(params.toBuilder().promptId(promptId).build(), requestOptions)

    /** @see [update] */
    suspend fun update(
        params: PromptUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Prompt

    /** @see [update] */
    suspend fun update(promptId: String, requestOptions: RequestOptions): Prompt =
        update(promptId, PromptUpdateParams.none(), requestOptions)

    /**
     * List out all prompts. The prompts are sorted by creation date, with the most recently-created
     * prompts coming first
     */
    suspend fun list(
        params: PromptListParams = PromptListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PromptListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): PromptListPageAsync =
        list(PromptListParams.none(), requestOptions)

    /** Delete a prompt object by its id */
    suspend fun delete(
        promptId: String,
        params: PromptDeleteParams = PromptDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Prompt = delete(params.toBuilder().promptId(promptId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: PromptDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Prompt

    /** @see [delete] */
    suspend fun delete(promptId: String, requestOptions: RequestOptions): Prompt =
        delete(promptId, PromptDeleteParams.none(), requestOptions)

    /**
     * Create or replace prompt. If there is an existing prompt in the project with the same slug as
     * the one specified in the request, will replace the existing prompt with the provided fields
     */
    suspend fun replace(
        params: PromptReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Prompt

    /**
     * A view of [PromptServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): PromptServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/prompt`, but is otherwise the same as
         * [PromptServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: PromptCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Prompt>

        /**
         * Returns a raw HTTP response for `get /v1/prompt/{prompt_id}`, but is otherwise the same
         * as [PromptServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            promptId: String,
            params: PromptRetrieveParams = PromptRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Prompt> =
            retrieve(params.toBuilder().promptId(promptId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: PromptRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Prompt>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            promptId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Prompt> = retrieve(promptId, PromptRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/prompt/{prompt_id}`, but is otherwise the same
         * as [PromptServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            promptId: String,
            params: PromptUpdateParams = PromptUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Prompt> =
            update(params.toBuilder().promptId(promptId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            params: PromptUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Prompt>

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            promptId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Prompt> = update(promptId, PromptUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/prompt`, but is otherwise the same as
         * [PromptServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: PromptListParams = PromptListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PromptListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<PromptListPageAsync> =
            list(PromptListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/prompt/{prompt_id}`, but is otherwise the
         * same as [PromptServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            promptId: String,
            params: PromptDeleteParams = PromptDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Prompt> =
            delete(params.toBuilder().promptId(promptId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: PromptDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Prompt>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            promptId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Prompt> = delete(promptId, PromptDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/prompt`, but is otherwise the same as
         * [PromptServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: PromptReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Prompt>
    }
}
