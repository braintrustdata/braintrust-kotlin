// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectScoreConfigTest {

    @Test
    fun create() {
        val projectScoreConfig =
            ProjectScoreConfig.builder()
                .destination("destination")
                .multiSelect(true)
                .online(
                    OnlineScoreConfig.builder()
                        .samplingRate(0.0)
                        .addScorer(
                            OnlineScoreConfig.Scorer.Function.builder()
                                .id("id")
                                .type(OnlineScoreConfig.Scorer.Function.Type.FUNCTION)
                                .build()
                        )
                        .applyToRootSpan(true)
                        .addApplyToSpanName("string")
                        .build()
                )
                .build()

        assertThat(projectScoreConfig.destination()).isEqualTo("destination")
        assertThat(projectScoreConfig.multiSelect()).isEqualTo(true)
        assertThat(projectScoreConfig.online())
            .isEqualTo(
                OnlineScoreConfig.builder()
                    .samplingRate(0.0)
                    .addScorer(
                        OnlineScoreConfig.Scorer.Function.builder()
                            .id("id")
                            .type(OnlineScoreConfig.Scorer.Function.Type.FUNCTION)
                            .build()
                    )
                    .applyToRootSpan(true)
                    .addApplyToSpanName("string")
                    .build()
            )
    }
}
