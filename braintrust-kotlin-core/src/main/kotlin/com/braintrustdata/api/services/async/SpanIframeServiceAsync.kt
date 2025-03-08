// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.SpanIFrame
import com.braintrustdata.api.models.SpanIframeCreateParams
import com.braintrustdata.api.models.SpanIframeDeleteParams
import com.braintrustdata.api.models.SpanIframeListPageAsync
import com.braintrustdata.api.models.SpanIframeListParams
import com.braintrustdata.api.models.SpanIframeReplaceParams
import com.braintrustdata.api.models.SpanIframeRetrieveParams
import com.braintrustdata.api.models.SpanIframeUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface SpanIframeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Create a new span_iframe. If there is an existing span_iframe with the same name as the one
     * specified in the request, will return the existing span_iframe unmodified
     */
    suspend fun create(
        params: SpanIframeCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame

    /** Get a span_iframe object by its id */
    suspend fun retrieve(
        params: SpanIframeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame

    /**
     * Partially update a span_iframe object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        params: SpanIframeUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame

    /**
     * List out all span_iframes. The span_iframes are sorted by creation date, with the most
     * recently-created span_iframes coming first
     */
    suspend fun list(
        params: SpanIframeListParams = SpanIframeListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIframeListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): SpanIframeListPageAsync =
        list(SpanIframeListParams.none(), requestOptions)

    /** Delete a span_iframe object by its id */
    suspend fun delete(
        params: SpanIframeDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame

    /**
     * Create or replace span_iframe. If there is an existing span_iframe with the same name as the
     * one specified in the request, will replace the existing span_iframe with the provided fields
     */
    suspend fun replace(
        params: SpanIframeReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame

    /**
     * A view of [SpanIframeServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/span_iframe`, but is otherwise the same as
         * [SpanIframeServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: SpanIframeCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame>

        /**
         * Returns a raw HTTP response for `get /v1/span_iframe/{span_iframe_id}`, but is otherwise
         * the same as [SpanIframeServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: SpanIframeRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame>

        /**
         * Returns a raw HTTP response for `patch /v1/span_iframe/{span_iframe_id}`, but is
         * otherwise the same as [SpanIframeServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            params: SpanIframeUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame>

        /**
         * Returns a raw HTTP response for `get /v1/span_iframe`, but is otherwise the same as
         * [SpanIframeServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: SpanIframeListParams = SpanIframeListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIframeListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<SpanIframeListPageAsync> =
            list(SpanIframeListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/span_iframe/{span_iframe_id}`, but is
         * otherwise the same as [SpanIframeServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: SpanIframeDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame>

        /**
         * Returns a raw HTTP response for `put /v1/span_iframe`, but is otherwise the same as
         * [SpanIframeServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: SpanIframeReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame>
    }
}
