// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PatchProjectScoreTest {

    @Test
    fun createPatchProjectScore() {
        val patchProjectScore =
            PatchProjectScore.builder()
                .categories(
                    PatchProjectScore.Categories.ofList<ProjectScoreCategory>(
                        listOf(ProjectScoreCategory.builder().name("name").value(42.23).build())
                    )
                )
                .description("description")
                .name("name")
                .scoreType(PatchProjectScore.ScoreType.SLIDER)
                .build()
        assertThat(patchProjectScore).isNotNull
        assertThat(patchProjectScore.categories())
            .isEqualTo(
                PatchProjectScore.Categories.ofList<ProjectScoreCategory>(
                    listOf(ProjectScoreCategory.builder().name("name").value(42.23).build())
                )
            )
        assertThat(patchProjectScore.description()).isEqualTo("description")
        assertThat(patchProjectScore.name()).isEqualTo("name")
        assertThat(patchProjectScore.scoreType()).isEqualTo(PatchProjectScore.ScoreType.SLIDER)
    }
}
