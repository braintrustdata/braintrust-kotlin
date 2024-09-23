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
import com.braintrustdata.api.models.OrganizationMemberUpdateResponse

class OrganizationMemberUpdateResponseTest {

    @Test
    fun createOrganizationMemberUpdateResponse() {
      val organizationMemberUpdateResponse = OrganizationMemberUpdateResponse.builder()
          .status(OrganizationMemberUpdateResponse.Status.SUCCESS)
          .sendEmailError("send_email_error")
          .build()
      assertThat(organizationMemberUpdateResponse).isNotNull
      assertThat(organizationMemberUpdateResponse.status()).isEqualTo(OrganizationMemberUpdateResponse.Status.SUCCESS)
      assertThat(organizationMemberUpdateResponse.sendEmailError()).isEqualTo("send_email_error")
    }
}
