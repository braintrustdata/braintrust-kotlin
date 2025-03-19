// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    fun create() {
        val user =
            User.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .avatarUrl("avatar_url")
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .email("email")
                .familyName("family_name")
                .givenName("given_name")
                .build()

        assertThat(user.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(user.avatarUrl()).isEqualTo("avatar_url")
        assertThat(user.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(user.email()).isEqualTo("email")
        assertThat(user.familyName()).isEqualTo("family_name")
        assertThat(user.givenName()).isEqualTo("given_name")
    }
}
