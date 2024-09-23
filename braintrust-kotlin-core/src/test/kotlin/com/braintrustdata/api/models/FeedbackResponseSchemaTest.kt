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
import com.braintrustdata.api.models.FeedbackResponseSchema

class FeedbackResponseSchemaTest {

    @Test
    fun createFeedbackResponseSchema() {
      val feedbackResponseSchema = FeedbackResponseSchema.builder()
          .status(FeedbackResponseSchema.Status.SUCCESS)
          .build()
      assertThat(feedbackResponseSchema).isNotNull
      assertThat(feedbackResponseSchema.status()).isEqualTo(FeedbackResponseSchema.Status.SUCCESS)
    }
}
