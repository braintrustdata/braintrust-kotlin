// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
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
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): DatasetServiceAsync

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
        datasetId: String,
        params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset = retrieve(params.toBuilder().datasetId(datasetId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: DatasetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** @see [retrieve] */
    suspend fun retrieve(datasetId: String, requestOptions: RequestOptions): Dataset =
        retrieve(datasetId, DatasetRetrieveParams.none(), requestOptions)

    /**
     * Partially update a dataset object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        datasetId: String,
        params: DatasetUpdateParams = DatasetUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset = update(params.toBuilder().datasetId(datasetId).build(), requestOptions)

    /** @see [update] */
    suspend fun update(
        params: DatasetUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** @see [update] */
    suspend fun update(datasetId: String, requestOptions: RequestOptions): Dataset =
        update(datasetId, DatasetUpdateParams.none(), requestOptions)

    /**
     * List out all datasets. The datasets are sorted by creation date, with the most
     * recently-created datasets coming first
     */
    suspend fun list(
        params: DatasetListParams = DatasetListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DatasetListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): DatasetListPageAsync =
        list(DatasetListParams.none(), requestOptions)

    /** Delete a dataset object by its id */
    suspend fun delete(
        datasetId: String,
        params: DatasetDeleteParams = DatasetDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset = delete(params.toBuilder().datasetId(datasetId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: DatasetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Dataset

    /** @see [delete] */
    suspend fun delete(datasetId: String, requestOptions: RequestOptions): Dataset =
        delete(datasetId, DatasetDeleteParams.none(), requestOptions)

    /** Log feedback for a set of dataset events */
    suspend fun feedback(
        datasetId: String,
        params: DatasetFeedbackParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedbackResponseSchema =
        feedback(params.toBuilder().datasetId(datasetId).build(), requestOptions)

    /** @see [feedback] */
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
        datasetId: String,
        params: DatasetFetchParams = DatasetFetchParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchDatasetEventsResponse =
        fetch(params.toBuilder().datasetId(datasetId).build(), requestOptions)

    /** @see [fetch] */
    suspend fun fetch(
        params: DatasetFetchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchDatasetEventsResponse

    /** @see [fetch] */
    suspend fun fetch(
        datasetId: String,
        requestOptions: RequestOptions,
    ): FetchDatasetEventsResponse = fetch(datasetId, DatasetFetchParams.none(), requestOptions)

    /**
     * Fetch the events in a dataset. Equivalent to the GET form of the same path, but with the
     * parameters in the request body rather than in the URL query. For more complex queries, use
     * the `POST /btql` endpoint.
     */
    suspend fun fetchPost(
        datasetId: String,
        params: DatasetFetchPostParams = DatasetFetchPostParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchDatasetEventsResponse =
        fetchPost(params.toBuilder().datasetId(datasetId).build(), requestOptions)

    /** @see [fetchPost] */
    suspend fun fetchPost(
        params: DatasetFetchPostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchDatasetEventsResponse

    /** @see [fetchPost] */
    suspend fun fetchPost(
        datasetId: String,
        requestOptions: RequestOptions,
    ): FetchDatasetEventsResponse =
        fetchPost(datasetId, DatasetFetchPostParams.none(), requestOptions)

    /** Insert a set of events into the dataset */
    suspend fun insert(
        datasetId: String,
        params: DatasetInsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InsertEventsResponse =
        insert(params.toBuilder().datasetId(datasetId).build(), requestOptions)

    /** @see [insert] */
    suspend fun insert(
        params: DatasetInsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InsertEventsResponse

    /** Summarize dataset */
    suspend fun summarize(
        datasetId: String,
        params: DatasetSummarizeParams = DatasetSummarizeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SummarizeDatasetResponse =
        summarize(params.toBuilder().datasetId(datasetId).build(), requestOptions)

    /** @see [summarize] */
    suspend fun summarize(
        params: DatasetSummarizeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SummarizeDatasetResponse

    /** @see [summarize] */
    suspend fun summarize(
        datasetId: String,
        requestOptions: RequestOptions,
    ): SummarizeDatasetResponse =
        summarize(datasetId, DatasetSummarizeParams.none(), requestOptions)

    /**
     * A view of [DatasetServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): DatasetServiceAsync.WithRawResponse

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
            datasetId: String,
            params: DatasetRetrieveParams = DatasetRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset> =
            retrieve(params.toBuilder().datasetId(datasetId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: DatasetRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            datasetId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Dataset> =
            retrieve(datasetId, DatasetRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/dataset/{dataset_id}`, but is otherwise the
         * same as [DatasetServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            datasetId: String,
            params: DatasetUpdateParams = DatasetUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset> =
            update(params.toBuilder().datasetId(datasetId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            params: DatasetUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            datasetId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Dataset> = update(datasetId, DatasetUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/dataset`, but is otherwise the same as
         * [DatasetServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: DatasetListParams = DatasetListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DatasetListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<DatasetListPageAsync> =
            list(DatasetListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/dataset/{dataset_id}`, but is otherwise the
         * same as [DatasetServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            datasetId: String,
            params: DatasetDeleteParams = DatasetDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset> =
            delete(params.toBuilder().datasetId(datasetId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: DatasetDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Dataset>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            datasetId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Dataset> = delete(datasetId, DatasetDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/dataset/{dataset_id}/feedback`, but is
         * otherwise the same as [DatasetServiceAsync.feedback].
         */
        @MustBeClosed
        suspend fun feedback(
            datasetId: String,
            params: DatasetFeedbackParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedbackResponseSchema> =
            feedback(params.toBuilder().datasetId(datasetId).build(), requestOptions)

        /** @see [feedback] */
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
            datasetId: String,
            params: DatasetFetchParams = DatasetFetchParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchDatasetEventsResponse> =
            fetch(params.toBuilder().datasetId(datasetId).build(), requestOptions)

        /** @see [fetch] */
        @MustBeClosed
        suspend fun fetch(
            params: DatasetFetchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchDatasetEventsResponse>

        /** @see [fetch] */
        @MustBeClosed
        suspend fun fetch(
            datasetId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchDatasetEventsResponse> =
            fetch(datasetId, DatasetFetchParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/dataset/{dataset_id}/fetch`, but is otherwise
         * the same as [DatasetServiceAsync.fetchPost].
         */
        @MustBeClosed
        suspend fun fetchPost(
            datasetId: String,
            params: DatasetFetchPostParams = DatasetFetchPostParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchDatasetEventsResponse> =
            fetchPost(params.toBuilder().datasetId(datasetId).build(), requestOptions)

        /** @see [fetchPost] */
        @MustBeClosed
        suspend fun fetchPost(
            params: DatasetFetchPostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchDatasetEventsResponse>

        /** @see [fetchPost] */
        @MustBeClosed
        suspend fun fetchPost(
            datasetId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchDatasetEventsResponse> =
            fetchPost(datasetId, DatasetFetchPostParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/dataset/{dataset_id}/insert`, but is otherwise
         * the same as [DatasetServiceAsync.insert].
         */
        @MustBeClosed
        suspend fun insert(
            datasetId: String,
            params: DatasetInsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InsertEventsResponse> =
            insert(params.toBuilder().datasetId(datasetId).build(), requestOptions)

        /** @see [insert] */
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
            datasetId: String,
            params: DatasetSummarizeParams = DatasetSummarizeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SummarizeDatasetResponse> =
            summarize(params.toBuilder().datasetId(datasetId).build(), requestOptions)

        /** @see [summarize] */
        @MustBeClosed
        suspend fun summarize(
            params: DatasetSummarizeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SummarizeDatasetResponse>

        /** @see [summarize] */
        @MustBeClosed
        suspend fun summarize(
            datasetId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SummarizeDatasetResponse> =
            summarize(datasetId, DatasetSummarizeParams.none(), requestOptions)
    }
}
