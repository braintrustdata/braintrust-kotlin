// File generated from our OpenAPI spec by Stainless.

package com.braintrust.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RoleTest {

    @Test
    fun createRole() {
        val role =
            Role.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .name("string")
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .deletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("string")
                .memberPermissions(listOf(Role.MemberPermission.CREATE))
                .memberRoles(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        assertThat(role).isNotNull
        assertThat(role.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(role.name()).isEqualTo("string")
        assertThat(role.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(role.deletedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(role.description()).isEqualTo("string")
        assertThat(role.memberPermissions()).containsExactly(Role.MemberPermission.CREATE)
        assertThat(role.memberRoles()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(role.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(role.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
