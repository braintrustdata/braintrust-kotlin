// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Group
import com.braintrustdata.api.models.GroupCreateParams
import com.braintrustdata.api.models.GroupDeleteParams
import com.braintrustdata.api.models.GroupListPageAsync
import com.braintrustdata.api.models.GroupListParams
import com.braintrustdata.api.models.GroupReplaceParams
import com.braintrustdata.api.models.GroupRetrieveParams
import com.braintrustdata.api.models.GroupUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface GroupServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): GroupServiceAsync

    /**
     * Create a new group. If there is an existing group with the same name as the one specified in
     * the request, will return the existing group unmodified
     */
    suspend fun create(
        params: GroupCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group

    /** Get a group object by its id */
    suspend fun retrieve(
        groupId: String,
        params: GroupRetrieveParams = GroupRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group = retrieve(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: GroupRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group

    /** @see [retrieve] */
    suspend fun retrieve(groupId: String, requestOptions: RequestOptions): Group =
        retrieve(groupId, GroupRetrieveParams.none(), requestOptions)

    /**
     * Partially update a group object. Specify the fields to update in the payload. Any object-type
     * fields will be deep-merged with existing content. Currently we do not support removing fields
     * or setting them to null.
     */
    suspend fun update(
        groupId: String,
        params: GroupUpdateParams = GroupUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group = update(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see [update] */
    suspend fun update(
        params: GroupUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group

    /** @see [update] */
    suspend fun update(groupId: String, requestOptions: RequestOptions): Group =
        update(groupId, GroupUpdateParams.none(), requestOptions)

    /**
     * List out all groups. The groups are sorted by creation date, with the most recently-created
     * groups coming first
     */
    suspend fun list(
        params: GroupListParams = GroupListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GroupListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): GroupListPageAsync =
        list(GroupListParams.none(), requestOptions)

    /** Delete a group object by its id */
    suspend fun delete(
        groupId: String,
        params: GroupDeleteParams = GroupDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group = delete(params.toBuilder().groupId(groupId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: GroupDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group

    /** @see [delete] */
    suspend fun delete(groupId: String, requestOptions: RequestOptions): Group =
        delete(groupId, GroupDeleteParams.none(), requestOptions)

    /**
     * Create or replace group. If there is an existing group with the same name as the one
     * specified in the request, will replace the existing group with the provided fields
     */
    suspend fun replace(
        params: GroupReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Group

    /** A view of [GroupServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): GroupServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/group`, but is otherwise the same as
         * [GroupServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: GroupCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group>

        /**
         * Returns a raw HTTP response for `get /v1/group/{group_id}`, but is otherwise the same as
         * [GroupServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            groupId: String,
            params: GroupRetrieveParams = GroupRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group> =
            retrieve(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: GroupRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            groupId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Group> = retrieve(groupId, GroupRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/group/{group_id}`, but is otherwise the same
         * as [GroupServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            groupId: String,
            params: GroupUpdateParams = GroupUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group> =
            update(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            params: GroupUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group>

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            groupId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Group> = update(groupId, GroupUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/group`, but is otherwise the same as
         * [GroupServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: GroupListParams = GroupListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GroupListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<GroupListPageAsync> =
            list(GroupListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/group/{group_id}`, but is otherwise the same
         * as [GroupServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            groupId: String,
            params: GroupDeleteParams = GroupDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group> =
            delete(params.toBuilder().groupId(groupId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: GroupDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            groupId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Group> = delete(groupId, GroupDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/group`, but is otherwise the same as
         * [GroupServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: GroupReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Group>
    }
}
