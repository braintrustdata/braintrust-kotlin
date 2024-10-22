// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async.organizations

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.OrganizationMemberUpdateParams
import com.braintrustdata.api.models.PatchOrganizationMembersOutput

interface MemberServiceAsync {

    /** Modify organization membership */
    suspend fun update(
        params: OrganizationMemberUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PatchOrganizationMembersOutput
}
