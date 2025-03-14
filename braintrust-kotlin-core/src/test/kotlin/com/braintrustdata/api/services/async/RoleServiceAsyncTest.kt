// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.services.async

import com.braintrustdata.api.TestServerExtension
import com.braintrustdata.api.client.okhttp.BraintrustOkHttpClientAsync
import com.braintrustdata.api.models.AclObjectType
import com.braintrustdata.api.models.Permission
import com.braintrustdata.api.models.RoleCreateParams
import com.braintrustdata.api.models.RoleDeleteParams
import com.braintrustdata.api.models.RoleReplaceParams
import com.braintrustdata.api.models.RoleRetrieveParams
import com.braintrustdata.api.models.RoleUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class RoleServiceAsyncTest {

    @Test
    suspend fun create() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val roleServiceAsync = client.roles()

        val role =
            roleServiceAsync.create(
                RoleCreateParams.builder()
                    .name("x")
                    .description("description")
                    .addMemberPermission(
                        RoleCreateParams.MemberPermission.builder()
                            .permission(Permission.CREATE)
                            .restrictObjectType(AclObjectType.ORGANIZATION)
                            .build()
                    )
                    .addMemberRole("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orgName("org_name")
                    .build()
            )

        role.validate()
    }

    @Test
    suspend fun retrieve() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val roleServiceAsync = client.roles()

        val role =
            roleServiceAsync.retrieve(
                RoleRetrieveParams.builder().roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        role.validate()
    }

    @Test
    suspend fun update() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val roleServiceAsync = client.roles()

        val role =
            roleServiceAsync.update(
                RoleUpdateParams.builder()
                    .roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .addAddMemberPermission(
                        RoleUpdateParams.AddMemberPermission.builder()
                            .permission(Permission.CREATE)
                            .restrictObjectType(AclObjectType.ORGANIZATION)
                            .build()
                    )
                    .addAddMemberRole("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .description("description")
                    .name("x")
                    .addRemoveMemberPermission(
                        RoleUpdateParams.RemoveMemberPermission.builder()
                            .permission(Permission.CREATE)
                            .restrictObjectType(AclObjectType.ORGANIZATION)
                            .build()
                    )
                    .addRemoveMemberRole("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )

        role.validate()
    }

    @Test
    suspend fun list() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val roleServiceAsync = client.roles()

        val page = roleServiceAsync.list()

        page.response().validate()
    }

    @Test
    suspend fun delete() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val roleServiceAsync = client.roles()

        val role =
            roleServiceAsync.delete(
                RoleDeleteParams.builder().roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()
            )

        role.validate()
    }

    @Test
    suspend fun replace() {
        val client =
            BraintrustOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val roleServiceAsync = client.roles()

        val role =
            roleServiceAsync.replace(
                RoleReplaceParams.builder()
                    .name("x")
                    .description("description")
                    .addMemberPermission(
                        RoleReplaceParams.MemberPermission.builder()
                            .permission(Permission.CREATE)
                            .restrictObjectType(AclObjectType.ORGANIZATION)
                            .build()
                    )
                    .addMemberRole("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .orgName("org_name")
                    .build()
            )

        role.validate()
    }
}
