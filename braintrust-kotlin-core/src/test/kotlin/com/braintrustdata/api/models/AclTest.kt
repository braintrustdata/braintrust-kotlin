// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AclTest {

    @Test
    fun create() {
        val acl =
            Acl.builder()
                .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                ._objectOrgId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .objectId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .objectType(AclObjectType.ORGANIZATION)
                .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .groupId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .permission(Permission.CREATE)
                .restrictObjectType(AclObjectType.ORGANIZATION)
                .roleId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .userId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .build()

        assertThat(acl.id()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(acl._objectOrgId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(acl.objectId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(acl.objectType()).isEqualTo(AclObjectType.ORGANIZATION)
        assertThat(acl.created()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(acl.groupId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(acl.permission()).isEqualTo(Permission.CREATE)
        assertThat(acl.restrictObjectType()).isEqualTo(AclObjectType.ORGANIZATION)
        assertThat(acl.roleId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(acl.userId()).isEqualTo("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
    }
}
