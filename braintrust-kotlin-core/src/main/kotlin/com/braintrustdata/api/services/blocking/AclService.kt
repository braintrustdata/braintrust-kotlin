// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.Acl
import com.braintrustdata.api.models.AclBatchUpdateParams
import com.braintrustdata.api.models.AclBatchUpdateResponse
import com.braintrustdata.api.models.AclCreateParams
import com.braintrustdata.api.models.AclDeleteParams
import com.braintrustdata.api.models.AclFindAndDeleteParams
import com.braintrustdata.api.models.AclListPage
import com.braintrustdata.api.models.AclListParams
import com.braintrustdata.api.models.AclRetrieveParams

interface AclService {

    /**
     * Create a new acl. If there is an existing acl with the same contents as the one specified in
     * the request, will return the existing acl unmodified
     */
    fun create(params: AclCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Acl

    /** Get an acl object by its id */
    fun retrieve(
        params: AclRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Acl

    /**
     * List out all acls. The acls are sorted by creation date, with the most recently-created acls
     * coming first
     */
    fun list(
        params: AclListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AclListPage

    /** Delete an acl object by its id */
    fun delete(params: AclDeleteParams, requestOptions: RequestOptions = RequestOptions.none()): Acl

    /**
     * Batch update acls. This operation is idempotent, so adding acls which already exist will have
     * no effect, and removing acls which do not exist will have no effect.
     */
    fun batchUpdate(
        params: AclBatchUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AclBatchUpdateResponse

    /** Delete a single acl */
    fun findAndDelete(
        params: AclFindAndDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Acl
}
