// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FeedbackDatasetItemTest {

    @Test
    fun create() {
        val feedbackDatasetItem =
            FeedbackDatasetItem.builder()
                .id("id")
                .comment("comment")
                .metadata(
                    FeedbackDatasetItem.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .source(FeedbackDatasetItem.Source.APP)
                .addTag("string")
                .build()

        assertThat(feedbackDatasetItem.id()).isEqualTo("id")
        assertThat(feedbackDatasetItem.comment()).isEqualTo("comment")
        assertThat(feedbackDatasetItem.metadata())
            .isEqualTo(
                FeedbackDatasetItem.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(feedbackDatasetItem.source()).isEqualTo(FeedbackDatasetItem.Source.APP)
        assertThat(feedbackDatasetItem.tags()).containsExactly("string")
    }
}
