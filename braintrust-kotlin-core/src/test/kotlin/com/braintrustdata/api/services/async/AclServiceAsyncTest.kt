// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClientAsync
import com.braintrustdata.api.models.AclBatchUpdateParams
import com.braintrustdata.api.models.AclCreateParams
import com.braintrustdata.api.models.AclDeleteParams
import com.braintrustdata.api.models.AclFindAndDeleteParams
import com.braintrustdata.api.models.AclListParams
import com.braintrustdata.api.models.AclObjectType
import com.braintrustdata.api.models.AclRetrieveParams
import com.braintrustdata.api.models.Permission
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AclServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val aclServiceAsync = client.acls()

        val acl =
            aclServiceAsync.create(
                AclCreateParams.builder()
                    .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .objectType(AclObjectType.ORGANIZATION)
                    .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .permission(Permission.CREATE)
                    .restrictObjectType(AclObjectType.ORGANIZATION)
                    .roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        acl.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val aclServiceAsync = client.acls()

        val acl =
            aclServiceAsync.retrieve(
                AclRetrieveParams.builder().aclId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        acl.validate()
    }

    @Test
    suspend fun list() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val aclServiceAsync = client.acls()

        val page =
            aclServiceAsync.list(
                AclListParams.builder()
                    .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .objectType(AclObjectType.ORGANIZATION)
                    .build()
            )

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val aclServiceAsync = client.acls()

        val acl =
            aclServiceAsync.delete(
                AclDeleteParams.builder().aclId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        acl.validate()
    }

    @Test
    suspend fun batchUpdate() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val aclServiceAsync = client.acls()

        val aclBatchUpdateResponse =
            aclServiceAsync.batchUpdate(
                AclBatchUpdateParams.builder()
                    .addAddAcl(
                        AclBatchUpdateParams.AddAcl.builder()
                            .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .objectType(AclObjectType.ORGANIZATION)
                            .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .permission(Permission.CREATE)
                            .restrictObjectType(AclObjectType.ORGANIZATION)
                            .roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .addRemoveAcl(
                        AclBatchUpdateParams.RemoveAcl.builder()
                            .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .objectType(AclObjectType.ORGANIZATION)
                            .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .permission(Permission.CREATE)
                            .restrictObjectType(AclObjectType.ORGANIZATION)
                            .roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                            .build()
                    )
                    .build()
            )

        aclBatchUpdateResponse.validate()
    }

    @Test
    suspend fun findAndDelete() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val aclServiceAsync = client.acls()

        val acl =
            aclServiceAsync.findAndDelete(
                AclFindAndDeleteParams.builder()
                    .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .objectType(AclObjectType.ORGANIZATION)
                    .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .permission(Permission.CREATE)
                    .restrictObjectType(AclObjectType.ORGANIZATION)
                    .roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        acl.validate()
    }
}
