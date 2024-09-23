// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.apache.hc.core5.http.ContentType
import com.braintrustdata.api.core.ContentTypes
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.MultipartFormValue
import com.braintrustdata.api.models.*
import com.braintrustdata.api.models.OrganizationMemberUpdateParams
import com.braintrustdata.api.models.OrganizationMemberUpdateParams.OrganizationMemberUpdateBody

class OrganizationMemberUpdateParamsTest {

    @Test
    fun createOrganizationMemberUpdateParams() {
      OrganizationMemberUpdateParams.builder()
          .inviteUsers(OrganizationMemberUpdateParams.InviteUsers.builder()
              .emails(listOf("string"))
              .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
              .groupIds(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
              .groupName("group_name")
              .groupNames(listOf("string"))
              .ids(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
              .sendInviteEmails(true)
              .build())
          .orgId("org_id")
          .orgName("org_name")
          .removeUsers(OrganizationMemberUpdateParams.RemoveUsers.builder()
              .emails(listOf("string"))
              .ids(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
              .build())
          .build()
    }

    @Test
    fun getBody() {
      val params = OrganizationMemberUpdateParams.builder()
          .inviteUsers(OrganizationMemberUpdateParams.InviteUsers.builder()
              .emails(listOf("string"))
              .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
              .groupIds(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
              .groupName("group_name")
              .groupNames(listOf("string"))
              .ids(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
              .sendInviteEmails(true)
              .build())
          .orgId("org_id")
          .orgName("org_name")
          .removeUsers(OrganizationMemberUpdateParams.RemoveUsers.builder()
              .emails(listOf("string"))
              .ids(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
              .build())
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.inviteUsers()).isEqualTo(OrganizationMemberUpdateParams.InviteUsers.builder()
          .emails(listOf("string"))
          .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .groupIds(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .groupName("group_name")
          .groupNames(listOf("string"))
          .ids(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .sendInviteEmails(true)
          .build())
      assertThat(body.orgId()).isEqualTo("org_id")
      assertThat(body.orgName()).isEqualTo("org_name")
      assertThat(body.removeUsers()).isEqualTo(OrganizationMemberUpdateParams.RemoveUsers.builder()
          .emails(listOf("string"))
          .ids(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = OrganizationMemberUpdateParams.builder().build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }
}
