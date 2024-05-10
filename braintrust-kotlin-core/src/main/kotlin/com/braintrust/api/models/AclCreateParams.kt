// File generated from our OpenAPI spec by Stainless.

package com.braintrust.api.models

import com.braintrust.api.core.Enum
import com.braintrust.api.core.ExcludeMissing
import com.braintrust.api.core.JsonField
import com.braintrust.api.core.JsonValue
import com.braintrust.api.core.NoAutoDetect
import com.braintrust.api.core.toUnmodifiable
import com.braintrust.api.errors.BraintrustInvalidDataException
import com.braintrust.api.models.*
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects

class AclCreateParams
constructor(
    private val objectId: String,
    private val objectType: ObjectType?,
    private val groupId: String?,
    private val permission: Permission?,
    private val restrictObjectType: RestrictObjectType?,
    private val roleId: String?,
    private val userId: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun objectId(): String = objectId

    fun objectType(): ObjectType? = objectType

    fun groupId(): String? = groupId

    fun permission(): Permission? = permission

    fun restrictObjectType(): RestrictObjectType? = restrictObjectType

    fun roleId(): String? = roleId

    fun userId(): String? = userId

    internal fun getBody(): AclCreateBody {
        return AclCreateBody(
            objectId,
            objectType,
            groupId,
            permission,
            restrictObjectType,
            roleId,
            userId,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    /**
     * An ACL grants a certain permission or role to a certain user or group on an object.
     *
     * ACLs are inherited across the object hierarchy. So for example, if a user has read
     * permissions on a project, they will also have read permissions on any experiment, dataset,
     * etc. created within that project.
     *
     * To restrict a grant to a particular sub-object, you may specify `restrict_object_type` in the
     * ACL.
     */
    @JsonDeserialize(builder = AclCreateBody.Builder::class)
    @NoAutoDetect
    class AclCreateBody
    internal constructor(
        private val objectId: String?,
        private val objectType: ObjectType?,
        private val groupId: String?,
        private val permission: Permission?,
        private val restrictObjectType: RestrictObjectType?,
        private val roleId: String?,
        private val userId: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The id of the object the ACL applies to */
        @JsonProperty("object_id") fun objectId(): String? = objectId

        /** The object type that the ACL applies to */
        @JsonProperty("object_type") fun objectType(): ObjectType? = objectType

        /**
         * Id of the group the ACL applies to. Exactly one of `user_id` and `group_id` will be
         * provided
         */
        @JsonProperty("group_id") fun groupId(): String? = groupId

        /** Permission the ACL grants. Exactly one of `permission` and `role_id` will be provided */
        @JsonProperty("permission") fun permission(): Permission? = permission

        /** Optionally restricts the permission grant to just the specified object type */
        @JsonProperty("restrict_object_type")
        fun restrictObjectType(): RestrictObjectType? = restrictObjectType

        /**
         * Id of the role the ACL grants. Exactly one of `permission` and `role_id` will be provided
         */
        @JsonProperty("role_id") fun roleId(): String? = roleId

        /**
         * Id of the user the ACL applies to. Exactly one of `user_id` and `group_id` will be
         * provided
         */
        @JsonProperty("user_id") fun userId(): String? = userId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AclCreateBody &&
                this.objectId == other.objectId &&
                this.objectType == other.objectType &&
                this.groupId == other.groupId &&
                this.permission == other.permission &&
                this.restrictObjectType == other.restrictObjectType &&
                this.roleId == other.roleId &&
                this.userId == other.userId &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        objectId,
                        objectType,
                        groupId,
                        permission,
                        restrictObjectType,
                        roleId,
                        userId,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AclCreateBody{objectId=$objectId, objectType=$objectType, groupId=$groupId, permission=$permission, restrictObjectType=$restrictObjectType, roleId=$roleId, userId=$userId, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objectId: String? = null
            private var objectType: ObjectType? = null
            private var groupId: String? = null
            private var permission: Permission? = null
            private var restrictObjectType: RestrictObjectType? = null
            private var roleId: String? = null
            private var userId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(aclCreateBody: AclCreateBody) = apply {
                this.objectId = aclCreateBody.objectId
                this.objectType = aclCreateBody.objectType
                this.groupId = aclCreateBody.groupId
                this.permission = aclCreateBody.permission
                this.restrictObjectType = aclCreateBody.restrictObjectType
                this.roleId = aclCreateBody.roleId
                this.userId = aclCreateBody.userId
                additionalProperties(aclCreateBody.additionalProperties)
            }

            /** The id of the object the ACL applies to */
            @JsonProperty("object_id")
            fun objectId(objectId: String) = apply { this.objectId = objectId }

            /** The object type that the ACL applies to */
            @JsonProperty("object_type")
            fun objectType(objectType: ObjectType) = apply { this.objectType = objectType }

            /**
             * Id of the group the ACL applies to. Exactly one of `user_id` and `group_id` will be
             * provided
             */
            @JsonProperty("group_id")
            fun groupId(groupId: String) = apply { this.groupId = groupId }

            /**
             * Permission the ACL grants. Exactly one of `permission` and `role_id` will be provided
             */
            @JsonProperty("permission")
            fun permission(permission: Permission) = apply { this.permission = permission }

            /** Optionally restricts the permission grant to just the specified object type */
            @JsonProperty("restrict_object_type")
            fun restrictObjectType(restrictObjectType: RestrictObjectType) = apply {
                this.restrictObjectType = restrictObjectType
            }

            /**
             * Id of the role the ACL grants. Exactly one of `permission` and `role_id` will be
             * provided
             */
            @JsonProperty("role_id") fun roleId(roleId: String) = apply { this.roleId = roleId }

            /**
             * Id of the user the ACL applies to. Exactly one of `user_id` and `group_id` will be
             * provided
             */
            @JsonProperty("user_id") fun userId(userId: String) = apply { this.userId = userId }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): AclCreateBody =
                AclCreateBody(
                    checkNotNull(objectId) { "`objectId` is required but was not set" },
                    objectType,
                    groupId,
                    permission,
                    restrictObjectType,
                    roleId,
                    userId,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AclCreateParams &&
            this.objectId == other.objectId &&
            this.objectType == other.objectType &&
            this.groupId == other.groupId &&
            this.permission == other.permission &&
            this.restrictObjectType == other.restrictObjectType &&
            this.roleId == other.roleId &&
            this.userId == other.userId &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            objectId,
            objectType,
            groupId,
            permission,
            restrictObjectType,
            roleId,
            userId,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "AclCreateParams{objectId=$objectId, objectType=$objectType, groupId=$groupId, permission=$permission, restrictObjectType=$restrictObjectType, roleId=$roleId, userId=$userId, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var objectId: String? = null
        private var objectType: ObjectType? = null
        private var groupId: String? = null
        private var permission: Permission? = null
        private var restrictObjectType: RestrictObjectType? = null
        private var roleId: String? = null
        private var userId: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(aclCreateParams: AclCreateParams) = apply {
            this.objectId = aclCreateParams.objectId
            this.objectType = aclCreateParams.objectType
            this.groupId = aclCreateParams.groupId
            this.permission = aclCreateParams.permission
            this.restrictObjectType = aclCreateParams.restrictObjectType
            this.roleId = aclCreateParams.roleId
            this.userId = aclCreateParams.userId
            additionalQueryParams(aclCreateParams.additionalQueryParams)
            additionalHeaders(aclCreateParams.additionalHeaders)
            additionalBodyProperties(aclCreateParams.additionalBodyProperties)
        }

        /** The id of the object the ACL applies to */
        fun objectId(objectId: String) = apply { this.objectId = objectId }

        /** The object type that the ACL applies to */
        fun objectType(objectType: ObjectType) = apply { this.objectType = objectType }

        /**
         * Id of the group the ACL applies to. Exactly one of `user_id` and `group_id` will be
         * provided
         */
        fun groupId(groupId: String) = apply { this.groupId = groupId }

        /** Permission the ACL grants. Exactly one of `permission` and `role_id` will be provided */
        fun permission(permission: Permission) = apply { this.permission = permission }

        /** Optionally restricts the permission grant to just the specified object type */
        fun restrictObjectType(restrictObjectType: RestrictObjectType) = apply {
            this.restrictObjectType = restrictObjectType
        }

        /**
         * Id of the role the ACL grants. Exactly one of `permission` and `role_id` will be provided
         */
        fun roleId(roleId: String) = apply { this.roleId = roleId }

        /**
         * Id of the user the ACL applies to. Exactly one of `user_id` and `group_id` will be
         * provided
         */
        fun userId(userId: String) = apply { this.userId = userId }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): AclCreateParams =
            AclCreateParams(
                checkNotNull(objectId) { "`objectId` is required but was not set" },
                objectType,
                groupId,
                permission,
                restrictObjectType,
                roleId,
                userId,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class ObjectType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ObjectType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val ORGANIZATION = ObjectType(JsonField.of("organization"))

            val PROJECT = ObjectType(JsonField.of("project"))

            val EXPERIMENT = ObjectType(JsonField.of("experiment"))

            val DATASET = ObjectType(JsonField.of("dataset"))

            val PROMPT = ObjectType(JsonField.of("prompt"))

            val PROMPT_SESSION = ObjectType(JsonField.of("prompt_session"))

            val PROJECT_SCORE = ObjectType(JsonField.of("project_score"))

            val PROJECT_TAG = ObjectType(JsonField.of("project_tag"))

            val GROUP = ObjectType(JsonField.of("group"))

            val ROLE = ObjectType(JsonField.of("role"))

            fun of(value: String) = ObjectType(JsonField.of(value))
        }

        enum class Known {
            ORGANIZATION,
            PROJECT,
            EXPERIMENT,
            DATASET,
            PROMPT,
            PROMPT_SESSION,
            PROJECT_SCORE,
            PROJECT_TAG,
            GROUP,
            ROLE,
        }

        enum class Value {
            ORGANIZATION,
            PROJECT,
            EXPERIMENT,
            DATASET,
            PROMPT,
            PROMPT_SESSION,
            PROJECT_SCORE,
            PROJECT_TAG,
            GROUP,
            ROLE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ORGANIZATION -> Value.ORGANIZATION
                PROJECT -> Value.PROJECT
                EXPERIMENT -> Value.EXPERIMENT
                DATASET -> Value.DATASET
                PROMPT -> Value.PROMPT
                PROMPT_SESSION -> Value.PROMPT_SESSION
                PROJECT_SCORE -> Value.PROJECT_SCORE
                PROJECT_TAG -> Value.PROJECT_TAG
                GROUP -> Value.GROUP
                ROLE -> Value.ROLE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ORGANIZATION -> Known.ORGANIZATION
                PROJECT -> Known.PROJECT
                EXPERIMENT -> Known.EXPERIMENT
                DATASET -> Known.DATASET
                PROMPT -> Known.PROMPT
                PROMPT_SESSION -> Known.PROMPT_SESSION
                PROJECT_SCORE -> Known.PROJECT_SCORE
                PROJECT_TAG -> Known.PROJECT_TAG
                GROUP -> Known.GROUP
                ROLE -> Known.ROLE
                else -> throw BraintrustInvalidDataException("Unknown ObjectType: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Permission
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Permission && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val CREATE = Permission(JsonField.of("create"))

            val READ = Permission(JsonField.of("read"))

            val UPDATE = Permission(JsonField.of("update"))

            val DELETE = Permission(JsonField.of("delete"))

            val CREATE_ACLS = Permission(JsonField.of("create_acls"))

            val READ_ACLS = Permission(JsonField.of("read_acls"))

            val UPDATE_ACLS = Permission(JsonField.of("update_acls"))

            val DELETE_ACLS = Permission(JsonField.of("delete_acls"))

            fun of(value: String) = Permission(JsonField.of(value))
        }

        enum class Known {
            CREATE,
            READ,
            UPDATE,
            DELETE,
            CREATE_ACLS,
            READ_ACLS,
            UPDATE_ACLS,
            DELETE_ACLS,
        }

        enum class Value {
            CREATE,
            READ,
            UPDATE,
            DELETE,
            CREATE_ACLS,
            READ_ACLS,
            UPDATE_ACLS,
            DELETE_ACLS,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                CREATE -> Value.CREATE
                READ -> Value.READ
                UPDATE -> Value.UPDATE
                DELETE -> Value.DELETE
                CREATE_ACLS -> Value.CREATE_ACLS
                READ_ACLS -> Value.READ_ACLS
                UPDATE_ACLS -> Value.UPDATE_ACLS
                DELETE_ACLS -> Value.DELETE_ACLS
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                CREATE -> Known.CREATE
                READ -> Known.READ
                UPDATE -> Known.UPDATE
                DELETE -> Known.DELETE
                CREATE_ACLS -> Known.CREATE_ACLS
                READ_ACLS -> Known.READ_ACLS
                UPDATE_ACLS -> Known.UPDATE_ACLS
                DELETE_ACLS -> Known.DELETE_ACLS
                else -> throw BraintrustInvalidDataException("Unknown Permission: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class RestrictObjectType
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is RestrictObjectType && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val ORGANIZATION = RestrictObjectType(JsonField.of("organization"))

            val PROJECT = RestrictObjectType(JsonField.of("project"))

            val EXPERIMENT = RestrictObjectType(JsonField.of("experiment"))

            val DATASET = RestrictObjectType(JsonField.of("dataset"))

            val PROMPT = RestrictObjectType(JsonField.of("prompt"))

            val PROMPT_SESSION = RestrictObjectType(JsonField.of("prompt_session"))

            val PROJECT_SCORE = RestrictObjectType(JsonField.of("project_score"))

            val PROJECT_TAG = RestrictObjectType(JsonField.of("project_tag"))

            val GROUP = RestrictObjectType(JsonField.of("group"))

            val ROLE = RestrictObjectType(JsonField.of("role"))

            fun of(value: String) = RestrictObjectType(JsonField.of(value))
        }

        enum class Known {
            ORGANIZATION,
            PROJECT,
            EXPERIMENT,
            DATASET,
            PROMPT,
            PROMPT_SESSION,
            PROJECT_SCORE,
            PROJECT_TAG,
            GROUP,
            ROLE,
        }

        enum class Value {
            ORGANIZATION,
            PROJECT,
            EXPERIMENT,
            DATASET,
            PROMPT,
            PROMPT_SESSION,
            PROJECT_SCORE,
            PROJECT_TAG,
            GROUP,
            ROLE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                ORGANIZATION -> Value.ORGANIZATION
                PROJECT -> Value.PROJECT
                EXPERIMENT -> Value.EXPERIMENT
                DATASET -> Value.DATASET
                PROMPT -> Value.PROMPT
                PROMPT_SESSION -> Value.PROMPT_SESSION
                PROJECT_SCORE -> Value.PROJECT_SCORE
                PROJECT_TAG -> Value.PROJECT_TAG
                GROUP -> Value.GROUP
                ROLE -> Value.ROLE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                ORGANIZATION -> Known.ORGANIZATION
                PROJECT -> Known.PROJECT
                EXPERIMENT -> Known.EXPERIMENT
                DATASET -> Known.DATASET
                PROMPT -> Known.PROMPT
                PROMPT_SESSION -> Known.PROMPT_SESSION
                PROJECT_SCORE -> Known.PROJECT_SCORE
                PROJECT_TAG -> Known.PROJECT_TAG
                GROUP -> Known.GROUP
                ROLE -> Known.ROLE
                else -> throw BraintrustInvalidDataException("Unknown RestrictObjectType: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
