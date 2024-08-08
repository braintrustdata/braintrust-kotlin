// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreateAclTest {

    @Test
    fun createCreateAcl() {
        val createAcl =
            CreateAcl.builder()
                .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .objectType(CreateAcl.ObjectType.ORGANIZATION)
                .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .permission(CreateAcl.Permission.CREATE)
                .restrictObjectType(CreateAcl.RestrictObjectType.ORGANIZATION)
                .roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()
        assertThat(createAcl).isNotNull
        assertThat(createAcl.objectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(createAcl.objectType()).isEqualTo(CreateAcl.ObjectType.ORGANIZATION)
        assertThat(createAcl.groupId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(createAcl.permission()).isEqualTo(CreateAcl.Permission.CREATE)
        assertThat(createAcl.restrictObjectType())
            .isEqualTo(CreateAcl.RestrictObjectType.ORGANIZATION)
        assertThat(createAcl.roleId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(createAcl.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
