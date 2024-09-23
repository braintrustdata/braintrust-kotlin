// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.OrgSecret
import com.braintrustdata.api.models.OrgSecretCreateParams
import com.braintrustdata.api.models.OrgSecretDeleteParams
import com.braintrustdata.api.models.OrgSecretListPageAsync
import com.braintrustdata.api.models.OrgSecretListParams
import com.braintrustdata.api.models.OrgSecretReplaceParams
import com.braintrustdata.api.models.OrgSecretRetrieveParams
import com.braintrustdata.api.models.OrgSecretUpdateParams

interface OrgSecretServiceAsync {

    /**
     * Create a new org_secret. If there is an existing org_secret with the same name as the one
     * specified in the request, will return the existing org_secret unmodified
     */
    suspend fun create(
        params: OrgSecretCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OrgSecret

    /** Get an org_secret object by its id */
    suspend fun retrieve(
        params: OrgSecretRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OrgSecret

    /**
     * Partially update an org_secret object. Specify the fields to update in the payload. Any
     * object-type fields will be deep-merged with existing content. Currently we do not support
     * removing fields or setting them to null.
     */
    suspend fun update(
        params: OrgSecretUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OrgSecret

    /**
     * List out all org_secrets. The org_secrets are sorted by creation date, with the most
     * recently-created org_secrets coming first
     */
    suspend fun list(
        params: OrgSecretListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OrgSecretListPageAsync

    /** Delete an org_secret object by its id */
    suspend fun delete(
        params: OrgSecretDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OrgSecret

    /**
     * Create or replace org_secret. If there is an existing org_secret with the same name as the
     * one specified in the request, will replace the existing org_secret with the provided fields
     */
    suspend fun replace(
        params: OrgSecretReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): OrgSecret
}
