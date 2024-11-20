// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FeedbackDatasetItemTest {

    @Test
    fun createFeedbackDatasetItem() {
        val feedbackDatasetItem =
            FeedbackDatasetItem.builder()
                .id("id")
                .comment("comment")
                .metadata(FeedbackDatasetItem.Metadata.builder().build())
                .source(FeedbackDatasetItem.Source.APP)
                .tags(listOf("string"))
                .build()
        assertThat(feedbackDatasetItem).isNotNull
        assertThat(feedbackDatasetItem.id()).isEqualTo("id")
        assertThat(feedbackDatasetItem.comment()).isEqualTo("comment")
        assertThat(feedbackDatasetItem.metadata())
            .isEqualTo(FeedbackDatasetItem.Metadata.builder().build())
        assertThat(feedbackDatasetItem.source()).isEqualTo(FeedbackDatasetItem.Source.APP)
        assertThat(feedbackDatasetItem.tags()).containsExactly("string")
    }
}
