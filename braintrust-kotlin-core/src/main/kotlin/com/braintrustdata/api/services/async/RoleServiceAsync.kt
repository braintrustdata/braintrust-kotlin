// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.Role
import com.braintrustdata.api.models.RoleCreateParams
import com.braintrustdata.api.models.RoleDeleteParams
import com.braintrustdata.api.models.RoleListPageAsync
import com.braintrustdata.api.models.RoleListParams
import com.braintrustdata.api.models.RoleReplaceParams
import com.braintrustdata.api.models.RoleRetrieveParams
import com.braintrustdata.api.models.RoleUpdateParams

interface RoleServiceAsync {

    /**
     * Create a new role. If there is an existing role with the same name as the one specified in
     * the request, will return the existing role unmodified
     */
    suspend fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Role

    /** Get a role object by its id */
    suspend fun retrieve(
        params: RoleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Role

    /**
     * Partially update a role object. Specify the fields to update in the payload. Any object-type
     * fields will be deep-merged with existing content. Currently we do not support removing fields
     * or setting them to null.
     */
    suspend fun update(
        params: RoleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Role

    /**
     * List out all roles. The roles are sorted by creation date, with the most recently-created
     * roles coming first
     */
    suspend fun list(
        params: RoleListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RoleListPageAsync

    /** Delete a role object by its id */
    suspend fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Role

    /**
     * Create or replace role. If there is an existing role with the same name as the one specified
     * in the request, will replace the existing role with the provided fields
     */
    suspend fun replace(
        params: RoleReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Role
}
