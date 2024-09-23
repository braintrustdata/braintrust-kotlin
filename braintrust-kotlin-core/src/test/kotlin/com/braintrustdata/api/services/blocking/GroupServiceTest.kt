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
import com.braintrustdata.api.services.blocking.GroupService
import com.braintrustdata.api.models.GroupListPage
import com.braintrustdata.api.models.GroupListParams
import com.braintrustdata.api.models.*

@ExtendWith(TestServerExtension::class)
class GroupServiceTest {

    @Test
    fun callCreate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val groupService = client.group()
      val group = groupService.create(GroupCreateParams.builder()
          .name("name")
          .description("description")
          .memberGroups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .memberUsers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .orgName("org_name")
          .build())
      println(group)
      group.validate()
    }

    @Test
    fun callRetrieve() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val groupService = client.group()
      val group = groupService.retrieve(GroupRetrieveParams.builder()
          .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(group)
      group.validate()
    }

    @Test
    fun callUpdate() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val groupService = client.group()
      val group = groupService.update(GroupUpdateParams.builder()
          .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .addMemberGroups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .addMemberUsers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .description("description")
          .name("name")
          .removeMemberGroups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .removeMemberUsers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .build())
      println(group)
      group.validate()
    }

    @Test
    fun callList() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val groupService = client.group()
      val response = groupService.list(GroupListParams.builder().build())
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
      val groupService = client.group()
      val group = groupService.delete(GroupDeleteParams.builder()
          .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
          .build())
      println(group)
      group.validate()
    }

    @Test
    fun callReplace() {
      val client = BraintrustOkHttpClient.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .apiKey("My API Key")
          .build()
      val groupService = client.group()
      val group = groupService.replace(GroupReplaceParams.builder()
          .name("name")
          .description("description")
          .memberGroups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .memberUsers(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
          .orgName("org_name")
          .build())
      println(group)
      group.validate()
    }
}
