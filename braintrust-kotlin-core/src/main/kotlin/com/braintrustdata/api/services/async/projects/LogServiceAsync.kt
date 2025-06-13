// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async.projects

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.FeedbackResponseSchema
import com.braintrustdata.api.models.FetchProjectLogsEventsResponse
import com.braintrustdata.api.models.InsertEventsResponse
import com.braintrustdata.api.models.ProjectLogFeedbackParams
import com.braintrustdata.api.models.ProjectLogFetchParams
import com.braintrustdata.api.models.ProjectLogFetchPostParams
import com.braintrustdata.api.models.ProjectLogInsertParams
import com.google.errorprone.annotations.MustBeClosed

interface LogServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogServiceAsync

    /** Log feedback for a set of project logs events */
    suspend fun feedback(
        projectId: String,
        params: ProjectLogFeedbackParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedbackResponseSchema =
        feedback(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see [feedback] */
    suspend fun feedback(
        params: ProjectLogFeedbackParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FeedbackResponseSchema

    /**
     * Fetch the events in a project logs. Equivalent to the POST form of the same path, but with
     * the parameters in the URL query rather than in the request body. For more complex queries,
     * use the `POST /btql` endpoint.
     */
    suspend fun fetch(
        projectId: String,
        params: ProjectLogFetchParams = ProjectLogFetchParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchProjectLogsEventsResponse =
        fetch(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see [fetch] */
    suspend fun fetch(
        params: ProjectLogFetchParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchProjectLogsEventsResponse

    /** @see [fetch] */
    suspend fun fetch(
        projectId: String,
        requestOptions: RequestOptions,
    ): FetchProjectLogsEventsResponse =
        fetch(projectId, ProjectLogFetchParams.none(), requestOptions)

    /**
     * Fetch the events in a project logs. Equivalent to the GET form of the same path, but with the
     * parameters in the request body rather than in the URL query. For more complex queries, use
     * the `POST /btql` endpoint.
     */
    suspend fun fetchPost(
        projectId: String,
        params: ProjectLogFetchPostParams = ProjectLogFetchPostParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchProjectLogsEventsResponse =
        fetchPost(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see [fetchPost] */
    suspend fun fetchPost(
        params: ProjectLogFetchPostParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FetchProjectLogsEventsResponse

    /** @see [fetchPost] */
    suspend fun fetchPost(
        projectId: String,
        requestOptions: RequestOptions,
    ): FetchProjectLogsEventsResponse =
        fetchPost(projectId, ProjectLogFetchPostParams.none(), requestOptions)

    /** Insert a set of events into the project logs */
    suspend fun insert(
        projectId: String,
        params: ProjectLogInsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InsertEventsResponse =
        insert(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see [insert] */
    suspend fun insert(
        params: ProjectLogInsertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InsertEventsResponse

    /** A view of [LogServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): LogServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/project_logs/{project_id}/feedback`, but is
         * otherwise the same as [LogServiceAsync.feedback].
         */
        @MustBeClosed
        suspend fun feedback(
            projectId: String,
            params: ProjectLogFeedbackParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedbackResponseSchema> =
            feedback(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see [feedback] */
        @MustBeClosed
        suspend fun feedback(
            params: ProjectLogFeedbackParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FeedbackResponseSchema>

        /**
         * Returns a raw HTTP response for `get /v1/project_logs/{project_id}/fetch`, but is
         * otherwise the same as [LogServiceAsync.fetch].
         */
        @MustBeClosed
        suspend fun fetch(
            projectId: String,
            params: ProjectLogFetchParams = ProjectLogFetchParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchProjectLogsEventsResponse> =
            fetch(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see [fetch] */
        @MustBeClosed
        suspend fun fetch(
            params: ProjectLogFetchParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchProjectLogsEventsResponse>

        /** @see [fetch] */
        @MustBeClosed
        suspend fun fetch(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchProjectLogsEventsResponse> =
            fetch(projectId, ProjectLogFetchParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/project_logs/{project_id}/fetch`, but is
         * otherwise the same as [LogServiceAsync.fetchPost].
         */
        @MustBeClosed
        suspend fun fetchPost(
            projectId: String,
            params: ProjectLogFetchPostParams = ProjectLogFetchPostParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchProjectLogsEventsResponse> =
            fetchPost(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see [fetchPost] */
        @MustBeClosed
        suspend fun fetchPost(
            params: ProjectLogFetchPostParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FetchProjectLogsEventsResponse>

        /** @see [fetchPost] */
        @MustBeClosed
        suspend fun fetchPost(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchProjectLogsEventsResponse> =
            fetchPost(projectId, ProjectLogFetchPostParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/project_logs/{project_id}/insert`, but is
         * otherwise the same as [LogServiceAsync.insert].
         */
        @MustBeClosed
        suspend fun insert(
            projectId: String,
            params: ProjectLogInsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InsertEventsResponse> =
            insert(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see [insert] */
        @MustBeClosed
        suspend fun insert(
            params: ProjectLogInsertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InsertEventsResponse>
    }
}
