// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CrossObjectInsertRequestTest {

    @Test
    fun createCrossObjectInsertRequest() {
        val crossObjectInsertRequest =
            CrossObjectInsertRequest.builder()
                .dataset(CrossObjectInsertRequest.Dataset.builder().build())
                .experiment(CrossObjectInsertRequest.Experiment.builder().build())
                .projectLogs(CrossObjectInsertRequest.ProjectLogs.builder().build())
                .build()
        assertThat(crossObjectInsertRequest).isNotNull
        assertThat(crossObjectInsertRequest.dataset())
            .isEqualTo(CrossObjectInsertRequest.Dataset.builder().build())
        assertThat(crossObjectInsertRequest.experiment())
            .isEqualTo(CrossObjectInsertRequest.Experiment.builder().build())
        assertThat(crossObjectInsertRequest.projectLogs())
            .isEqualTo(CrossObjectInsertRequest.ProjectLogs.builder().build())
    }
}
