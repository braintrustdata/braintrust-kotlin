// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrganizationTest {

    @Test
    fun createOrganization() {
      val organization = Organization.builder()
          .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .name("name")
          .apiUrl("api_url")
          .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
          .isUniversalApi(true)
          .proxyUrl("proxy_url")
          .realtimeUrl("realtime_url")
          .build()
      assertThat(organization).isNotNull
      assertThat(organization.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      assertThat(organization.name()).isEqualTo("name")
      assertThat(organization.apiUrl()).isEqualTo("api_url")
      assertThat(organization.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
      assertThat(organization.isUniversalApi()).isEqualTo(true)
      assertThat(organization.proxyUrl()).isEqualTo("proxy_url")
      assertThat(organization.realtimeUrl()).isEqualTo("realtime_url")
    }
}
