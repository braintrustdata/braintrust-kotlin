// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Experiment
import com.braintrustdata.api.models.ExperimentCreateParams
import com.braintrustdata.api.models.ExperimentDeleteParams
import com.braintrustdata.api.models.ExperimentFeedbackParams
import com.braintrustdata.api.models.ExperimentFetchParams
import com.braintrustdata.api.models.ExperimentFetchPostParams
import com.braintrustdata.api.models.ExperimentInsertParams
import com.braintrustdata.api.models.ExperimentListPageAsync
import com.braintrustdata.api.models.ExperimentListParams
import com.braintrustdata.api.models.ExperimentRetrieveParams
import com.braintrustdata.api.models.ExperimentSummarizeParams
import com.braintrustdata.api.models.ExperimentUpdateParams
import com.braintrustdata.api.models.FeedbackResponseSchema
import com.braintrustdata.api.models.FetchExperimentEventsResponse
import com.braintrustdata.api.models.InsertEventsResponse
import com.braintrustdata.api.models.SummarizeExperimentResponse
import com.google.errorprone.annotations.MustBeClosed

interface ExperimentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExperimentServiceAsync

    /**
     * Create a new experiment. If there is an existing experiment in the project with the same name
     * as the one specified in the request, will return the existing experiment unmodified
     */
    suspend fun create(
        params: ExperimentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Experiment

    /** Get an experiment object by its id */
    suspend fun retrieve(
        experimentId: String,
        params: ExperimentRetrieveParams = ExperimentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Experiment = retrieve(params.toBuilder().experimentId(experimentId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: ExperimentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Experiment

    /** @see [retrieve] */
    suspend fun retrieve(experimentId: String, requestOptions: RequestOptions): Experiment =
        retrieve(experimentId, ExperimentRetrieveParams.none(), requestOptions)

    /**
     * Partially update an experiment object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        experimentId: String,
        params: ExperimentUpdateParams = ExperimentUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Experiment = update(params.toBuilder().experimentId(experimentId).build(), requestOptions)

    /** @see [update] */
    suspend fun update(
        params: ExperimentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Experiment

    /** @see [update] */
    suspend fun update(experimentId: String, requestOptions: RequestOptions): Experiment =
        update(experimentId, ExperimentUpdateParams.none(), requestOptions)

    /**
     * List out all experiments. The experiments are sorted by creation date, with the most
     * recently-created experiments coming first
     */
    suspend fun list(
        params: ExperimentListParams = ExperimentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExperimentListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): ExperimentListPageAsync =
        list(ExperimentListParams.none(), requestOptions)

    /** Delete an experiment object by its id */
    suspend fun delete(
        experimentId: String,
        params: ExperimentDeleteParams = ExperimentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Experiment = delete(params.toBuilder().experimentId(experimentId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: ExperimentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Experiment

    /** @see [delete] */
    suspend fun delete(experimentId: String, requestOptions: RequestOptions): Experiment =
        delete(experimentId, ExperimentDeleteParams.none(), requestOptions)

    /** Log feedback for a set of experiment events */
    suspend fun feedback(
        experimentId: String,
        params: ExperimentFeedbackParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedbackResponseSchema =
        feedback(params.toBuilder().experimentId(experimentId).build(), requestOptions)

    /** @see [feedback] */
    suspend fun feedback(
        params: ExperimentFeedbackParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedbackResponseSchema

    /**
     * Fetch the events in an experiment. Equivalent to the POST form of the same path, but with the
     * parameters in the URL query rather than in the request body. For more complex queries, use
     * the `POST /btql` endpoint.
     */
    suspend fun fetch(
        experimentId: String,
        params: ExperimentFetchParams = ExperimentFetchParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchExperimentEventsResponse =
        fetch(params.toBuilder().experimentId(experimentId).build(), requestOptions)

    /** @see [fetch] */
    suspend fun fetch(
        params: ExperimentFetchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchExperimentEventsResponse

    /** @see [fetch] */
    suspend fun fetch(
        experimentId: String,
        requestOptions: RequestOptions,
    ): FetchExperimentEventsResponse =
        fetch(experimentId, ExperimentFetchParams.none(), requestOptions)

    /**
     * Fetch the events in an experiment. Equivalent to the GET form of the same path, but with the
     * parameters in the request body rather than in the URL query. For more complex queries, use
     * the `POST /btql` endpoint.
     */
    suspend fun fetchPost(
        experimentId: String,
        params: ExperimentFetchPostParams = ExperimentFetchPostParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchExperimentEventsResponse =
        fetchPost(params.toBuilder().experimentId(experimentId).build(), requestOptions)

    /** @see [fetchPost] */
    suspend fun fetchPost(
        params: ExperimentFetchPostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchExperimentEventsResponse

    /** @see [fetchPost] */
    suspend fun fetchPost(
        experimentId: String,
        requestOptions: RequestOptions,
    ): FetchExperimentEventsResponse =
        fetchPost(experimentId, ExperimentFetchPostParams.none(), requestOptions)

    /** Insert a set of events into the experiment */
    suspend fun insert(
        experimentId: String,
        params: ExperimentInsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InsertEventsResponse =
        insert(params.toBuilder().experimentId(experimentId).build(), requestOptions)

    /** @see [insert] */
    suspend fun insert(
        params: ExperimentInsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InsertEventsResponse

    /** Summarize experiment */
    suspend fun summarize(
        experimentId: String,
        params: ExperimentSummarizeParams = ExperimentSummarizeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SummarizeExperimentResponse =
        summarize(params.toBuilder().experimentId(experimentId).build(), requestOptions)

    /** @see [summarize] */
    suspend fun summarize(
        params: ExperimentSummarizeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SummarizeExperimentResponse

    /** @see [summarize] */
    suspend fun summarize(
        experimentId: String,
        requestOptions: RequestOptions,
    ): SummarizeExperimentResponse =
        summarize(experimentId, ExperimentSummarizeParams.none(), requestOptions)

    /**
     * A view of [ExperimentServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ExperimentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/experiment`, but is otherwise the same as
         * [ExperimentServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: ExperimentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Experiment>

        /**
         * Returns a raw HTTP response for `get /v1/experiment/{experiment_id}`, but is otherwise
         * the same as [ExperimentServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            experimentId: String,
            params: ExperimentRetrieveParams = ExperimentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Experiment> =
            retrieve(params.toBuilder().experimentId(experimentId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: ExperimentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Experiment>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            experimentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Experiment> =
            retrieve(experimentId, ExperimentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/experiment/{experiment_id}`, but is otherwise
         * the same as [ExperimentServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            experimentId: String,
            params: ExperimentUpdateParams = ExperimentUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Experiment> =
            update(params.toBuilder().experimentId(experimentId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            params: ExperimentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Experiment>

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            experimentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Experiment> =
            update(experimentId, ExperimentUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/experiment`, but is otherwise the same as
         * [ExperimentServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ExperimentListParams = ExperimentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExperimentListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<ExperimentListPageAsync> =
            list(ExperimentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/experiment/{experiment_id}`, but is otherwise
         * the same as [ExperimentServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            experimentId: String,
            params: ExperimentDeleteParams = ExperimentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Experiment> =
            delete(params.toBuilder().experimentId(experimentId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: ExperimentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Experiment>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            experimentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Experiment> =
            delete(experimentId, ExperimentDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/experiment/{experiment_id}/feedback`, but is
         * otherwise the same as [ExperimentServiceAsync.feedback].
         */
        @MustBeClosed
        suspend fun feedback(
            experimentId: String,
            params: ExperimentFeedbackParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedbackResponseSchema> =
            feedback(params.toBuilder().experimentId(experimentId).build(), requestOptions)

        /** @see [feedback] */
        @MustBeClosed
        suspend fun feedback(
            params: ExperimentFeedbackParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedbackResponseSchema>

        /**
         * Returns a raw HTTP response for `get /v1/experiment/{experiment_id}/fetch`, but is
         * otherwise the same as [ExperimentServiceAsync.fetch].
         */
        @MustBeClosed
        suspend fun fetch(
            experimentId: String,
            params: ExperimentFetchParams = ExperimentFetchParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchExperimentEventsResponse> =
            fetch(params.toBuilder().experimentId(experimentId).build(), requestOptions)

        /** @see [fetch] */
        @MustBeClosed
        suspend fun fetch(
            params: ExperimentFetchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchExperimentEventsResponse>

        /** @see [fetch] */
        @MustBeClosed
        suspend fun fetch(
            experimentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchExperimentEventsResponse> =
            fetch(experimentId, ExperimentFetchParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/experiment/{experiment_id}/fetch`, but is
         * otherwise the same as [ExperimentServiceAsync.fetchPost].
         */
        @MustBeClosed
        suspend fun fetchPost(
            experimentId: String,
            params: ExperimentFetchPostParams = ExperimentFetchPostParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchExperimentEventsResponse> =
            fetchPost(params.toBuilder().experimentId(experimentId).build(), requestOptions)

        /** @see [fetchPost] */
        @MustBeClosed
        suspend fun fetchPost(
            params: ExperimentFetchPostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchExperimentEventsResponse>

        /** @see [fetchPost] */
        @MustBeClosed
        suspend fun fetchPost(
            experimentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchExperimentEventsResponse> =
            fetchPost(experimentId, ExperimentFetchPostParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/experiment/{experiment_id}/insert`, but is
         * otherwise the same as [ExperimentServiceAsync.insert].
         */
        @MustBeClosed
        suspend fun insert(
            experimentId: String,
            params: ExperimentInsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InsertEventsResponse> =
            insert(params.toBuilder().experimentId(experimentId).build(), requestOptions)

        /** @see [insert] */
        @MustBeClosed
        suspend fun insert(
            params: ExperimentInsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InsertEventsResponse>

        /**
         * Returns a raw HTTP response for `get /v1/experiment/{experiment_id}/summarize`, but is
         * otherwise the same as [ExperimentServiceAsync.summarize].
         */
        @MustBeClosed
        suspend fun summarize(
            experimentId: String,
            params: ExperimentSummarizeParams = ExperimentSummarizeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SummarizeExperimentResponse> =
            summarize(params.toBuilder().experimentId(experimentId).build(), requestOptions)

        /** @see [summarize] */
        @MustBeClosed
        suspend fun summarize(
            params: ExperimentSummarizeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SummarizeExperimentResponse>

        /** @see [summarize] */
        @MustBeClosed
        suspend fun summarize(
            experimentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SummarizeExperimentResponse> =
            summarize(experimentId, ExperimentSummarizeParams.none(), requestOptions)
    }
}
