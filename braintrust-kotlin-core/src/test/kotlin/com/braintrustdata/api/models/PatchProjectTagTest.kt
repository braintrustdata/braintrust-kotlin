// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PatchProjectTagTest {

    @Test
    fun createPatchProjectTag() {
        val patchProjectTag =
            PatchProjectTag.builder().color("color").description("description").name("name").build()
        assertThat(patchProjectTag).isNotNull
        assertThat(patchProjectTag.color()).isEqualTo("color")
        assertThat(patchProjectTag.description()).isEqualTo("description")
        assertThat(patchProjectTag.name()).isEqualTo("name")
    }
}
