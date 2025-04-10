// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.services.blocking.UserService
import java.util.Objects

/**
 * List out all users. The users are sorted by creation date, with the most recently-created users
 * coming first
 */
class UserListPage
private constructor(
    private val usersService: UserService,
    private val params: UserListParams,
    private val response: UserListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): UserListPageResponse = response

    /**
     * Delegates to [UserListPageResponse], but gracefully handles missing data.
     *
     * @see [UserListPageResponse.objects]
     */
    fun objects(): List<User> = response._objects().getNullable("objects") ?: emptyList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListPage && usersService == other.usersService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(usersService, params, response) /* spotless:on */

    override fun toString() =
        "UserListPage{usersService=$usersService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = objects().isNotEmpty()

    fun getNextPageParams(): UserListParams? {
        if (!hasNextPage()) {
            return null
        }

        return if (params.endingBefore() != null) {
            params.toBuilder().endingBefore(objects().first()._id().getNullable("id")).build()
        } else {
            params.toBuilder().startingAfter(objects().last()._id().getNullable("id")).build()
        }
    }

    fun getNextPage(): UserListPage? {
        return getNextPageParams()?.let { usersService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        fun of(usersService: UserService, params: UserListParams, response: UserListPageResponse) =
            UserListPage(usersService, params, response)
    }

    class AutoPager(private val firstPage: UserListPage) : Sequence<User> {

        override fun iterator(): Iterator<User> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.objects().size) {
                    yield(page.objects()[index++])
                }
                page = page.getNextPage() ?: break
                index = 0
            }
        }
    }
}
