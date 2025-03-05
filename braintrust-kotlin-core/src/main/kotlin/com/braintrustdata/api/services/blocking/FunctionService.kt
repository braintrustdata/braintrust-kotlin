// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Function
import com.braintrustdata.api.models.FunctionCreateParams
import com.braintrustdata.api.models.FunctionDeleteParams
import com.braintrustdata.api.models.FunctionInvokeParams
import com.braintrustdata.api.models.FunctionInvokeResponse
import com.braintrustdata.api.models.FunctionListPage
import com.braintrustdata.api.models.FunctionListParams
import com.braintrustdata.api.models.FunctionReplaceParams
import com.braintrustdata.api.models.FunctionRetrieveParams
import com.braintrustdata.api.models.FunctionUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface FunctionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Create a new function. If there is an existing function in the project with the same slug as
     * the one specified in the request, will return the existing function unmodified
     */
    fun create(
        params: FunctionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /** Get a function object by its id */
    fun retrieve(
        params: FunctionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /**
     * Partially update a function object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    fun update(
        params: FunctionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /**
     * List out all functions. The functions are sorted by creation date, with the most
     * recently-created functions coming first
     */
    fun list(
        params: FunctionListParams = FunctionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionListPage

    /**
     * List out all functions. The functions are sorted by creation date, with the most
     * recently-created functions coming first
     */
    fun list(requestOptions: RequestOptions): FunctionListPage =
        list(FunctionListParams.none(), requestOptions)

    /** Delete a function object by its id */
    fun delete(
        params: FunctionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /** Invoke a function. */
    fun invoke(
        params: FunctionInvokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionInvokeResponse?

    /**
     * Create or replace function. If there is an existing function in the project with the same
     * slug as the one specified in the request, will replace the existing function with the
     * provided fields
     */
    fun replace(
        params: FunctionReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Function

    /** A view of [FunctionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/function`, but is otherwise the same as
         * [FunctionService.create].
         */
        @MustBeClosed
        fun create(
            params: FunctionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>

        /**
         * Returns a raw HTTP response for `get /v1/function/{function_id}`, but is otherwise the
         * same as [FunctionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: FunctionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>

        /**
         * Returns a raw HTTP response for `patch /v1/function/{function_id}`, but is otherwise the
         * same as [FunctionService.update].
         */
        @MustBeClosed
        fun update(
            params: FunctionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>

        /**
         * Returns a raw HTTP response for `get /v1/function`, but is otherwise the same as
         * [FunctionService.list].
         */
        @MustBeClosed
        fun list(
            params: FunctionListParams = FunctionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionListPage>

        /**
         * Returns a raw HTTP response for `get /v1/function`, but is otherwise the same as
         * [FunctionService.list].
         */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<FunctionListPage> =
            list(FunctionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/function/{function_id}`, but is otherwise the
         * same as [FunctionService.delete].
         */
        @MustBeClosed
        fun delete(
            params: FunctionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>

        /**
         * Returns a raw HTTP response for `post /v1/function/{function_id}/invoke`, but is
         * otherwise the same as [FunctionService.invoke].
         */
        @MustBeClosed
        fun invoke(
            params: FunctionInvokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionInvokeResponse?>

        /**
         * Returns a raw HTTP response for `put /v1/function`, but is otherwise the same as
         * [FunctionService.replace].
         */
        @MustBeClosed
        fun replace(
            params: FunctionReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Function>
    }
}
