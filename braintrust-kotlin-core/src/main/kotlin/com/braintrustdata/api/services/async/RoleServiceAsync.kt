// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Role
import com.braintrustdata.api.models.RoleCreateParams
import com.braintrustdata.api.models.RoleDeleteParams
import com.braintrustdata.api.models.RoleListPageAsync
import com.braintrustdata.api.models.RoleListParams
import com.braintrustdata.api.models.RoleReplaceParams
import com.braintrustdata.api.models.RoleRetrieveParams
import com.braintrustdata.api.models.RoleUpdateParams
import com.google.errorprone.annotations.MustBeClosed

interface RoleServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Create a new role. If there is an existing role with the same name as the one specified in
     * the request, will return the existing role unmodified
     */
    suspend fun create(
        params: RoleCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** Get a role object by its id */
    suspend fun retrieve(
        roleId: String,
        params: RoleRetrieveParams = RoleRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role = retrieve(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: RoleRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** @see [retrieve] */
    suspend fun retrieve(roleId: String, requestOptions: RequestOptions): Role =
        retrieve(roleId, RoleRetrieveParams.none(), requestOptions)

    /**
     * Partially update a role object. Specify the fields to update in the payload. Any object-type
     * fields will be deep-merged with existing content. Currently we do not support removing fields
     * or setting them to null.
     */
    suspend fun update(
        roleId: String,
        params: RoleUpdateParams = RoleUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role = update(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see [update] */
    suspend fun update(
        params: RoleUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** @see [update] */
    suspend fun update(roleId: String, requestOptions: RequestOptions): Role =
        update(roleId, RoleUpdateParams.none(), requestOptions)

    /**
     * List out all roles. The roles are sorted by creation date, with the most recently-created
     * roles coming first
     */
    suspend fun list(
        params: RoleListParams = RoleListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoleListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): RoleListPageAsync =
        list(RoleListParams.none(), requestOptions)

    /** Delete a role object by its id */
    suspend fun delete(
        roleId: String,
        params: RoleDeleteParams = RoleDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role = delete(params.toBuilder().roleId(roleId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: RoleDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** @see [delete] */
    suspend fun delete(roleId: String, requestOptions: RequestOptions): Role =
        delete(roleId, RoleDeleteParams.none(), requestOptions)

    /**
     * Create or replace role. If there is an existing role with the same name as the one specified
     * in the request, will replace the existing role with the provided fields
     */
    suspend fun replace(
        params: RoleReplaceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Role

    /** A view of [RoleServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/role`, but is otherwise the same as
         * [RoleServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: RoleCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>

        /**
         * Returns a raw HTTP response for `get /v1/role/{role_id}`, but is otherwise the same as
         * [RoleServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            roleId: String,
            params: RoleRetrieveParams = RoleRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role> =
            retrieve(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: RoleRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            roleId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Role> = retrieve(roleId, RoleRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/role/{role_id}`, but is otherwise the same as
         * [RoleServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            roleId: String,
            params: RoleUpdateParams = RoleUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role> = update(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        suspend fun update(
            params: RoleUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>

        /** @see [update] */
        @MustBeClosed
        suspend fun update(roleId: String, requestOptions: RequestOptions): HttpResponseFor<Role> =
            update(roleId, RoleUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/role`, but is otherwise the same as
         * [RoleServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: RoleListParams = RoleListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoleListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<RoleListPageAsync> =
            list(RoleListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/role/{role_id}`, but is otherwise the same as
         * [RoleServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            roleId: String,
            params: RoleDeleteParams = RoleDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role> = delete(params.toBuilder().roleId(roleId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: RoleDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(roleId: String, requestOptions: RequestOptions): HttpResponseFor<Role> =
            delete(roleId, RoleDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/role`, but is otherwise the same as
         * [RoleServiceAsync.replace].
         */
        @MustBeClosed
        suspend fun replace(
            params: RoleReplaceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Role>
    }
}
