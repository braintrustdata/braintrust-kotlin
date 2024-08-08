// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PatchExperimentTest {

    @Test
    fun createPatchExperiment() {
        val patchExperiment =
            PatchExperiment.builder()
                .baseExpId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .datasetId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .datasetVersion("dataset_version")
                .description("description")
                .metadata(PatchExperiment.Metadata.builder().build())
                .name("name")
                .public_(true)
                .repoInfo(
                    RepoInfo.builder()
                        .authorEmail("author_email")
                        .authorName("author_name")
                        .branch("branch")
                        .commit("commit")
                        .commitMessage("commit_message")
                        .commitTime("commit_time")
                        .dirty(true)
                        .gitDiff("git_diff")
                        .tag("tag")
                        .build()
                )
                .build()
        assertThat(patchExperiment).isNotNull
        assertThat(patchExperiment.baseExpId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(patchExperiment.datasetId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(patchExperiment.datasetVersion()).isEqualTo("dataset_version")
        assertThat(patchExperiment.description()).isEqualTo("description")
        assertThat(patchExperiment.metadata()).isEqualTo(PatchExperiment.Metadata.builder().build())
        assertThat(patchExperiment.name()).isEqualTo("name")
        assertThat(patchExperiment.public_()).isEqualTo(true)
        assertThat(patchExperiment.repoInfo())
            .isEqualTo(
                RepoInfo.builder()
                    .authorEmail("author_email")
                    .authorName("author_name")
                    .branch("branch")
                    .commit("commit")
                    .commitMessage("commit_message")
                    .commitTime("commit_time")
                    .dirty(true)
                    .gitDiff("git_diff")
                    .tag("tag")
                    .build()
            )
    }
}
