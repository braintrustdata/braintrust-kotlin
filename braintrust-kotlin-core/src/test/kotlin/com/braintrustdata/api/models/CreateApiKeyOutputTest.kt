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
import com.braintrustdata.api.models.CreateApiKeyOutput

class CreateApiKeyOutputTest {

    @Test
    fun createCreateApiKeyOutput() {
      val createApiKeyOutput = CreateApiKeyOutput.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .key("key")
          .name("name")
          .previewName("preview_name")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .orgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(createApiKeyOutput).isNotNull
      assertThat(createApiKeyOutput.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(createApiKeyOutput.key()).isEqualTo("key")
      assertThat(createApiKeyOutput.name()).isEqualTo("name")
      assertThat(createApiKeyOutput.previewName()).isEqualTo("preview_name")
      assertThat(createApiKeyOutput.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(createApiKeyOutput.orgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(createApiKeyOutput.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
