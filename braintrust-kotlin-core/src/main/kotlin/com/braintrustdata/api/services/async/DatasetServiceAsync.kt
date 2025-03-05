// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Dataset
import com.braintrustdata.api.models.DatasetCreateParams
import com.braintrustdata.api.models.DatasetDeleteParams
import com.braintrustdata.api.models.DatasetFeedbackParams
import com.braintrustdata.api.models.DatasetFetchParams
import com.braintrustdata.api.models.DatasetFetchPostParams
import com.braintrustdata.api.models.DatasetInsertParams
import com.braintrustdata.api.models.DatasetListPageAsync
import com.braintrustdata.api.models.DatasetListParams
import com.braintrustdata.api.models.DatasetRetrieveParams
import com.braintrustdata.api.models.DatasetSummarizeParams
import com.braintrustdata.api.models.DatasetUpdateParams
import com.braintrustdata.api.models.FeedbackResponseSchema
import com.braintrustdata.api.models.FetchDatasetEventsResponse
import com.braintrustdata.api.models.InsertEventsResponse
import com.braintrustdata.api.models.SummarizeDatasetResponse
import com.google.errorprone.annotations.MustBeClosed

interface DatasetServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Create a new dataset. If there is an existing dataset in the project with the same name as
     * the one specified in the request, will return the existing dataset unmodified
     */
    suspend fun create(
        params: DatasetCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** Get a dataset object by its id */
    suspend fun retrieve(
        params: DatasetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /**
     * Partially update a dataset object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        params: DatasetUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /**
     * List out all datasets. The datasets are sorted by creation date, with the most
     * recently-created datasets coming first
     */
    suspend fun list(
        params: DatasetListParams = DatasetListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DatasetListPageAsync

    /**
     * List out all datasets. The datasets are sorted by creation date, with the most
     * recently-created datasets coming first
     */
    suspend fun list(requestOptions: RequestOptions): DatasetListPageAsync =
        list(DatasetListParams.none(), requestOptions)

    /** Delete a dataset object by its id */
    suspend fun delete(
        params: DatasetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** Log feedback for a set of dataset events */
    suspend fun feedback(
        params: DatasetFeedbackParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedbackResponseSchema

    /**
     * Fetch the events in a dataset. Equivalent to the POST form of the same path, but with the
     * parameters in the URL query rather than in the request body. For more complex queries, use
     * the `POST /btql` endpoint.
     */
    suspend fun fetch(
        params: DatasetFetchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchDatasetEventsResponse

    /**
     * Fetch the events in a dataset. Equivalent to the GET form of the same path, but with the
     * parameters in the request body rather than in the URL query. For more complex queries, use
     * the `POST /btql` endpoint.
     */
    suspend fun fetchPost(
        params: DatasetFetchPostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchDatasetEventsResponse

    /** Insert a set of events into the dataset */
    suspend fun insert(
        params: DatasetInsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InsertEventsResponse

    /** Summarize dataset */
    suspend fun summarize(
        params: DatasetSummarizeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SummarizeDatasetResponse

    /**
     * A view of [DatasetServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/dataset`, but is otherwise the same as
         * [DatasetServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: DatasetCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /**
         * Returns a raw HTTP response for `get /v1/dataset/{dataset_id}`, but is otherwise the same
         * as [DatasetServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: DatasetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /**
         * Returns a raw HTTP response for `patch /v1/dataset/{dataset_id}`, but is otherwise the
         * same as [DatasetServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            params: DatasetUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /**
         * Returns a raw HTTP response for `get /v1/dataset`, but is otherwise the same as
         * [DatasetServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: DatasetListParams = DatasetListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DatasetListPageAsync>

        /**
         * Returns a raw HTTP response for `get /v1/dataset`, but is otherwise the same as
         * [DatasetServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<DatasetListPageAsync> =
            list(DatasetListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/dataset/{dataset_id}`, but is otherwise the
         * same as [DatasetServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: DatasetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /**
         * Returns a raw HTTP response for `post /v1/dataset/{dataset_id}/feedback`, but is
         * otherwise the same as [DatasetServiceAsync.feedback].
         */
        @MustBeClosed
        suspend fun feedback(
            params: DatasetFeedbackParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedbackResponseSchema>

        /**
         * Returns a raw HTTP response for `get /v1/dataset/{dataset_id}/fetch`, but is otherwise
         * the same as [DatasetServiceAsync.fetch].
         */
        @MustBeClosed
        suspend fun fetch(
            params: DatasetFetchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchDatasetEventsResponse>

        /**
         * Returns a raw HTTP response for `post /v1/dataset/{dataset_id}/fetch`, but is otherwise
         * the same as [DatasetServiceAsync.fetchPost].
         */
        @MustBeClosed
        suspend fun fetchPost(
            params: DatasetFetchPostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchDatasetEventsResponse>

        /**
         * Returns a raw HTTP response for `post /v1/dataset/{dataset_id}/insert`, but is otherwise
         * the same as [DatasetServiceAsync.insert].
         */
        @MustBeClosed
        suspend fun insert(
            params: DatasetInsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InsertEventsResponse>

        /**
         * Returns a raw HTTP response for `get /v1/dataset/{dataset_id}/summarize`, but is
         * otherwise the same as [DatasetServiceAsync.summarize].
         */
        @MustBeClosed
        suspend fun summarize(
            params: DatasetSummarizeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SummarizeDatasetResponse>
    }
}
