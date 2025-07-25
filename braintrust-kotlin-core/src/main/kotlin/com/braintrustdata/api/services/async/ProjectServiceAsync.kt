// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Project
import com.braintrustdata.api.models.ProjectCreateParams
import com.braintrustdata.api.models.ProjectDeleteParams
import com.braintrustdata.api.models.ProjectListPageAsync
import com.braintrustdata.api.models.ProjectListParams
import com.braintrustdata.api.models.ProjectRetrieveParams
import com.braintrustdata.api.models.ProjectUpdateParams
import com.braintrustdata.api.services.async.projects.LogServiceAsync
import com.google.errorprone.annotations.MustBeClosed

interface ProjectServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ProjectServiceAsync

    fun logs(): LogServiceAsync

    /**
     * Create a new project. If there is an existing project with the same name as the one specified
     * in the request, will return the existing project unmodified
     */
    suspend fun create(
        params: ProjectCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project

    /** Get a project object by its id */
    suspend fun retrieve(
        projectId: String,
        params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project = retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: ProjectRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project

    /** @see retrieve */
    suspend fun retrieve(projectId: String, requestOptions: RequestOptions): Project =
        retrieve(projectId, ProjectRetrieveParams.none(), requestOptions)

    /**
     * Partially update a project object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        projectId: String,
        params: ProjectUpdateParams = ProjectUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project = update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: ProjectUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project

    /** @see update */
    suspend fun update(projectId: String, requestOptions: RequestOptions): Project =
        update(projectId, ProjectUpdateParams.none(), requestOptions)

    /**
     * List out all projects. The projects are sorted by creation date, with the most
     * recently-created projects coming first
     */
    suspend fun list(
        params: ProjectListParams = ProjectListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): ProjectListPageAsync =
        list(ProjectListParams.none(), requestOptions)

    /** Delete a project object by its id */
    suspend fun delete(
        projectId: String,
        params: ProjectDeleteParams = ProjectDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project = delete(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: ProjectDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Project

    /** @see delete */
    suspend fun delete(projectId: String, requestOptions: RequestOptions): Project =
        delete(projectId, ProjectDeleteParams.none(), requestOptions)

    /**
     * A view of [ProjectServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ProjectServiceAsync.WithRawResponse

        fun logs(): LogServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/project`, but is otherwise the same as
         * [ProjectServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: ProjectCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project>

        /**
         * Returns a raw HTTP response for `get /v1/project/{project_id}`, but is otherwise the same
         * as [ProjectServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            projectId: String,
            params: ProjectRetrieveParams = ProjectRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: ProjectRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Project> =
            retrieve(projectId, ProjectRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/project/{project_id}`, but is otherwise the
         * same as [ProjectServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            projectId: String,
            params: ProjectUpdateParams = ProjectUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: ProjectUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Project> = update(projectId, ProjectUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/project`, but is otherwise the same as
         * [ProjectServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ProjectListParams = ProjectListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<ProjectListPageAsync> =
            list(ProjectListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/project/{project_id}`, but is otherwise the
         * same as [ProjectServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            projectId: String,
            params: ProjectDeleteParams = ProjectDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project> =
            delete(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: ProjectDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Project>

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            projectId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Project> = delete(projectId, ProjectDeleteParams.none(), requestOptions)
    }
}
