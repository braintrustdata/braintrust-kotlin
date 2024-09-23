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
import com.braintrustdata.api.models.Experiment

class ExperimentTest {

    @Test
    fun createExperiment() {
      val experiment = Experiment.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .name("name")
          .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .public_(true)
          .baseExpId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .commit("commit")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .datasetId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .datasetVersion("dataset_version")
          .deletedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .description("description")
          .metadata(Experiment.Metadata.builder().build())
          .repoInfo(RepoInfo.builder()
              .authorEmail("author_email")
              .authorName("author_name")
              .branch("branch")
              .commit("commit")
              .commitMessage("commit_message")
              .commitTime("commit_time")
              .dirty(true)
              .gitDiff("git_diff")
              .tag("tag")
              .build())
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(experiment).isNotNull
      assertThat(experiment.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(experiment.name()).isEqualTo("name")
      assertThat(experiment.projectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(experiment.public_()).isEqualTo(true)
      assertThat(experiment.baseExpId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(experiment.commit()).isEqualTo("commit")
      assertThat(experiment.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(experiment.datasetId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(experiment.datasetVersion()).isEqualTo("dataset_version")
      assertThat(experiment.deletedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(experiment.description()).isEqualTo("description")
      assertThat(experiment.metadata()).isEqualTo(Experiment.Metadata.builder().build())
      assertThat(experiment.repoInfo()).isEqualTo(RepoInfo.builder()
          .authorEmail("author_email")
          .authorName("author_name")
          .branch("branch")
          .commit("commit")
          .commitMessage("commit_message")
          .commitTime("commit_time")
          .dirty(true)
          .gitDiff("git_diff")
          .tag("tag")
          .build())
      assertThat(experiment.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
