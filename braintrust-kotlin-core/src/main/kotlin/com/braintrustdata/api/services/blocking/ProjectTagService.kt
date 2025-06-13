// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.ProjectTag
import com.braintrustdata.api.models.ProjectTagCreateParams
import com.braintrustdata.api.models.ProjectTagDeleteParams
import com.braintrustdata.api.models.ProjectTagListPage
import com.braintrustdata.api.models.ProjectTagListParams
import com.braintrustdata.api.models.ProjectTagReplaceParams
import com.braintrustdata.api.models.ProjectTagRetrieveParams
import com.braintrustdata.api.models.ProjectTagUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface ProjectTagService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ProjectTagService

    /**
     * Create a new project_tag. If there is an existing project_tag in the project with the same
     * name as the one specified in the request, will return the existing project_tag unmodified
     */
    fun create(
        params: ProjectTagCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** Get a project_tag object by its id */
    fun retrieve(
        projectTagId: String,
        params: ProjectTagRetrieveParams = ProjectTagRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag = retrieve(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        params: ProjectTagRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** @see [retrieve] */
    fun retrieve(projectTagId: String, requestOptions: RequestOptions): ProjectTag =
        retrieve(projectTagId, ProjectTagRetrieveParams.none(), requestOptions)

    /**
     * Partially update a project_tag object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    fun update(
        projectTagId: String,
        params: ProjectTagUpdateParams = ProjectTagUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag = update(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

    /** @see [update] */
    fun update(
        params: ProjectTagUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** @see [update] */
    fun update(projectTagId: String, requestOptions: RequestOptions): ProjectTag =
        update(projectTagId, ProjectTagUpdateParams.none(), requestOptions)

    /**
     * List out all project_tags. The project_tags are sorted by creation date, with the most
     * recently-created project_tags coming first
     */
    fun list(
        params: ProjectTagListParams = ProjectTagListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTagListPage

    /** @see [list] */
    fun list(requestOptions: RequestOptions): ProjectTagListPage =
        list(ProjectTagListParams.none(), requestOptions)

    /** Delete a project_tag object by its id */
    fun delete(
        projectTagId: String,
        params: ProjectTagDeleteParams = ProjectTagDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag = delete(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        params: ProjectTagDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** @see [delete] */
    fun delete(projectTagId: String, requestOptions: RequestOptions): ProjectTag =
        delete(projectTagId, ProjectTagDeleteParams.none(), requestOptions)

    /**
     * Create or replace project_tag. If there is an existing project_tag in the project with the
     * same name as the one specified in the request, will replace the existing project_tag with the
     * provided fields
     */
    fun replace(
        params: ProjectTagReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ProjectTag

    /** A view of [ProjectTagService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ProjectTagService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/project_tag`, but is otherwise the same as
         * [ProjectTagService.create].
         */
        @MustBeClosed
        fun create(
            params: ProjectTagCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>

        /**
         * Returns a raw HTTP response for `get /v1/project_tag/{project_tag_id}`, but is otherwise
         * the same as [ProjectTagService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            projectTagId: String,
            params: ProjectTagRetrieveParams = ProjectTagRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag> =
            retrieve(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ProjectTagRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            projectTagId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> =
            retrieve(projectTagId, ProjectTagRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/project_tag/{project_tag_id}`, but is
         * otherwise the same as [ProjectTagService.update].
         */
        @MustBeClosed
        fun update(
            projectTagId: String,
            params: ProjectTagUpdateParams = ProjectTagUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag> =
            update(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ProjectTagUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>

        /** @see [update] */
        @MustBeClosed
        fun update(
            projectTagId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> =
            update(projectTagId, ProjectTagUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/project_tag`, but is otherwise the same as
         * [ProjectTagService.list].
         */
        @MustBeClosed
        fun list(
            params: ProjectTagListParams = ProjectTagListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTagListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ProjectTagListPage> =
            list(ProjectTagListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/project_tag/{project_tag_id}`, but is
         * otherwise the same as [ProjectTagService.delete].
         */
        @MustBeClosed
        fun delete(
            projectTagId: String,
            params: ProjectTagDeleteParams = ProjectTagDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag> =
            delete(params.toBuilder().projectTagId(projectTagId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ProjectTagDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            projectTagId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectTag> =
            delete(projectTagId, ProjectTagDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/project_tag`, but is otherwise the same as
         * [ProjectTagService.replace].
         */
        @MustBeClosed
        fun replace(
            params: ProjectTagReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ProjectTag>
    }
}
