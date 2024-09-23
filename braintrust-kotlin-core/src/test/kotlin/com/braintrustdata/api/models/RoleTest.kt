// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.models.Role

class RoleTest {

    @Test
    fun createRole() {
      val role = Role.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .name("name")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .deletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .description("description")
          .memberPermissions(listOf(Role.MemberPermission.builder()
              .permission(Role.MemberPermission.Permission.CREATE)
              .restrictObjectType(Role.MemberPermission.RestrictObjectType.ORGANIZATION)
              .build()))
          .memberRoles(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(role).isNotNull
      assertThat(role.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(role.name()).isEqualTo("name")
      assertThat(role.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(role.deletedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(role.description()).isEqualTo("description")
      assertThat(role.memberPermissions()).containsExactly(Role.MemberPermission.builder()
          .permission(Role.MemberPermission.Permission.CREATE)
          .restrictObjectType(Role.MemberPermission.RestrictObjectType.ORGANIZATION)
          .build())
      assertThat(role.memberRoles()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(role.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(role.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
