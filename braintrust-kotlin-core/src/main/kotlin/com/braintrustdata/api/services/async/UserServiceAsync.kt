// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrustdata.api.services.async

import com.braintrustdata.api.core.RequestOptions
import com.braintrustdata.api.models.User
import com.braintrustdata.api.models.UserListPageAsync
import com.braintrustdata.api.models.UserListParams
import com.braintrustdata.api.models.UserRetrieveParams

interface UserServiceAsync {

    /** Get a user object by its id */
    suspend fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): User

    /**
     * List out all users. The users are sorted by creation date, with the most recently-created
     * users coming first
     */
    suspend fun list(
        params: UserListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): UserListPageAsync
}
