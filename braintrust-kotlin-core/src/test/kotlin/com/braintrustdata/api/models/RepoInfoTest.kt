// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RepoInfoTest {

    @Test
    fun createRepoInfo() {
        val repoInfo =
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
