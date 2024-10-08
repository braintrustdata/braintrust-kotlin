// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProjectUpdateParamsTest {

    @Test
    fun createProjectUpdateParams() {
        ProjectUpdateParams.builder()
            .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
            .name("name")
            .settings(ProjectSettings.builder().comparisonKey("comparison_key").build())
            .build()
    }

    @Test
    fun getBody() {
        val params =
            ProjectUpdateParams.builder()
                .projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .name("name")
                .settings(ProjectSettings.builder().comparisonKey("comparison_key").build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("name")
        assertThat(body.settings())
            .isEqualTo(ProjectSettings.builder().comparisonKey("comparison_key").build())
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ProjectUpdateParams.builder().projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        val body = params.getBody()
        assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
        val params =
            ProjectUpdateParams.builder().projectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
        assertThat(params).isNotNull
        // path param "projectId"
        assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
