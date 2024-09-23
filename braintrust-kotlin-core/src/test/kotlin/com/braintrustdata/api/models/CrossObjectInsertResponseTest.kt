// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CrossObjectInsertResponseTest {

    @Test
    fun createCrossObjectInsertResponse() {
        val crossObjectInsertResponse =
            CrossObjectInsertResponse.builder()
                .dataset(CrossObjectInsertResponse.Dataset.builder().build())
                .experiment(CrossObjectInsertResponse.Experiment.builder().build())
                .projectLogs(CrossObjectInsertResponse.ProjectLogs.builder().build())
                .build()
        assertThat(crossObjectInsertResponse).isNotNull
        assertThat(crossObjectInsertResponse.dataset())
            .isEqualTo(CrossObjectInsertResponse.Dataset.builder().build())
        assertThat(crossObjectInsertResponse.experiment())
            .isEqualTo(CrossObjectInsertResponse.Experiment.builder().build())
        assertThat(crossObjectInsertResponse.projectLogs())
            .isEqualTo(CrossObjectInsertResponse.ProjectLogs.builder().build())
    }
}
