// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.Group
import com.braintrustdata.api.models.GroupCreateParams
import com.braintrustdata.api.models.GroupDeleteParams
import com.braintrustdata.api.models.GroupListPageAsync
import com.braintrustdata.api.models.GroupListParams
import com.braintrustdata.api.models.GroupReplaceParams
import com.braintrustdata.api.models.GroupRetrieveParams
import com.braintrustdata.api.models.GroupUpdateParams

interface GroupServiceAsync {

    /**
     * Create a new group. If there is an existing group with the same name as the one specified in
     * the request, will return the existing group unmodified
     */
    suspend fun create(
        params: GroupCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Group

    /** Get a group object by its id */
    suspend fun retrieve(
        params: GroupRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Group

    /**
     * Partially update a group object. Specify the fields to update in the payload. Any object-type
     * fields will be deep-merged with existing content. Currently we do not support removing fields
     * or setting them to null.
     */
    suspend fun update(
        params: GroupUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Group

    /**
     * List out all groups. The groups are sorted by creation date, with the most recently-created
     * groups coming first
     */
    suspend fun list(
        params: GroupListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): GroupListPageAsync

    /** Delete a group object by its id */
    suspend fun delete(
        params: GroupDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Group

    /**
     * Create or replace group. If there is an existing group with the same name as the one
     * specified in the request, will replace the existing group with the provided fields
     */
    suspend fun replace(
        params: GroupReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Group
}
