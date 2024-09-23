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
import com.braintrustdata.api.models.OrgSecret

class OrgSecretTest {

    @Test
    fun createOrgSecret() {
      val orgSecret = OrgSecret.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .name("name")
          .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .metadata(OrgSecret.Metadata.builder().build())
          .previewSecret("preview_secret")
          .type("type")
          .build()
      assertThat(orgSecret).isNotNull
      assertThat(orgSecret.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(orgSecret.name()).isEqualTo("name")
      assertThat(orgSecret.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(orgSecret.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(orgSecret.metadata()).isEqualTo(OrgSecret.Metadata.builder().build())
      assertThat(orgSecret.previewSecret()).isEqualTo("preview_secret")
      assertThat(orgSecret.type()).isEqualTo("type")
    }
}
