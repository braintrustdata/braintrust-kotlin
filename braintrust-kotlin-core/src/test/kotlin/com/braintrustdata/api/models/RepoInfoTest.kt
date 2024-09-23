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
import com.braintrustdata.api.models.RepoInfo

class RepoInfoTest {

    @Test
    fun createRepoInfo() {
      val repoInfo = RepoInfo.builder()
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
      assertThat(repoInfo).isNotNull
      assertThat(repoInfo.authorEmail()).isEqualTo("author_email")
      assertThat(repoInfo.authorName()).isEqualTo("author_name")
      assertThat(repoInfo.branch()).isEqualTo("branch")
      assertThat(repoInfo.commit()).isEqualTo("commit")
      assertThat(repoInfo.commitMessage()).isEqualTo("commit_message")
      assertThat(repoInfo.commitTime()).isEqualTo("commit_time")
      assertThat(repoInfo.dirty()).isEqualTo(true)
      assertThat(repoInfo.gitDiff()).isEqualTo("git_diff")
      assertThat(repoInfo.tag()).isEqualTo("tag")
    }
}
