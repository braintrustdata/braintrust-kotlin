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
import com.braintrustdata.api.models.FeedbackExperimentItem

class FeedbackExperimentItemTest {

    @Test
    fun createFeedbackExperimentItem() {
      val feedbackExperimentItem = FeedbackExperimentItem.builder()
          .id("id")
          .comment("comment")
          .expected(JsonValue.from(mapOf<String, Any>()))
          .metadata(FeedbackExperimentItem.Metadata.builder().build())
          .scores(FeedbackExperimentItem.Scores.builder().build())
          .source(FeedbackExperimentItem.Source.APP)
          .build()
      assertThat(feedbackExperimentItem).isNotNull
      assertThat(feedbackExperimentItem.id()).isEqualTo("id")
      assertThat(feedbackExperimentItem.comment()).isEqualTo("comment")
      assertThat(feedbackExperimentItem._expected()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
      assertThat(feedbackExperimentItem.metadata()).isEqualTo(FeedbackExperimentItem.Metadata.builder().build())
      assertThat(feedbackExperimentItem.scores()).isEqualTo(FeedbackExperimentItem.Scores.builder().build())
      assertThat(feedbackExperimentItem.source()).isEqualTo(FeedbackExperimentItem.Source.APP)
    }
}
