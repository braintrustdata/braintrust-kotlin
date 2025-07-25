// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.ProjectTag
import com.braintrustdata.api.models.ProjectTagCreateParams
import com.braintrustdata.api.models.ProjectTagDeleteParams
import com.braintrustdata.api.models.ProjectTagListPageAsync
import com.braintrustdata.api.models.ProjectTagListParams
import com.braintrustdata.api.models.ProjectTagReplaceParams
import com.braintrustdata.api.models.ProjectTagRetrieveParams
import com.braintrustdata.api.models.ProjectTagUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface ProjectTagServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ProjectTagServiceAsync

    /**
     * Create a new project_tag. If there is an existing project_tag in the project with the same
     * name as the one specified in the request, will return the existing project_tag unmodified
     */
    suspend fun create(
        params: ProjectTagCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** Get a project_tag object by its id */
    suspend fun retrieve(
        projectTagId: String,
        params: ProjectTagRetrieveParams = ProjectTagRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag = retrieve(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: ProjectTagRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** @see retrieve */
    suspend fun retrieve(projectTagId: String, requestOptions: RequestOptions): ProjectTag =
        retrieve(projectTagId, ProjectTagRetrieveParams.none(), requestOptions)

    /**
     * Partially update a project_tag object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        projectTagId: String,
        params: ProjectTagUpdateParams = ProjectTagUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag = update(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: ProjectTagUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** @see update */
    suspend fun update(projectTagId: String, requestOptions: RequestOptions): ProjectTag =
        update(projectTagId, ProjectTagUpdateParams.none(), requestOptions)

    /**
     * List out all project_tags. The project_tags are sorted by creation date, with the most
     * recently-created project_tags coming first
     */
    suspend fun list(
        params: ProjectTagListParams = ProjectTagListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTagListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): ProjectTagListPageAsync =
        list(ProjectTagListParams.none(), requestOptions)

    /** Delete a project_tag object by its id */
    suspend fun delete(
        projectTagId: String,
        params: ProjectTagDeleteParams = ProjectTagDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag = delete(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: ProjectTagDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** @see delete */
    suspend fun delete(projectTagId: String, requestOptions: RequestOptions): ProjectTag =
        delete(projectTagId, ProjectTagDeleteParams.none(), requestOptions)

    /**
     * Create or replace project_tag. If there is an existing project_tag in the project with the
     * same name as the one specified in the request, will replace the existing project_tag with the
     * provided fields
     */
    suspend fun replace(
        params: ProjectTagReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /**
     * A view of [ProjectTagServiceAsync] that provides access to raw HTTP responses for each
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
        ): ProjectTagServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/project_tag`, but is otherwise the same as
         * [ProjectTagServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: ProjectTagCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>

        /**
         * Returns a raw HTTP response for `get /v1/project_tag/{project_tag_id}`, but is otherwise
         * the same as [ProjectTagServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            projectTagId: String,
            params: ProjectTagRetrieveParams = ProjectTagRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag> =
            retrieve(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: ProjectTagRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            projectTagId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> =
            retrieve(projectTagId, ProjectTagRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/project_tag/{project_tag_id}`, but is
         * otherwise the same as [ProjectTagServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            projectTagId: String,
            params: ProjectTagUpdateParams = ProjectTagUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag> =
            update(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: ProjectTagUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            projectTagId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> =
            update(projectTagId, ProjectTagUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/project_tag`, but is otherwise the same as
         * [ProjectTagServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ProjectTagListParams = ProjectTagListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTagListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<ProjectTagListPageAsync> =
            list(ProjectTagListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/project_tag/{project_tag_id}`, but is
         * otherwise the same as [ProjectTagServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            projectTagId: String,
            params: ProjectTagDeleteParams = ProjectTagDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag> =
            delete(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: ProjectTagDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            projectTagId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> =
            delete(projectTagId, ProjectTagDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/project_tag`, but is otherwise the same as
         * [ProjectTagServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: ProjectTagReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>
    }
}
