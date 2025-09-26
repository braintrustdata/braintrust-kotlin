// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

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

interface EnvVarService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EnvVarService

    /**
     * Create a new env_var. If there is an existing env_var with the same name as the one specified
     * in the request, will return the existing env_var unmodified
     */
    fun create(
        params: EnvVarCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /** Get an env_var object by its id */
    fun retrieve(
        envVarId: String,
        params: EnvVarRetrieveParams = EnvVarRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar = retrieve(params.toBuilder().envVarId(envVarId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        params: EnvVarRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /** @see retrieve */
    fun retrieve(envVarId: String, requestOptions: RequestOptions): EnvVar =
        retrieve(envVarId, EnvVarRetrieveParams.none(), requestOptions)

    /**
     * Partially update an env_var object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    fun update(
        envVarId: String,
        params: EnvVarUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar = update(params.toBuilder().envVarId(envVarId).build(), requestOptions)

    /** @see update */
    fun update(
        params: EnvVarUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /**
     * List out all env_vars. The env_vars are sorted by creation date, with the most
     * recently-created env_vars coming first
     */
    fun list(
        params: EnvVarListParams = EnvVarListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVarListResponse

    /** @see list */
    fun list(requestOptions: RequestOptions): EnvVarListResponse =
        list(EnvVarListParams.none(), requestOptions)

    /** Delete an env_var object by its id */
    fun delete(
        envVarId: String,
        params: EnvVarDeleteParams = EnvVarDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar = delete(params.toBuilder().envVarId(envVarId).build(), requestOptions)

    /** @see delete */
    fun delete(
        params: EnvVarDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /** @see delete */
    fun delete(envVarId: String, requestOptions: RequestOptions): EnvVar =
        delete(envVarId, EnvVarDeleteParams.none(), requestOptions)

    /**
     * Create or replace env_var. If there is an existing env_var with the same name as the one
     * specified in the request, will replace the existing env_var with the provided fields
     */
    fun replace(
        params: EnvVarReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EnvVar

    /** A view of [EnvVarService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EnvVarService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/env_var`, but is otherwise the same as
         * [EnvVarService.create].
         */
        @MustBeClosed
        fun create(
            params: EnvVarCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>

        /**
         * Returns a raw HTTP response for `get /v1/env_var/{env_var_id}`, but is otherwise the same
         * as [EnvVarService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            envVarId: String,
            params: EnvVarRetrieveParams = EnvVarRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar> =
            retrieve(params.toBuilder().envVarId(envVarId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: EnvVarRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(envVarId: String, requestOptions: RequestOptions): HttpResponseFor<EnvVar> =
            retrieve(envVarId, EnvVarRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/env_var/{env_var_id}`, but is otherwise the
         * same as [EnvVarService.update].
         */
        @MustBeClosed
        fun update(
            envVarId: String,
            params: EnvVarUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar> =
            update(params.toBuilder().envVarId(envVarId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            params: EnvVarUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>

        /**
         * Returns a raw HTTP response for `get /v1/env_var`, but is otherwise the same as
         * [EnvVarService.list].
         */
        @MustBeClosed
        fun list(
            params: EnvVarListParams = EnvVarListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVarListResponse>

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<EnvVarListResponse> =
            list(EnvVarListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/env_var/{env_var_id}`, but is otherwise the
         * same as [EnvVarService.delete].
         */
        @MustBeClosed
        fun delete(
            envVarId: String,
            params: EnvVarDeleteParams = EnvVarDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar> =
            delete(params.toBuilder().envVarId(envVarId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: EnvVarDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>

        /** @see delete */
        @MustBeClosed
        fun delete(envVarId: String, requestOptions: RequestOptions): HttpResponseFor<EnvVar> =
            delete(envVarId, EnvVarDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/env_var`, but is otherwise the same as
         * [EnvVarService.replace].
         */
        @MustBeClosed
        fun replace(
            params: EnvVarReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EnvVar>
    }
}
