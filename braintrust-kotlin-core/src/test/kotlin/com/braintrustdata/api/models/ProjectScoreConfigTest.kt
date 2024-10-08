// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProjectScoreConfigTest {

    @Test
    fun createProjectScoreConfig() {
        val projectScoreConfig =
            ProjectScoreConfig.builder()
                .destination(ProjectScoreConfig.Destination.EXPECTED)
                .multiSelect(true)
                .online(
                    OnlineScoreConfig.builder()
                        .samplingRate(1.0)
                        .scorers(
                            listOf(
                                OnlineScoreConfig.Scorer.ofFunction(
                                    OnlineScoreConfig.Scorer.Function.builder()
                                        .id("id")
                                        .type(OnlineScoreConfig.Scorer.Function.Type.FUNCTION)
                                        .build()
                                )
                            )
                        )
                        .applyToRootSpan(true)
                        .applyToSpanNames(listOf("string"))
                        .build()
                )
                .build()
        assertThat(projectScoreConfig).isNotNull
        assertThat(projectScoreConfig.destination())
            .isEqualTo(ProjectScoreConfig.Destination.EXPECTED)
        assertThat(projectScoreConfig.multiSelect()).isEqualTo(true)
        assertThat(projectScoreConfig.online())
            .isEqualTo(
                OnlineScoreConfig.builder()
                    .samplingRate(1.0)
                    .scorers(
                        listOf(
                            OnlineScoreConfig.Scorer.ofFunction(
                                OnlineScoreConfig.Scorer.Function.builder()
                                    .id("id")
                                    .type(OnlineScoreConfig.Scorer.Function.Type.FUNCTION)
                                    .build()
                            )
                        )
                    )
                    .applyToRootSpan(true)
                    .applyToSpanNames(listOf("string"))
                    .build()
            )
    }
}
