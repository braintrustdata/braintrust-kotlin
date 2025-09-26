// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoleUpdateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun pathParams() {
        val params =
            RoleUpdateParams.builder().roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        assertThat(params._pathParam(0)).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.addMemberPermissions())
            .containsExactly(
                RoleUpdateParams.AddMemberPermission.builder()
                    .permission(Permission.CREATE)
                    .restrictObjectType(AclObjectType.ORGANIZATION)
                    .build()
            )
        assertThat(body.addMemberRoles()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(body.description()).isEqualTo("description")
        assertThat(body.name()).isEqualTo("x")
        assertThat(body.removeMemberPermissions())
            .containsExactly(
                RoleUpdateParams.RemoveMemberPermission.builder()
                    .permission(Permission.CREATE)
                    .restrictObjectType(AclObjectType.ORGANIZATION)
                    .build()
            )
        assertThat(body.removeMemberRoles()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            RoleUpdateParams.builder().roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e").build()

        val body = params._body()
    }
}
