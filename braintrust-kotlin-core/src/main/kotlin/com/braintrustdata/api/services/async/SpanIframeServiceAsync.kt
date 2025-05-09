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
        spanIframeId: String,
        params: SpanIframeRetrieveParams = SpanIframeRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame = retrieve(params.toBuilder().spanIframeId(spanIframeId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: SpanIframeRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame

    /** @see [retrieve] */
    suspend fun retrieve(spanIframeId: String, requestOptions: RequestOptions): SpanIFrame =
        retrieve(spanIframeId, SpanIframeRetrieveParams.none(), requestOptions)

    /**
     * Partially update a span_iframe object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        spanIframeId: String,
        params: SpanIframeUpdateParams = SpanIframeUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame = update(params.toBuilder().spanIframeId(spanIframeId).build(), requestOptions)

    /** @see [update] */
    suspend fun update(
        params: SpanIframeUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame

    /** @see [update] */
    suspend fun update(spanIframeId: String, requestOptions: RequestOptions): SpanIFrame =
        update(spanIframeId, SpanIframeUpdateParams.none(), requestOptions)

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
        spanIframeId: String,
        params: SpanIframeDeleteParams = SpanIframeDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame = delete(params.toBuilder().spanIframeId(spanIframeId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: SpanIframeDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SpanIFrame

    /** @see [delete] */
    suspend fun delete(spanIframeId: String, requestOptions: RequestOptions): SpanIFrame =
        delete(spanIframeId, SpanIframeDeleteParams.none(), requestOptions)

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
            spanIframeId: String,
            params: SpanIframeRetrieveParams = SpanIframeRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame> =
            retrieve(params.toBuilder().spanIframeId(spanIframeId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: SpanIframeRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            spanIframeId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIFrame> =
            retrieve(spanIframeId, SpanIframeRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/span_iframe/{span_iframe_id}`, but is
         * otherwise the same as [SpanIframeServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            spanIframeId: String,
            params: SpanIframeUpdateParams = SpanIframeUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame> =
            update(params.toBuilder().spanIframeId(spanIframeId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            params: SpanIframeUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame>

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            spanIframeId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIFrame> =
            update(spanIframeId, SpanIframeUpdateParams.none(), requestOptions)

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
            spanIframeId: String,
            params: SpanIframeDeleteParams = SpanIframeDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame> =
            delete(params.toBuilder().spanIframeId(spanIframeId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: SpanIframeDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SpanIFrame>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            spanIframeId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SpanIFrame> =
            delete(spanIframeId, SpanIframeDeleteParams.none(), requestOptions)

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
