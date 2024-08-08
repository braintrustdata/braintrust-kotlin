// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PatchOrganizationTest {

    @Test
    fun createPatchOrganization() {
        val patchOrganization =
            PatchOrganization.builder()
                .apiUrl("api_url")
                .isUniversalApi(true)
                .name("name")
                .proxyUrl("proxy_url")
                .realtimeUrl("realtime_url")
                .build()
        assertThat(patchOrganization).isNotNull
        assertThat(patchOrganization.apiUrl()).isEqualTo("api_url")
        assertThat(patchOrganization.isUniversalApi()).isEqualTo(true)
        assertThat(patchOrganization.name()).isEqualTo("name")
        assertThat(patchOrganization.proxyUrl()).isEqualTo("proxy_url")
        assertThat(patchOrganization.realtimeUrl()).isEqualTo("realtime_url")
    }
}
