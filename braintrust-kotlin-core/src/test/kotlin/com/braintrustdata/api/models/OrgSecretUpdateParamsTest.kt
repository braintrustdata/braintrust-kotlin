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
import com.braintrustdata.api.models.OrgSecretUpdateParams
import com.braintrustdata.api.models.OrgSecretUpdateParams.OrgSecretUpdateBody

class OrgSecretUpdateParamsTest {

    @Test
    fun createOrgSecretUpdateParams() {
      OrgSecretUpdateParams.builder()
          .orgSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .metadata(OrgSecretUpdateParams.Metadata.builder().build())
          .name("name")
          .secret("secret")
          .type("type")
          .build()
    }

    @Test
    fun getBody() {
      val params = OrgSecretUpdateParams.builder()
          .orgSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .metadata(OrgSecretUpdateParams.Metadata.builder().build())
          .name("name")
          .secret("secret")
          .type("type")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
      assertThat(body.metadata()).isEqualTo(OrgSecretUpdateParams.Metadata.builder().build())
      assertThat(body.name()).isEqualTo("name")
      assertThat(body.secret()).isEqualTo("secret")
      assertThat(body.type()).isEqualTo("type")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
      val params = OrgSecretUpdateParams.builder()
          .orgSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      val body = params.getBody()
      assertThat(body).isNotNull
    }

    @Test
    fun getPathParam() {
      val params = OrgSecretUpdateParams.builder()
          .orgSecretId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build()
      assertThat(params).isNotNull
      // path param "orgSecretId"
      assertThat(params.getPathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
      // out-of-bound path param
      assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
