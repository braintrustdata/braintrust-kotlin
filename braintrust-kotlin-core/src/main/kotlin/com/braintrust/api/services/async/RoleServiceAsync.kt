// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrust.api.services.async

import com.braintrust.api.core.RequestOptions
import com.braintrust.api.models.Role
import com.braintrust.api.models.RoleCreateParams
import com.braintrust.api.models.RoleDeleteParams
import com.braintrust.api.models.RoleListPageAsync
import com.braintrust.api.models.RoleListParams
import com.braintrust.api.models.RoleReplaceParams
import com.braintrust.api.models.RoleRetrieveParams
import com.braintrust.api.models.RoleUpdateParams

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
     * NOTE: This operation is deprecated and will be removed in a future revision of the API.
     * Create or replace a new role. If there is an existing role with the same name as the one
     * specified in the request, will return the existing role unmodified, will replace the existing
     * role with the provided fields
     */
    suspend fun replace(
        params: RoleReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Role
}
