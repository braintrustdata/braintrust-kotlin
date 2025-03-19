// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeedbackExperimentItemTest {

    @Test
    fun create() {
        val feedbackExperimentItem =
            FeedbackExperimentItem.builder()
                .id("id")
                .comment("comment")
                .expected(JsonValue.from(mapOf<String, Any>()))
                .metadata(
                    FeedbackExperimentItem.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .scores(
                    FeedbackExperimentItem.Scores.builder()
                        .putAdditionalProperty("foo", JsonValue.from(0))
                        .build()
                )
                .source(FeedbackExperimentItem.Source.APP)
                .addTag("string")
                .build()

        assertThat(feedbackExperimentItem.id()).isEqualTo("id")
        assertThat(feedbackExperimentItem.comment()).isEqualTo("comment")
        assertThat(feedbackExperimentItem._expected())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(feedbackExperimentItem.metadata())
            .isEqualTo(
                FeedbackExperimentItem.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(feedbackExperimentItem.scores())
            .isEqualTo(
                FeedbackExperimentItem.Scores.builder()
                    .putAdditionalProperty("foo", JsonValue.from(0))
                    .build()
            )
        assertThat(feedbackExperimentItem.source()).isEqualTo(FeedbackExperimentItem.Source.APP)
        assertThat(feedbackExperimentItem.tags()).containsExactly("string")
    }
}
