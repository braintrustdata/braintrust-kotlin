// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProjectScoreTest {

    @Test
    fun createProjectScore() {
        val projectScore =
            ProjectScore.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .name("name")
                .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .scoreType(ProjectScore.ScoreType.SLIDER)
                .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .categories(
                    ProjectScore.Categories.ofList<ProjectScoreCategory>(
                        listOf(ProjectScoreCategory.builder().name("name").value(42.23).build())
                    )
                )
                .config(
                    ProjectScore.Config.builder()
                        .destination(ProjectScore.Config.Destination.EXPECTED)
                        .multiSelect(true)
                        .online(
                            ProjectScore.Config.Online.builder()
                                .samplingRate(1.0)
                                .scorers(
                                    listOf(
                                        ProjectScore.Config.Online.Scorer.ofFunction(
                                            ProjectScore.Config.Online.Scorer.Function.builder()
                                                .id("id")
                                                .type(
                                                    ProjectScore.Config.Online.Scorer.Function.Type
                                                        .FUNCTION
                                                )
                                                .build()
                                        )
                                    )
                                )
                                .applyToRootSpan(true)
                                .applyToSpanNames(listOf("string"))
                                .build()
                        )
                        .build()
                )
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .description("description")
                .position("position")
                .build()
        assertThat(projectScore).isNotNull
        assertThat(projectScore.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(projectScore.name()).isEqualTo("name")
        assertThat(projectScore.projectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(projectScore.scoreType()).isEqualTo(ProjectScore.ScoreType.SLIDER)
        assertThat(projectScore.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(projectScore.categories())
            .isEqualTo(
                ProjectScore.Categories.ofList<ProjectScoreCategory>(
                    listOf(ProjectScoreCategory.builder().name("name").value(42.23).build())
                )
            )
        assertThat(projectScore.config())
            .isEqualTo(
                ProjectScore.Config.builder()
                    .destination(ProjectScore.Config.Destination.EXPECTED)
                    .multiSelect(true)
                    .online(
                        ProjectScore.Config.Online.builder()
                            .samplingRate(1.0)
                            .scorers(
                                listOf(
                                    ProjectScore.Config.Online.Scorer.ofFunction(
                                        ProjectScore.Config.Online.Scorer.Function.builder()
                                            .id("id")
                                            .type(
                                                ProjectScore.Config.Online.Scorer.Function.Type
                                                    .FUNCTION
                                            )
                                            .build()
                                    )
                                )
                            )
                            .applyToRootSpan(true)
                            .applyToSpanNames(listOf("string"))
                            .build()
                    )
                    .build()
            )
        assertThat(projectScore.created())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(projectScore.description()).isEqualTo("description")
        assertThat(projectScore.position()).isEqualTo("position")
    }
}