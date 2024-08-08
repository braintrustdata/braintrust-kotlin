// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PatchDatasetTest {

    @Test
    fun createPatchDataset() {
        val patchDataset =
            PatchDataset.builder()
                .description("description")
                .metadata(PatchDataset.Metadata.builder().build())
                .name("name")
                .build()
        assertThat(patchDataset).isNotNull
        assertThat(patchDataset.description()).isEqualTo("description")
        assertThat(patchDataset.metadata()).isEqualTo(PatchDataset.Metadata.builder().build())
        assertThat(patchDataset.name()).isEqualTo("name")
    }
}
