// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.blocking

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.BeforeEach
import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.BraintrustClient
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClient
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonString
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.http.BinaryResponseContent
import com.braintrustdata.api.services.blocking.AclService
import com.braintrustdata.api.models.AclListPage
import com.braintrustdata.api.models.AclListParams
import com.braintrustdata.api.models.*

@ExtendWith(TestServerExtension::class)
class AclServiceTest {

    @Test
    fun callCreate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aclService = client.acl()
      val acl = aclService.create(AclCreateParams.builder()
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .objectType(AclCreateParams.ObjectType.ORGANIZATION)
          .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .permission(AclCreateParams.Permission.CREATE)
          .restrictObjectType(AclCreateParams.RestrictObjectType.ORGANIZATION)
          .roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(acl)
      acl.validate()
    }

    @Test
    fun callRetrieve() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aclService = client.acl()
      val acl = aclService.retrieve(AclRetrieveParams.builder()
          .aclId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(acl)
      acl.validate()
    }

    @Test
    fun callList() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aclService = client.acl()
      val response = aclService.list(AclListParams.builder()
          .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(response)
      response.objects().forEach {
          it.validate()
      }
    }

    @Test
    fun callDelete() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val aclService = client.acl()
      val acl = aclService.delete(AclDeleteParams.builder()
          .aclId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(acl)
      acl.validate()
    }
}
