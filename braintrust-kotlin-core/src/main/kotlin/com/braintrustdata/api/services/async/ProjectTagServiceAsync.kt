// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.ProjectTag
import com.braintrustdata.api.models.ProjectTagCreateParams
import com.braintrustdata.api.models.ProjectTagDeleteParams
import com.braintrustdata.api.models.ProjectTagListPageAsync
import com.braintrustdata.api.models.ProjectTagListParams
import com.braintrustdata.api.models.ProjectTagReplaceParams
import com.braintrustdata.api.models.ProjectTagRetrieveParams
import com.braintrustdata.api.models.ProjectTagUpdateParams

interface ProjectTagServiceAsync {

    /**
     * Create a new project_tag. If there is an existing project_tag in the project with the same
     * name as the one specified in the request, will return the existing project_tag unmodified
     */
    suspend fun create(
        params: ProjectTagCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProjectTag

    /** Get a project_tag object by its id */
    suspend fun retrieve(
        params: ProjectTagRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProjectTag

    /**
     * Partially update a project_tag object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        params: ProjectTagUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProjectTag

    /**
     * List out all project_tags. The project_tags are sorted by creation date, with the most
     * recently-created project_tags coming first
     */
    suspend fun list(
        params: ProjectTagListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProjectTagListPageAsync

    /** Delete a project_tag object by its id */
    suspend fun delete(
        params: ProjectTagDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProjectTag

    /**
     * Create or replace project_tag. If there is an existing project_tag in the project with the
     * same name as the one specified in the request, will replace the existing project_tag with the
     * provided fields
     */
    suspend fun replace(
        params: ProjectTagReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProjectTag
}
