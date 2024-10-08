// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GroupTest {

    @Test
    fun createGroup() {
        val group =
            Group.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .name("name")
                .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .deletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .memberGroups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .memberUsers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        assertThat(group).isNotNull
        assertThat(group.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(group.name()).isEqualTo("name")
        assertThat(group.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(group.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(group.deletedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(group.description()).isEqualTo("description")
        assertThat(group.memberGroups()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(group.memberUsers()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(group.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
