// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.apache.hc.core5.http.ContentType
import com.braintrustdata.api.core.ContentTypes
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.MultipartFormValue
import com.braintrustdata.api.models.*
import com.braintrustdata.api.models.ApiKeyResourceCreateParams
import com.braintrustdata.api.models.ApiKeyResourceCreateParams.ApiKeyResourceCreateBody

class ApiKeyResourceCreateParamsTest {

    @Test
    fun createApiKeyResourceCreateParams() {
      ApiKeyResourceCreateParams.builder()
          .name("name")
          .orgName("org_name")
          .build()
    }

    @Test
    fun getBody() {
      val params = ApiKeyResourceCreateParams.builder()
          .name("name")
          .orgName("org_name")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("name")
      assertThat(body.orgName()).isEqualTo("org_name")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = ApiKeyResourceCreateParams.builder()
          .name("name")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("name")
    }
}
