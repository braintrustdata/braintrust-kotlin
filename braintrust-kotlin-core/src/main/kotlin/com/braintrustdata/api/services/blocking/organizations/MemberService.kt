// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking.organizations

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.OrganizationMemberUpdateParams
import com.braintrustdata.api.models.PatchOrganizationMembersOutput

interface MemberService {

    /** Modify organization membership */
    fun update(
        params: OrganizationMemberUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PatchOrganizationMembersOutput
}
