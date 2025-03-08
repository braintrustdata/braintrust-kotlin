// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.core.http.HttpResponseFor
import com.braintrustdata.api.models.User
import com.braintrustdata.api.models.UserListPageAsync
import com.braintrustdata.api.models.UserListParams
import com.braintrustdata.api.models.UserRetrieveParams
import com.google.errorprone.annotations.MustBeClosed

interface UserServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Get a user object by its id */
    suspend fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): User

    /**
     * List out all users. The users are sorted by creation date, with the most recently-created
     * users coming first
     */
    suspend fun list(
        params: UserListParams = UserListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UserListPageAsync

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): UserListPageAsync =
        list(UserListParams.none(), requestOptions)

    /** A view of [UserServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/user/{user_id}`, but is otherwise the same as
         * [UserServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: UserRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<User>

        /**
         * Returns a raw HTTP response for `get /v1/user`, but is otherwise the same as
         * [UserServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: UserListParams = UserListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UserListPageAsync>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<UserListPageAsync> =
            list(UserListParams.none(), requestOptions)
    }
}
