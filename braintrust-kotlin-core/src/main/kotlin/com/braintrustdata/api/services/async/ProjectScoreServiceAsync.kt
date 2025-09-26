// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.ProjectScore
import com.braintrustdata.api.models.ProjectScoreCreateParams
import com.braintrustdata.api.models.ProjectScoreDeleteParams
import com.braintrustdata.api.models.ProjectScoreListPageAsync
import com.braintrustdata.api.models.ProjectScoreListParams
import com.braintrustdata.api.models.ProjectScoreReplaceParams
import com.braintrustdata.api.models.ProjectScoreRetrieveParams
import com.braintrustdata.api.models.ProjectScoreUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface ProjectScoreServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ProjectScoreServiceAsync

    /**
     * Create a new project_score. If there is an existing project_score in the project with the
     * same name as the one specified in the request, will return the existing project_score
     * unmodified
     */
    suspend fun create(
        params: ProjectScoreCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScore

    /** Get a project_score object by its id */
    suspend fun retrieve(
        projectScoreId: String,
        params: ProjectScoreRetrieveParams = ProjectScoreRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScore =
        retrieve(params.toBuilder().projectScoreId(projectScoreId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: ProjectScoreRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScore

    /** @see retrieve */
    suspend fun retrieve(projectScoreId: String, requestOptions: RequestOptions): ProjectScore =
        retrieve(projectScoreId, ProjectScoreRetrieveParams.none(), requestOptions)

    /**
     * Partially update a project_score object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        projectScoreId: String,
        params: ProjectScoreUpdateParams = ProjectScoreUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScore =
        update(params.toBuilder().projectScoreId(projectScoreId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: ProjectScoreUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScore

    /** @see update */
    suspend fun update(projectScoreId: String, requestOptions: RequestOptions): ProjectScore =
        update(projectScoreId, ProjectScoreUpdateParams.none(), requestOptions)

    /**
     * List out all project_scores. The project_scores are sorted by creation date, with the most
     * recently-created project_scores coming first
     */
    suspend fun list(
        params: ProjectScoreListParams = ProjectScoreListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScoreListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): ProjectScoreListPageAsync =
        list(ProjectScoreListParams.none(), requestOptions)

    /** Delete a project_score object by its id */
    suspend fun delete(
        projectScoreId: String,
        params: ProjectScoreDeleteParams = ProjectScoreDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScore =
        delete(params.toBuilder().projectScoreId(projectScoreId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: ProjectScoreDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScore

    /** @see delete */
    suspend fun delete(projectScoreId: String, requestOptions: RequestOptions): ProjectScore =
        delete(projectScoreId, ProjectScoreDeleteParams.none(), requestOptions)

    /**
     * Create or replace project_score. If there is an existing project_score in the project with
     * the same name as the one specified in the request, will replace the existing project_score
     * with the provided fields
     */
    suspend fun replace(
        params: ProjectScoreReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectScore

    /**
     * A view of [ProjectScoreServiceAsync] that provides access to raw HTTP responses for each
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
        ): ProjectScoreServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/project_score`, but is otherwise the same as
         * [ProjectScoreServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: ProjectScoreCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScore>

        /**
         * Returns a raw HTTP response for `get /v1/project_score/{project_score_id}`, but is
         * otherwise the same as [ProjectScoreServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            projectScoreId: String,
            params: ProjectScoreRetrieveParams = ProjectScoreRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScore> =
            retrieve(params.toBuilder().projectScoreId(projectScoreId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: ProjectScoreRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScore>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            projectScoreId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScore> =
            retrieve(projectScoreId, ProjectScoreRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/project_score/{project_score_id}`, but is
         * otherwise the same as [ProjectScoreServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            projectScoreId: String,
            params: ProjectScoreUpdateParams = ProjectScoreUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScore> =
            update(params.toBuilder().projectScoreId(projectScoreId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: ProjectScoreUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScore>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            projectScoreId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScore> =
            update(projectScoreId, ProjectScoreUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/project_score`, but is otherwise the same as
         * [ProjectScoreServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ProjectScoreListParams = ProjectScoreListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScoreListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            requestOptions: RequestOptions
        ): HttpResponseFor<ProjectScoreListPageAsync> =
            list(ProjectScoreListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/project_score/{project_score_id}`, but is
         * otherwise the same as [ProjectScoreServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            projectScoreId: String,
            params: ProjectScoreDeleteParams = ProjectScoreDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScore> =
            delete(params.toBuilder().projectScoreId(projectScoreId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: ProjectScoreDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScore>

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            projectScoreId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectScore> =
            delete(projectScoreId, ProjectScoreDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/project_score`, but is otherwise the same as
         * [ProjectScoreServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: ProjectScoreReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectScore>
    }
}
