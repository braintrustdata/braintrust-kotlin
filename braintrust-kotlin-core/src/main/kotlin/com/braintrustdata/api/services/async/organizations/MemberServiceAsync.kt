// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async.organizations

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.OrganizationMemberUpdateParams
import com.braintrustdata.api.models.PatchOrganizationMembersOutput
import com.google.errorprone.annotations.MustBeClosed

interface MemberServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Modify organization membership */
    suspend fun update(
        params: OrganizationMemberUpdateParams = OrganizationMemberUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PatchOrganizationMembersOutput

    /** Modify organization membership */
    suspend fun update(requestOptions: RequestOptions): PatchOrganizationMembersOutput =
        update(OrganizationMemberUpdateParams.none(), requestOptions)

    /**
     * A view of [MemberServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `patch /v1/organization/members`, but is otherwise the
         * same as [MemberServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            params: OrganizationMemberUpdateParams = OrganizationMemberUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PatchOrganizationMembersOutput>

        /**
         * Returns a raw HTTP response for `patch /v1/organization/members`, but is otherwise the
         * same as [MemberServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            requestOptions: RequestOptions
        ): HttpResponseFor<PatchOrganizationMembersOutput> =
            update(OrganizationMemberUpdateParams.none(), requestOptions)
    }
}
