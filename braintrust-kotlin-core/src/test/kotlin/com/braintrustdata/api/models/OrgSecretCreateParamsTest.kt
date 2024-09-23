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
import com.braintrustdata.api.models.OrgSecretCreateParams
import com.braintrustdata.api.models.OrgSecretCreateParams.OrgSecretCreateBody

class OrgSecretCreateParamsTest {

    @Test
    fun createOrgSecretCreateParams() {
      OrgSecretCreateParams.builder()
          .name("name")
          .metadata(OrgSecretCreateParams.Metadata.builder().build())
          .orgName("org_name")
          .secret("secret")
          .type("type")
          .build()
    }

    @Test
    fun getBody() {
      val params = OrgSecretCreateParams.builder()
          .name("name")
          .metadata(OrgSecretCreateParams.Metadata.builder().build())
          .orgName("org_name")
          .secret("secret")
          .type("type")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("name")
      assertThat(body.metadata()).isEqualTo(OrgSecretCreateParams.Metadata.builder().build())
      assertThat(body.orgName()).isEqualTo("org_name")
      assertThat(body.secret()).isEqualTo("secret")
      assertThat(body.type()).isEqualTo("type")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = OrgSecretCreateParams.builder()
          .name("name")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.name()).isEqualTo("name")
    }
}
