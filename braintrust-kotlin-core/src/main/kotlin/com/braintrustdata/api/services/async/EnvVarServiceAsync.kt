// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.EnvVar
import com.braintrustdata.api.models.EnvVarCreateParams
import com.braintrustdata.api.models.EnvVarDeleteParams
import com.braintrustdata.api.models.EnvVarListParams
import com.braintrustdata.api.models.EnvVarListResponse
import com.braintrustdata.api.models.EnvVarReplaceParams
import com.braintrustdata.api.models.EnvVarRetrieveParams
import com.braintrustdata.api.models.EnvVarUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface EnvVarServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EnvVarServiceAsync

    /**
     * Create a new env_var. If there is an existing env_var with the same name as the one specified
     * in the request, will return the existing env_var unmodified
     */
    suspend fun create(
        params: EnvVarCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /** Get an env_var object by its id */
    suspend fun retrieve(
        envVarId: String,
        params: EnvVarRetrieveParams = EnvVarRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar = retrieve(params.toBuilder().envVarId(envVarId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: EnvVarRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /** @see retrieve */
    suspend fun retrieve(envVarId: String, requestOptions: RequestOptions): EnvVar =
        retrieve(envVarId, EnvVarRetrieveParams.none(), requestOptions)

    /**
     * Partially update an env_var object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        envVarId: String,
        params: EnvVarUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar = update(params.toBuilder().envVarId(envVarId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: EnvVarUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /**
     * List out all env_vars. The env_vars are sorted by creation date, with the most
     * recently-created env_vars coming first
     */
    suspend fun list(
        params: EnvVarListParams = EnvVarListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVarListResponse

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): EnvVarListResponse =
        list(EnvVarListParams.none(), requestOptions)

    /** Delete an env_var object by its id */
    suspend fun delete(
        envVarId: String,
        params: EnvVarDeleteParams = EnvVarDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar = delete(params.toBuilder().envVarId(envVarId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: EnvVarDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /** @see delete */
    suspend fun delete(envVarId: String, requestOptions: RequestOptions): EnvVar =
        delete(envVarId, EnvVarDeleteParams.none(), requestOptions)

    /**
     * Create or replace env_var. If there is an existing env_var with the same name as the one
     * specified in the request, will replace the existing env_var with the provided fields
     */
    suspend fun replace(
        params: EnvVarReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /**
     * A view of [EnvVarServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): EnvVarServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/env_var`, but is otherwise the same as
         * [EnvVarServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: EnvVarCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>

        /**
         * Returns a raw HTTP response for `get /v1/env_var/{env_var_id}`, but is otherwise the same
         * as [EnvVarServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            envVarId: String,
            params: EnvVarRetrieveParams = EnvVarRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar> =
            retrieve(params.toBuilder().envVarId(envVarId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: EnvVarRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            envVarId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvVar> = retrieve(envVarId, EnvVarRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/env_var/{env_var_id}`, but is otherwise the
         * same as [EnvVarServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            envVarId: String,
            params: EnvVarUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar> =
            update(params.toBuilder().envVarId(envVarId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: EnvVarUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>

        /**
         * Returns a raw HTTP response for `get /v1/env_var`, but is otherwise the same as
         * [EnvVarServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: EnvVarListParams = EnvVarListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVarListResponse>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<EnvVarListResponse> =
            list(EnvVarListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/env_var/{env_var_id}`, but is otherwise the
         * same as [EnvVarServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            envVarId: String,
            params: EnvVarDeleteParams = EnvVarDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar> =
            delete(params.toBuilder().envVarId(envVarId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: EnvVarDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            envVarId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EnvVar> = delete(envVarId, EnvVarDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/env_var`, but is otherwise the same as
         * [EnvVarServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: EnvVarReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>
    }
}
