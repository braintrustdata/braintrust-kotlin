// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FeedbackProjectLogsItemTest {

    @Test
    fun createFeedbackProjectLogsItem() {
        val feedbackProjectLogsItem =
            FeedbackProjectLogsItem.builder()
                .id("id")
                .comment("comment")
                .expected(JsonNull.of())
                .metadata(FeedbackProjectLogsItem.Metadata.builder().build())
                .scores(FeedbackProjectLogsItem.Scores.builder().build())
                .source(FeedbackProjectLogsItem.Source.APP)
                .build()
        assertThat(feedbackProjectLogsItem).isNotNull
        assertThat(feedbackProjectLogsItem.id()).isEqualTo("id")
        assertThat(feedbackProjectLogsItem.comment()).isEqualTo("comment")
        assertThat(feedbackProjectLogsItem._expected()).isEqualTo(JsonNull.of())
        assertThat(feedbackProjectLogsItem.metadata())
            .isEqualTo(FeedbackProjectLogsItem.Metadata.builder().build())
        assertThat(feedbackProjectLogsItem.scores())
            .isEqualTo(FeedbackProjectLogsItem.Scores.builder().build())
        assertThat(feedbackProjectLogsItem.source()).isEqualTo(FeedbackProjectLogsItem.Source.APP)
    }
}
