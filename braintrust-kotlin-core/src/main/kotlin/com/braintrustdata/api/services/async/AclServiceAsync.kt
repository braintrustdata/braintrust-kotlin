// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.ClientOptions
import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.Acl
import com.braintrustdata.api.models.AclBatchUpdateParams
import com.braintrustdata.api.models.AclBatchUpdateResponse
import com.braintrustdata.api.models.AclCreateParams
import com.braintrustdata.api.models.AclDeleteParams
import com.braintrustdata.api.models.AclFindAndDeleteParams
import com.braintrustdata.api.models.AclListPageAsync
import com.braintrustdata.api.models.AclListParams
import com.braintrustdata.api.models.AclRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface AclServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AclServiceAsync

    /**
     * Create a new acl. If there is an existing acl with the same contents as the one specified in
     * the request, will return the existing acl unmodified
     */
    suspend fun create(
        params: AclCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Acl

    /** Get an acl object by its id */
    suspend fun retrieve(
        aclId: String,
        params: AclRetrieveParams = AclRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Acl = retrieve(params.toBuilder().aclId(aclId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: AclRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Acl

    /** @see [retrieve] */
    suspend fun retrieve(aclId: String, requestOptions: RequestOptions): Acl =
        retrieve(aclId, AclRetrieveParams.none(), requestOptions)

    /**
     * List out all acls. The acls are sorted by creation date, with the most recently-created acls
     * coming first
     */
    suspend fun list(
        params: AclListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AclListPageAsync

    /** Delete an acl object by its id */
    suspend fun delete(
        aclId: String,
        params: AclDeleteParams = AclDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Acl = delete(params.toBuilder().aclId(aclId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: AclDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Acl

    /** @see [delete] */
    suspend fun delete(aclId: String, requestOptions: RequestOptions): Acl =
        delete(aclId, AclDeleteParams.none(), requestOptions)

    /**
     * Batch update acls. This operation is idempotent, so adding acls which already exist will have
     * no effect, and removing acls which do not exist will have no effect.
     */
    suspend fun batchUpdate(
        params: AclBatchUpdateParams = AclBatchUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AclBatchUpdateResponse

    /** @see [batchUpdate] */
    suspend fun batchUpdate(requestOptions: RequestOptions): AclBatchUpdateResponse =
        batchUpdate(AclBatchUpdateParams.none(), requestOptions)

    /** Delete a single acl */
    suspend fun findAndDelete(
        params: AclFindAndDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Acl

    /** A view of [AclServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AclServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/acl`, but is otherwise the same as
         * [AclServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: AclCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Acl>

        /**
         * Returns a raw HTTP response for `get /v1/acl/{acl_id}`, but is otherwise the same as
         * [AclServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            aclId: String,
            params: AclRetrieveParams = AclRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Acl> = retrieve(params.toBuilder().aclId(aclId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: AclRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Acl>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(aclId: String, requestOptions: RequestOptions): HttpResponseFor<Acl> =
            retrieve(aclId, AclRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/acl`, but is otherwise the same as
         * [AclServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: AclListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AclListPageAsync>

        /**
         * Returns a raw HTTP response for `delete /v1/acl/{acl_id}`, but is otherwise the same as
         * [AclServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            aclId: String,
            params: AclDeleteParams = AclDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Acl> = delete(params.toBuilder().aclId(aclId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: AclDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Acl>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(aclId: String, requestOptions: RequestOptions): HttpResponseFor<Acl> =
            delete(aclId, AclDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/acl/batch_update`, but is otherwise the same as
         * [AclServiceAsync.batchUpdate].
         */
        @MustBeClosed
        suspend fun batchUpdate(
            params: AclBatchUpdateParams = AclBatchUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AclBatchUpdateResponse>

        /** @see [batchUpdate] */
        @MustBeClosed
        suspend fun batchUpdate(
            requestOptions: RequestOptions
        ): HttpResponseFor<AclBatchUpdateResponse> =
            batchUpdate(AclBatchUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/acl`, but is otherwise the same as
         * [AclServiceAsync.findAndDelete].
         */
        @MustBeClosed
        suspend fun findAndDelete(
            params: AclFindAndDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Acl>
    }
}
