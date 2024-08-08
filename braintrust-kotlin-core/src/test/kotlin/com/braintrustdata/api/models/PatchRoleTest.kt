// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PatchRoleTest {

    @Test
    fun createPatchRole() {
        val patchRole =
            PatchRole.builder()
                .addMemberPermissions(
                    listOf(
                        PatchRole.AddMemberPermission.builder()
                            .permission(PatchRole.AddMemberPermission.Permission.CREATE)
                            .restrictObjectType(
                                PatchRole.AddMemberPermission.RestrictObjectType.ORGANIZATION
                            )
                            .build()
                    )
                )
                .addMemberRoles(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .description("description")
                .name("name")
                .removeMemberPermissions(
                    listOf(
                        PatchRole.RemoveMemberPermission.builder()
                            .permission(PatchRole.RemoveMemberPermission.Permission.CREATE)
                            .restrictObjectType(
                                PatchRole.RemoveMemberPermission.RestrictObjectType.ORGANIZATION
                            )
                            .build()
                    )
                )
                .removeMemberRoles(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .build()
        assertThat(patchRole).isNotNull
        assertThat(patchRole.addMemberPermissions())
            .containsExactly(
                PatchRole.AddMemberPermission.builder()
                    .permission(PatchRole.AddMemberPermission.Permission.CREATE)
                    .restrictObjectType(
                        PatchRole.AddMemberPermission.RestrictObjectType.ORGANIZATION
                    )
                    .build()
            )
        assertThat(patchRole.addMemberRoles())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(patchRole.description()).isEqualTo("description")
        assertThat(patchRole.name()).isEqualTo("name")
        assertThat(patchRole.removeMemberPermissions())
            .containsExactly(
                PatchRole.RemoveMemberPermission.builder()
                    .permission(PatchRole.RemoveMemberPermission.Permission.CREATE)
                    .restrictObjectType(
                        PatchRole.RemoveMemberPermission.RestrictObjectType.ORGANIZATION
                    )
                    .build()
            )
        assertThat(patchRole.removeMemberRoles())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
