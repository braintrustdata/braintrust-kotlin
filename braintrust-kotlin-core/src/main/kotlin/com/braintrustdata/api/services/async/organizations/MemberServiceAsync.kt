// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async.organizations

import com.braintrustdata.api.core.ClientOptions
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

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MemberServiceAsync

    /** Modify organization membership */
    suspend fun update(
        params: OrganizationMemberUpdateParams = OrganizationMemberUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PatchOrganizationMembersOutput

    /** @see [update] */
    suspend fun update(requestOptions: RequestOptions): PatchOrganizationMembersOutput =
        update(OrganizationMemberUpdateParams.none(), requestOptions)

    /**
     * A view of [MemberServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MemberServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `patch /v1/organization/members`, but is otherwise the
         * same as [MemberServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            params: OrganizationMemberUpdateParams = OrganizationMemberUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PatchOrganizationMembersOutput>

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            requestOptions: RequestOptions
        ): HttpResponseFor<PatchOrganizationMembersOutput> =
            update(OrganizationMemberUpdateParams.none(), requestOptions)
    }
}
