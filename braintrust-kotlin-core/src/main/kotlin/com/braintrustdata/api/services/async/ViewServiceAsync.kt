// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.View
import com.braintrustdata.api.models.ViewCreateParams
import com.braintrustdata.api.models.ViewDeleteParams
import com.braintrustdata.api.models.ViewListPageAsync
import com.braintrustdata.api.models.ViewListParams
import com.braintrustdata.api.models.ViewReplaceParams
import com.braintrustdata.api.models.ViewRetrieveParams
import com.braintrustdata.api.models.ViewUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface ViewServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ViewServiceAsync

    /**
     * Create a new view. If there is an existing view with the same name as the one specified in
     * the request, will return the existing view unmodified
     */
    suspend fun create(
        params: ViewCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): View

    /** Get a view object by its id */
    suspend fun retrieve(
        viewId: String,
        params: ViewRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): View = retrieve(params.toBuilder().viewId(viewId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: ViewRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): View

    /**
     * Partially update a view object. Specify the fields to update in the payload. Any object-type
     * fields will be deep-merged with existing content. Currently we do not support removing fields
     * or setting them to null.
     */
    suspend fun update(
        viewId: String,
        params: ViewUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): View = update(params.toBuilder().viewId(viewId).build(), requestOptions)

    /** @see [update] */
    suspend fun update(
        params: ViewUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): View

    /**
     * List out all views. The views are sorted by creation date, with the most recently-created
     * views coming first
     */
    suspend fun list(
        params: ViewListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ViewListPageAsync

    /** Delete a view object by its id */
    suspend fun delete(
        viewId: String,
        params: ViewDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): View = delete(params.toBuilder().viewId(viewId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: ViewDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): View

    /**
     * Create or replace view. If there is an existing view with the same name as the one specified
     * in the request, will replace the existing view with the provided fields
     */
    suspend fun replace(
        params: ViewReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): View

    /** A view of [ViewServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ViewServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/view`, but is otherwise the same as
         * [ViewServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: ViewCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<View>

        /**
         * Returns a raw HTTP response for `get /v1/view/{view_id}`, but is otherwise the same as
         * [ViewServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            viewId: String,
            params: ViewRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<View> =
            retrieve(params.toBuilder().viewId(viewId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: ViewRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<View>

        /**
         * Returns a raw HTTP response for `patch /v1/view/{view_id}`, but is otherwise the same as
         * [ViewServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            viewId: String,
            params: ViewUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<View> = update(params.toBuilder().viewId(viewId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            params: ViewUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<View>

        /**
         * Returns a raw HTTP response for `get /v1/view`, but is otherwise the same as
         * [ViewServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ViewListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ViewListPageAsync>

        /**
         * Returns a raw HTTP response for `delete /v1/view/{view_id}`, but is otherwise the same as
         * [ViewServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            viewId: String,
            params: ViewDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<View> = delete(params.toBuilder().viewId(viewId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: ViewDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<View>

        /**
         * Returns a raw HTTP response for `put /v1/view`, but is otherwise the same as
         * [ViewServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: ViewReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<View>
    }
}
