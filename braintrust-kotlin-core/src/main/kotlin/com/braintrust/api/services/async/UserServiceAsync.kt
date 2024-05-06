// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.braintrust.api.services.async

import com.braintrust.api.core.RequestOptions
import com.braintrust.api.models.User
import com.braintrust.api.models.UserListPageAsync
import com.braintrust.api.models.UserListParams
import com.braintrust.api.models.UserRetrieveParams

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
