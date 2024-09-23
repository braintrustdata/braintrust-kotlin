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
import com.braintrustdata.api.models.FeedbackDatasetItem

class FeedbackDatasetItemTest {

    @Test
    fun createFeedbackDatasetItem() {
      val feedbackDatasetItem = FeedbackDatasetItem.builder()
          .id("id")
          .comment("comment")
          .metadata(FeedbackDatasetItem.Metadata.builder().build())
          .source(FeedbackDatasetItem.Source.APP)
          .build()
      assertThat(feedbackDatasetItem).isNotNull
      assertThat(feedbackDatasetItem.id()).isEqualTo("id")
      assertThat(feedbackDatasetItem.comment()).isEqualTo("comment")
      assertThat(feedbackDatasetItem.metadata()).isEqualTo(FeedbackDatasetItem.Metadata.builder().build())
      assertThat(feedbackDatasetItem.source()).isEqualTo(FeedbackDatasetItem.Source.APP)
    }
}
