// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Function
import com.braintrustdata.api.models.FunctionCreateParams
import com.braintrustdata.api.models.FunctionDeleteParams
import com.braintrustdata.api.models.FunctionInvokeParams
import com.braintrustdata.api.models.FunctionInvokeResponse
import com.braintrustdata.api.models.FunctionListPageAsync
import com.braintrustdata.api.models.FunctionListParams
import com.braintrustdata.api.models.FunctionReplaceParams
import com.braintrustdata.api.models.FunctionRetrieveParams
import com.braintrustdata.api.models.FunctionUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface FunctionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): FunctionServiceAsync

    /**
     * Create a new function. If there is an existing function in the project with the same slug as
     * the one specified in the request, will return the existing function unmodified
     */
    suspend fun create(
        params: FunctionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /** Get a function object by its id */
    suspend fun retrieve(
        functionId: String,
        params: FunctionRetrieveParams = FunctionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function = retrieve(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: FunctionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /** @see [retrieve] */
    suspend fun retrieve(functionId: String, requestOptions: RequestOptions): Function =
        retrieve(functionId, FunctionRetrieveParams.none(), requestOptions)

    /**
     * Partially update a function object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        functionId: String,
        params: FunctionUpdateParams = FunctionUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function = update(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see [update] */
    suspend fun update(
        params: FunctionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /** @see [update] */
    suspend fun update(functionId: String, requestOptions: RequestOptions): Function =
        update(functionId, FunctionUpdateParams.none(), requestOptions)

    /**
     * List out all functions. The functions are sorted by creation date, with the most
     * recently-created functions coming first
     */
    suspend fun list(
        params: FunctionListParams = FunctionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): FunctionListPageAsync =
        list(FunctionListParams.none(), requestOptions)

    /** Delete a function object by its id */
    suspend fun delete(
        functionId: String,
        params: FunctionDeleteParams = FunctionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function = delete(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: FunctionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /** @see [delete] */
    suspend fun delete(functionId: String, requestOptions: RequestOptions): Function =
        delete(functionId, FunctionDeleteParams.none(), requestOptions)

    /** Invoke a function. */
    suspend fun invoke(
        functionId: String,
        params: FunctionInvokeParams = FunctionInvokeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionInvokeResponse? =
        invoke(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see [invoke] */
    suspend fun invoke(
        params: FunctionInvokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionInvokeResponse?

    /** @see [invoke] */
    suspend fun invoke(
        functionId: String,
        requestOptions: RequestOptions,
    ): FunctionInvokeResponse? = invoke(functionId, FunctionInvokeParams.none(), requestOptions)

    /**
     * Create or replace function. If there is an existing function in the project with the same
     * slug as the one specified in the request, will replace the existing function with the
     * provided fields
     */
    suspend fun replace(
        params: FunctionReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /**
     * A view of [FunctionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): FunctionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/function`, but is otherwise the same as
         * [FunctionServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: FunctionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>

        /**
         * Returns a raw HTTP response for `get /v1/function/{function_id}`, but is otherwise the
         * same as [FunctionServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            functionId: String,
            params: FunctionRetrieveParams = FunctionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function> =
            retrieve(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: FunctionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Function> =
            retrieve(functionId, FunctionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/function/{function_id}`, but is otherwise the
         * same as [FunctionServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            functionId: String,
            params: FunctionUpdateParams = FunctionUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function> =
            update(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            params: FunctionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Function> =
            update(functionId, FunctionUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/function`, but is otherwise the same as
         * [FunctionServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: FunctionListParams = FunctionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<FunctionListPageAsync> =
            list(FunctionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/function/{function_id}`, but is otherwise the
         * same as [FunctionServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            functionId: String,
            params: FunctionDeleteParams = FunctionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function> =
            delete(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: FunctionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Function> =
            delete(functionId, FunctionDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/function/{function_id}/invoke`, but is
         * otherwise the same as [FunctionServiceAsync.invoke].
         */
        @MustBeClosed
        suspend fun invoke(
            functionId: String,
            params: FunctionInvokeParams = FunctionInvokeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionInvokeResponse?> =
            invoke(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see [invoke] */
        @MustBeClosed
        suspend fun invoke(
            params: FunctionInvokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionInvokeResponse?>

        /** @see [invoke] */
        @MustBeClosed
        suspend fun invoke(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionInvokeResponse?> =
            invoke(functionId, FunctionInvokeParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/function`, but is otherwise the same as
         * [FunctionServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: FunctionReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>
    }
}
