// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreateProjectTest {

    @Test
    fun createCreateProject() {
        val createProject = CreateProject.builder().name("name").orgName("org_name").build()
        assertThat(createProject).isNotNull
        assertThat(createProject.name()).isEqualTo("name")
        assertThat(createProject.orgName()).isEqualTo("org_name")
    }
}
