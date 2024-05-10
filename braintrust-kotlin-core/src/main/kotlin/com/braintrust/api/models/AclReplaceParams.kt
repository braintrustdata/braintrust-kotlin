// File generated from our OpenAPI spec by Stainless.

package com.braintrust.api.models

import com.braintrust.api.core.BaseDeserializer
import com.braintrust.api.core.BaseSerializer
import com.braintrust.api.core.Enum
import com.braintrust.api.core.ExcludeMissing
import com.braintrust.api.core.JsonField
import com.braintrust.api.core.JsonValue
import com.braintrust.api.core.NoAutoDetect
import com.braintrust.api.core.getOrThrow
import com.braintrust.api.core.toUnmodifiable
import com.braintrust.api.errors.BraintrustInvalidDataException
import com.braintrust.api.models.*
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects

class AclReplaceParams
constructor(
    private val createUserPermissionAcl: CreateUserPermissionAcl?,
    private val createUserRoleAcl: CreateUserRoleAcl?,
    private val createGroupPermissionAcl: CreateGroupPermissionAcl?,
    private val createGroupRoleAcl: CreateGroupRoleAcl?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun createUserPermissionAcl(): CreateUserPermissionAcl? = createUserPermissionAcl

    fun createUserRoleAcl(): CreateUserRoleAcl? = createUserRoleAcl

    fun createGroupPermissionAcl(): CreateGroupPermissionAcl? = createGroupPermissionAcl

    fun createGroupRoleAcl(): CreateGroupRoleAcl? = createGroupRoleAcl

    internal fun getBody(): AclReplaceBody {
        return AclReplaceBody(
            createUserPermissionAcl,
            createUserRoleAcl,
            createGroupPermissionAcl,
            createGroupRoleAcl,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    @JsonDeserialize(using = AclReplaceBody.Deserializer::class)
    @JsonSerialize(using = AclReplaceBody.Serializer::class)
    class AclReplaceBody
    internal constructor(
        private val createUserPermissionAcl: CreateUserPermissionAcl? = null,
        private val createUserRoleAcl: CreateUserRoleAcl? = null,
        private val createGroupPermissionAcl: CreateGroupPermissionAcl? = null,
        private val createGroupRoleAcl: CreateGroupRoleAcl? = null,
        private val _json: JsonValue? = null,
    ) {

        fun createUserPermissionAcl(): CreateUserPermissionAcl? = createUserPermissionAcl

        fun createUserRoleAcl(): CreateUserRoleAcl? = createUserRoleAcl

        fun createGroupPermissionAcl(): CreateGroupPermissionAcl? = createGroupPermissionAcl

        fun createGroupRoleAcl(): CreateGroupRoleAcl? = createGroupRoleAcl

        fun isCreateUserPermissionAcl(): Boolean = createUserPermissionAcl != null

        fun isCreateUserRoleAcl(): Boolean = createUserRoleAcl != null

        fun isCreateGroupPermissionAcl(): Boolean = createGroupPermissionAcl != null

        fun isCreateGroupRoleAcl(): Boolean = createGroupRoleAcl != null

        fun asCreateUserPermissionAcl(): CreateUserPermissionAcl =
            createUserPermissionAcl.getOrThrow("createUserPermissionAcl")

        fun asCreateUserRoleAcl(): CreateUserRoleAcl =
            createUserRoleAcl.getOrThrow("createUserRoleAcl")

        fun asCreateGroupPermissionAcl(): CreateGroupPermissionAcl =
            createGroupPermissionAcl.getOrThrow("createGroupPermissionAcl")

        fun asCreateGroupRoleAcl(): CreateGroupRoleAcl =
            createGroupRoleAcl.getOrThrow("createGroupRoleAcl")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                createUserPermissionAcl != null ->
                    visitor.visitCreateUserPermissionAcl(createUserPermissionAcl)
                createUserRoleAcl != null -> visitor.visitCreateUserRoleAcl(createUserRoleAcl)
                createGroupPermissionAcl != null ->
                    visitor.visitCreateGroupPermissionAcl(createGroupPermissionAcl)
                createGroupRoleAcl != null -> visitor.visitCreateGroupRoleAcl(createGroupRoleAcl)
                else -> visitor.unknown(_json)
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AclReplaceBody &&
                this.createUserPermissionAcl == other.createUserPermissionAcl &&
                this.createUserRoleAcl == other.createUserRoleAcl &&
                this.createGroupPermissionAcl == other.createGroupPermissionAcl &&
                this.createGroupRoleAcl == other.createGroupRoleAcl
        }

        override fun hashCode(): Int {
            return Objects.hash(
                createUserPermissionAcl,
                createUserRoleAcl,
                createGroupPermissionAcl,
                createGroupRoleAcl,
            )
        }

        override fun toString(): String {
            return when {
                createUserPermissionAcl != null ->
                    "AclReplaceBody{createUserPermissionAcl=$createUserPermissionAcl}"
                createUserRoleAcl != null -> "AclReplaceBody{createUserRoleAcl=$createUserRoleAcl}"
                createGroupPermissionAcl != null ->
                    "AclReplaceBody{createGroupPermissionAcl=$createGroupPermissionAcl}"
                createGroupRoleAcl != null ->
                    "AclReplaceBody{createGroupRoleAcl=$createGroupRoleAcl}"
                _json != null -> "AclReplaceBody{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid AclReplaceBody")
            }
        }

        companion object {

            fun ofCreateUserPermissionAcl(createUserPermissionAcl: CreateUserPermissionAcl) =
                AclReplaceBody(createUserPermissionAcl = createUserPermissionAcl)

            fun ofCreateUserRoleAcl(createUserRoleAcl: CreateUserRoleAcl) =
                AclReplaceBody(createUserRoleAcl = createUserRoleAcl)

            fun ofCreateGroupPermissionAcl(createGroupPermissionAcl: CreateGroupPermissionAcl) =
                AclReplaceBody(createGroupPermissionAcl = createGroupPermissionAcl)

            fun ofCreateGroupRoleAcl(createGroupRoleAcl: CreateGroupRoleAcl) =
                AclReplaceBody(createGroupRoleAcl = createGroupRoleAcl)
        }

        interface Visitor<out T> {

            fun visitCreateUserPermissionAcl(createUserPermissionAcl: CreateUserPermissionAcl): T

            fun visitCreateUserRoleAcl(createUserRoleAcl: CreateUserRoleAcl): T

            fun visitCreateGroupPermissionAcl(createGroupPermissionAcl: CreateGroupPermissionAcl): T

            fun visitCreateGroupRoleAcl(createGroupRoleAcl: CreateGroupRoleAcl): T

            fun unknown(json: JsonValue?): T {
                throw BraintrustInvalidDataException("Unknown AclReplaceBody: $json")
            }
        }

        class Deserializer : BaseDeserializer<AclReplaceBody>(AclReplaceBody::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): AclReplaceBody {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<CreateUserPermissionAcl>())?.let {
                    return AclReplaceBody(createUserPermissionAcl = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<CreateUserRoleAcl>())?.let {
                    return AclReplaceBody(createUserRoleAcl = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<CreateGroupPermissionAcl>())?.let {
                    return AclReplaceBody(createGroupPermissionAcl = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<CreateGroupRoleAcl>())?.let {
                    return AclReplaceBody(createGroupRoleAcl = it, _json = json)
                }

                return AclReplaceBody(_json = json)
            }
        }

        class Serializer : BaseSerializer<AclReplaceBody>(AclReplaceBody::class) {

            override fun serialize(
                value: AclReplaceBody,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.createUserPermissionAcl != null ->
                        generator.writeObject(value.createUserPermissionAcl)
                    value.createUserRoleAcl != null ->
                        generator.writeObject(value.createUserRoleAcl)
                    value.createGroupPermissionAcl != null ->
                        generator.writeObject(value.createGroupPermissionAcl)
                    value.createGroupRoleAcl != null ->
                        generator.writeObject(value.createGroupRoleAcl)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid AclReplaceBody")
                }
            }
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AclReplaceParams &&
            this.createUserPermissionAcl == other.createUserPermissionAcl &&
            this.createUserRoleAcl == other.createUserRoleAcl &&
            this.createGroupPermissionAcl == other.createGroupPermissionAcl &&
            this.createGroupRoleAcl == other.createGroupRoleAcl &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            createUserPermissionAcl,
            createUserRoleAcl,
            createGroupPermissionAcl,
            createGroupRoleAcl,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "AclReplaceParams{createUserPermissionAcl=$createUserPermissionAcl, createUserRoleAcl=$createUserRoleAcl, createGroupPermissionAcl=$createGroupPermissionAcl, createGroupRoleAcl=$createGroupRoleAcl, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var createUserPermissionAcl: CreateUserPermissionAcl? = null
        private var createUserRoleAcl: CreateUserRoleAcl? = null
        private var createGroupPermissionAcl: CreateGroupPermissionAcl? = null
        private var createGroupRoleAcl: CreateGroupRoleAcl? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        internal fun from(aclReplaceParams: AclReplaceParams) = apply {
            this.createUserPermissionAcl = aclReplaceParams.createUserPermissionAcl
            this.createUserRoleAcl = aclReplaceParams.createUserRoleAcl
            this.createGroupPermissionAcl = aclReplaceParams.createGroupPermissionAcl
            this.createGroupRoleAcl = aclReplaceParams.createGroupRoleAcl
            additionalQueryParams(aclReplaceParams.additionalQueryParams)
            additionalHeaders(aclReplaceParams.additionalHeaders)
        }

        fun forCreateUserPermissionAcl(createUserPermissionAcl: CreateUserPermissionAcl) = apply {
            this.createUserPermissionAcl = createUserPermissionAcl
            this.createUserRoleAcl = null
            this.createGroupPermissionAcl = null
            this.createGroupRoleAcl = null
        }

        fun forCreateUserRoleAcl(createUserRoleAcl: CreateUserRoleAcl) = apply {
            this.createUserPermissionAcl = null
            this.createUserRoleAcl = createUserRoleAcl
            this.createGroupPermissionAcl = null
            this.createGroupRoleAcl = null
        }

        fun forCreateGroupPermissionAcl(createGroupPermissionAcl: CreateGroupPermissionAcl) =
            apply {
                this.createUserPermissionAcl = null
                this.createUserRoleAcl = null
                this.createGroupPermissionAcl = createGroupPermissionAcl
                this.createGroupRoleAcl = null
            }

        fun forCreateGroupRoleAcl(createGroupRoleAcl: CreateGroupRoleAcl) = apply {
            this.createUserPermissionAcl = null
            this.createUserRoleAcl = null
            this.createGroupPermissionAcl = null
            this.createGroupRoleAcl = createGroupRoleAcl
        }

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

        fun build(): AclReplaceParams =
            AclReplaceParams(
                createUserPermissionAcl,
                createUserRoleAcl,
                createGroupPermissionAcl,
                createGroupRoleAcl,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = CreateUserPermissionAcl.Builder::class)
    @NoAutoDetect
    class CreateUserPermissionAcl
    private constructor(
        private val objectType: ObjectType?,
        private val objectId: String?,
        private val restrictObjectType: RestrictObjectType?,
        private val userId: String?,
        private val permission: Permission?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The object type that the ACL applies to */
        @JsonProperty("object_type") fun objectType(): ObjectType? = objectType

        /** The id of the object the ACL applies to */
        @JsonProperty("object_id") fun objectId(): String? = objectId

        /** Optionally restricts the permission grant to just the specified object type */
        @JsonProperty("restrict_object_type")
        fun restrictObjectType(): RestrictObjectType? = restrictObjectType

        /** Id of the user the ACL applies to */
        @JsonProperty("user_id") fun userId(): String? = userId

        /** Permission the ACL grants */
        @JsonProperty("permission") fun permission(): Permission? = permission

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CreateUserPermissionAcl &&
                this.objectType == other.objectType &&
                this.objectId == other.objectId &&
                this.restrictObjectType == other.restrictObjectType &&
                this.userId == other.userId &&
                this.permission == other.permission &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        objectType,
                        objectId,
                        restrictObjectType,
                        userId,
                        permission,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CreateUserPermissionAcl{objectType=$objectType, objectId=$objectId, restrictObjectType=$restrictObjectType, userId=$userId, permission=$permission, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objectType: ObjectType? = null
            private var objectId: String? = null
            private var restrictObjectType: RestrictObjectType? = null
            private var userId: String? = null
            private var permission: Permission? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(createUserPermissionAcl: CreateUserPermissionAcl) = apply {
                this.objectType = createUserPermissionAcl.objectType
                this.objectId = createUserPermissionAcl.objectId
                this.restrictObjectType = createUserPermissionAcl.restrictObjectType
                this.userId = createUserPermissionAcl.userId
                this.permission = createUserPermissionAcl.permission
                additionalProperties(createUserPermissionAcl.additionalProperties)
            }

            /** The object type that the ACL applies to */
            @JsonProperty("object_type")
            fun objectType(objectType: ObjectType) = apply { this.objectType = objectType }

            /** The id of the object the ACL applies to */
            @JsonProperty("object_id")
            fun objectId(objectId: String) = apply { this.objectId = objectId }

            /** Optionally restricts the permission grant to just the specified object type */
            @JsonProperty("restrict_object_type")
            fun restrictObjectType(restrictObjectType: RestrictObjectType) = apply {
                this.restrictObjectType = restrictObjectType
            }

            /** Id of the user the ACL applies to */
            @JsonProperty("user_id") fun userId(userId: String) = apply { this.userId = userId }

            /** Permission the ACL grants */
            @JsonProperty("permission")
            fun permission(permission: Permission) = apply { this.permission = permission }

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

            fun build(): CreateUserPermissionAcl =
                CreateUserPermissionAcl(
                    checkNotNull(objectType) { "`objectType` is required but was not set" },
                    checkNotNull(objectId) { "`objectId` is required but was not set" },
                    restrictObjectType,
                    checkNotNull(userId) { "`userId` is required but was not set" },
                    checkNotNull(permission) { "`permission` is required but was not set" },
                    additionalProperties.toUnmodifiable(),
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

        @JsonDeserialize(using = RestrictObjectType.Deserializer::class)
        @JsonSerialize(using = RestrictObjectType.Serializer::class)
        class RestrictObjectType
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val unionMember1: UnionMember1? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            /** The object type that the ACL applies to */
            fun unionMember0(): UnionMember0? = unionMember0

            fun unionMember1(): UnionMember1? = unionMember1

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isUnionMember1(): Boolean = unionMember1 != null

            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

            fun _json(): JsonValue? = _json

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): RestrictObjectType = apply {
                if (!validated) {
                    if (unionMember0 == null && unionMember1 == null) {
                        throw BraintrustInvalidDataException("Unknown RestrictObjectType: $_json")
                    }
                    unionMember1?.validate()
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RestrictObjectType &&
                    this.unionMember0 == other.unionMember0 &&
                    this.unionMember1 == other.unionMember1
            }

            override fun hashCode(): Int {
                return Objects.hash(unionMember0, unionMember1)
            }

            override fun toString(): String {
                return when {
                    unionMember0 != null -> "RestrictObjectType{unionMember0=$unionMember0}"
                    unionMember1 != null -> "RestrictObjectType{unionMember1=$unionMember1}"
                    _json != null -> "RestrictObjectType{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid RestrictObjectType")
                }
            }

            companion object {

                fun ofUnionMember0(unionMember0: UnionMember0) =
                    RestrictObjectType(unionMember0 = unionMember0)

                fun ofUnionMember1(unionMember1: UnionMember1) =
                    RestrictObjectType(unionMember1 = unionMember1)
            }

            interface Visitor<out T> {

                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitUnionMember1(unionMember1: UnionMember1): T

                fun unknown(json: JsonValue?): T {
                    throw BraintrustInvalidDataException("Unknown RestrictObjectType: $json")
                }
            }

            class Deserializer : BaseDeserializer<RestrictObjectType>(RestrictObjectType::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): RestrictObjectType {
                    val json = JsonValue.fromJsonNode(node)
                    tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                        return RestrictObjectType(unionMember0 = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                        ?.let {
                            return RestrictObjectType(unionMember1 = it, _json = json)
                        }

                    return RestrictObjectType(_json = json)
                }
            }

            class Serializer : BaseSerializer<RestrictObjectType>(RestrictObjectType::class) {

                override fun serialize(
                    value: RestrictObjectType,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid RestrictObjectType")
                    }
                }
            }

            class UnionMember0
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    val ORGANIZATION = UnionMember0(JsonField.of("organization"))

                    val PROJECT = UnionMember0(JsonField.of("project"))

                    val EXPERIMENT = UnionMember0(JsonField.of("experiment"))

                    val DATASET = UnionMember0(JsonField.of("dataset"))

                    val PROMPT = UnionMember0(JsonField.of("prompt"))

                    val PROMPT_SESSION = UnionMember0(JsonField.of("prompt_session"))

                    val PROJECT_SCORE = UnionMember0(JsonField.of("project_score"))

                    val PROJECT_TAG = UnionMember0(JsonField.of("project_tag"))

                    val GROUP = UnionMember0(JsonField.of("group"))

                    val ROLE = UnionMember0(JsonField.of("role"))

                    fun of(value: String) = UnionMember0(JsonField.of(value))
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
                        else -> throw BraintrustInvalidDataException("Unknown UnionMember0: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }

            @JsonDeserialize(builder = UnionMember1.Builder::class)
            @NoAutoDetect
            class UnionMember1
            private constructor(
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): UnionMember1 = apply {
                    if (!validated) {
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember1 &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode = Objects.hash(additionalProperties)
                    }
                    return hashCode
                }

                override fun toString() = "UnionMember1{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(unionMember1: UnionMember1) = apply {
                        additionalProperties(unionMember1.additionalProperties)
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        this.additionalProperties.putAll(additionalProperties)
                    }

                    @JsonAnySetter
                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        this.additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun build(): UnionMember1 = UnionMember1(additionalProperties.toUnmodifiable())
                }
            }
        }
    }

    @JsonDeserialize(builder = CreateUserRoleAcl.Builder::class)
    @NoAutoDetect
    class CreateUserRoleAcl
    private constructor(
        private val objectType: ObjectType?,
        private val objectId: String?,
        private val restrictObjectType: RestrictObjectType?,
        private val userId: String?,
        private val roleId: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The object type that the ACL applies to */
        @JsonProperty("object_type") fun objectType(): ObjectType? = objectType

        /** The id of the object the ACL applies to */
        @JsonProperty("object_id") fun objectId(): String? = objectId

        /** Optionally restricts the permission grant to just the specified object type */
        @JsonProperty("restrict_object_type")
        fun restrictObjectType(): RestrictObjectType? = restrictObjectType

        /** Id of the user the ACL applies to */
        @JsonProperty("user_id") fun userId(): String? = userId

        /** Id of the role the ACL grants */
        @JsonProperty("role_id") fun roleId(): String? = roleId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CreateUserRoleAcl &&
                this.objectType == other.objectType &&
                this.objectId == other.objectId &&
                this.restrictObjectType == other.restrictObjectType &&
                this.userId == other.userId &&
                this.roleId == other.roleId &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        objectType,
                        objectId,
                        restrictObjectType,
                        userId,
                        roleId,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CreateUserRoleAcl{objectType=$objectType, objectId=$objectId, restrictObjectType=$restrictObjectType, userId=$userId, roleId=$roleId, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objectType: ObjectType? = null
            private var objectId: String? = null
            private var restrictObjectType: RestrictObjectType? = null
            private var userId: String? = null
            private var roleId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(createUserRoleAcl: CreateUserRoleAcl) = apply {
                this.objectType = createUserRoleAcl.objectType
                this.objectId = createUserRoleAcl.objectId
                this.restrictObjectType = createUserRoleAcl.restrictObjectType
                this.userId = createUserRoleAcl.userId
                this.roleId = createUserRoleAcl.roleId
                additionalProperties(createUserRoleAcl.additionalProperties)
            }

            /** The object type that the ACL applies to */
            @JsonProperty("object_type")
            fun objectType(objectType: ObjectType) = apply { this.objectType = objectType }

            /** The id of the object the ACL applies to */
            @JsonProperty("object_id")
            fun objectId(objectId: String) = apply { this.objectId = objectId }

            /** Optionally restricts the permission grant to just the specified object type */
            @JsonProperty("restrict_object_type")
            fun restrictObjectType(restrictObjectType: RestrictObjectType) = apply {
                this.restrictObjectType = restrictObjectType
            }

            /** Id of the user the ACL applies to */
            @JsonProperty("user_id") fun userId(userId: String) = apply { this.userId = userId }

            /** Id of the role the ACL grants */
            @JsonProperty("role_id") fun roleId(roleId: String) = apply { this.roleId = roleId }

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

            fun build(): CreateUserRoleAcl =
                CreateUserRoleAcl(
                    checkNotNull(objectType) { "`objectType` is required but was not set" },
                    checkNotNull(objectId) { "`objectId` is required but was not set" },
                    restrictObjectType,
                    checkNotNull(userId) { "`userId` is required but was not set" },
                    checkNotNull(roleId) { "`roleId` is required but was not set" },
                    additionalProperties.toUnmodifiable(),
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

        @JsonDeserialize(using = RestrictObjectType.Deserializer::class)
        @JsonSerialize(using = RestrictObjectType.Serializer::class)
        class RestrictObjectType
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val unionMember1: UnionMember1? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            /** The object type that the ACL applies to */
            fun unionMember0(): UnionMember0? = unionMember0

            fun unionMember1(): UnionMember1? = unionMember1

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isUnionMember1(): Boolean = unionMember1 != null

            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

            fun _json(): JsonValue? = _json

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): RestrictObjectType = apply {
                if (!validated) {
                    if (unionMember0 == null && unionMember1 == null) {
                        throw BraintrustInvalidDataException("Unknown RestrictObjectType: $_json")
                    }
                    unionMember1?.validate()
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RestrictObjectType &&
                    this.unionMember0 == other.unionMember0 &&
                    this.unionMember1 == other.unionMember1
            }

            override fun hashCode(): Int {
                return Objects.hash(unionMember0, unionMember1)
            }

            override fun toString(): String {
                return when {
                    unionMember0 != null -> "RestrictObjectType{unionMember0=$unionMember0}"
                    unionMember1 != null -> "RestrictObjectType{unionMember1=$unionMember1}"
                    _json != null -> "RestrictObjectType{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid RestrictObjectType")
                }
            }

            companion object {

                fun ofUnionMember0(unionMember0: UnionMember0) =
                    RestrictObjectType(unionMember0 = unionMember0)

                fun ofUnionMember1(unionMember1: UnionMember1) =
                    RestrictObjectType(unionMember1 = unionMember1)
            }

            interface Visitor<out T> {

                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitUnionMember1(unionMember1: UnionMember1): T

                fun unknown(json: JsonValue?): T {
                    throw BraintrustInvalidDataException("Unknown RestrictObjectType: $json")
                }
            }

            class Deserializer : BaseDeserializer<RestrictObjectType>(RestrictObjectType::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): RestrictObjectType {
                    val json = JsonValue.fromJsonNode(node)
                    tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                        return RestrictObjectType(unionMember0 = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                        ?.let {
                            return RestrictObjectType(unionMember1 = it, _json = json)
                        }

                    return RestrictObjectType(_json = json)
                }
            }

            class Serializer : BaseSerializer<RestrictObjectType>(RestrictObjectType::class) {

                override fun serialize(
                    value: RestrictObjectType,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid RestrictObjectType")
                    }
                }
            }

            class UnionMember0
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    val ORGANIZATION = UnionMember0(JsonField.of("organization"))

                    val PROJECT = UnionMember0(JsonField.of("project"))

                    val EXPERIMENT = UnionMember0(JsonField.of("experiment"))

                    val DATASET = UnionMember0(JsonField.of("dataset"))

                    val PROMPT = UnionMember0(JsonField.of("prompt"))

                    val PROMPT_SESSION = UnionMember0(JsonField.of("prompt_session"))

                    val PROJECT_SCORE = UnionMember0(JsonField.of("project_score"))

                    val PROJECT_TAG = UnionMember0(JsonField.of("project_tag"))

                    val GROUP = UnionMember0(JsonField.of("group"))

                    val ROLE = UnionMember0(JsonField.of("role"))

                    fun of(value: String) = UnionMember0(JsonField.of(value))
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
                        else -> throw BraintrustInvalidDataException("Unknown UnionMember0: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }

            @JsonDeserialize(builder = UnionMember1.Builder::class)
            @NoAutoDetect
            class UnionMember1
            private constructor(
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): UnionMember1 = apply {
                    if (!validated) {
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember1 &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode = Objects.hash(additionalProperties)
                    }
                    return hashCode
                }

                override fun toString() = "UnionMember1{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(unionMember1: UnionMember1) = apply {
                        additionalProperties(unionMember1.additionalProperties)
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        this.additionalProperties.putAll(additionalProperties)
                    }

                    @JsonAnySetter
                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        this.additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun build(): UnionMember1 = UnionMember1(additionalProperties.toUnmodifiable())
                }
            }
        }
    }

    @JsonDeserialize(builder = CreateGroupPermissionAcl.Builder::class)
    @NoAutoDetect
    class CreateGroupPermissionAcl
    private constructor(
        private val objectType: ObjectType?,
        private val objectId: String?,
        private val restrictObjectType: RestrictObjectType?,
        private val groupId: String?,
        private val permission: Permission?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The object type that the ACL applies to */
        @JsonProperty("object_type") fun objectType(): ObjectType? = objectType

        /** The id of the object the ACL applies to */
        @JsonProperty("object_id") fun objectId(): String? = objectId

        /** Optionally restricts the permission grant to just the specified object type */
        @JsonProperty("restrict_object_type")
        fun restrictObjectType(): RestrictObjectType? = restrictObjectType

        /** Id of the group the ACL applies to */
        @JsonProperty("group_id") fun groupId(): String? = groupId

        /** Permission the ACL grants */
        @JsonProperty("permission") fun permission(): Permission? = permission

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CreateGroupPermissionAcl &&
                this.objectType == other.objectType &&
                this.objectId == other.objectId &&
                this.restrictObjectType == other.restrictObjectType &&
                this.groupId == other.groupId &&
                this.permission == other.permission &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        objectType,
                        objectId,
                        restrictObjectType,
                        groupId,
                        permission,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CreateGroupPermissionAcl{objectType=$objectType, objectId=$objectId, restrictObjectType=$restrictObjectType, groupId=$groupId, permission=$permission, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objectType: ObjectType? = null
            private var objectId: String? = null
            private var restrictObjectType: RestrictObjectType? = null
            private var groupId: String? = null
            private var permission: Permission? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(createGroupPermissionAcl: CreateGroupPermissionAcl) = apply {
                this.objectType = createGroupPermissionAcl.objectType
                this.objectId = createGroupPermissionAcl.objectId
                this.restrictObjectType = createGroupPermissionAcl.restrictObjectType
                this.groupId = createGroupPermissionAcl.groupId
                this.permission = createGroupPermissionAcl.permission
                additionalProperties(createGroupPermissionAcl.additionalProperties)
            }

            /** The object type that the ACL applies to */
            @JsonProperty("object_type")
            fun objectType(objectType: ObjectType) = apply { this.objectType = objectType }

            /** The id of the object the ACL applies to */
            @JsonProperty("object_id")
            fun objectId(objectId: String) = apply { this.objectId = objectId }

            /** Optionally restricts the permission grant to just the specified object type */
            @JsonProperty("restrict_object_type")
            fun restrictObjectType(restrictObjectType: RestrictObjectType) = apply {
                this.restrictObjectType = restrictObjectType
            }

            /** Id of the group the ACL applies to */
            @JsonProperty("group_id")
            fun groupId(groupId: String) = apply { this.groupId = groupId }

            /** Permission the ACL grants */
            @JsonProperty("permission")
            fun permission(permission: Permission) = apply { this.permission = permission }

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

            fun build(): CreateGroupPermissionAcl =
                CreateGroupPermissionAcl(
                    checkNotNull(objectType) { "`objectType` is required but was not set" },
                    checkNotNull(objectId) { "`objectId` is required but was not set" },
                    restrictObjectType,
                    checkNotNull(groupId) { "`groupId` is required but was not set" },
                    checkNotNull(permission) { "`permission` is required but was not set" },
                    additionalProperties.toUnmodifiable(),
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

        @JsonDeserialize(using = RestrictObjectType.Deserializer::class)
        @JsonSerialize(using = RestrictObjectType.Serializer::class)
        class RestrictObjectType
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val unionMember1: UnionMember1? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            /** The object type that the ACL applies to */
            fun unionMember0(): UnionMember0? = unionMember0

            fun unionMember1(): UnionMember1? = unionMember1

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isUnionMember1(): Boolean = unionMember1 != null

            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

            fun _json(): JsonValue? = _json

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): RestrictObjectType = apply {
                if (!validated) {
                    if (unionMember0 == null && unionMember1 == null) {
                        throw BraintrustInvalidDataException("Unknown RestrictObjectType: $_json")
                    }
                    unionMember1?.validate()
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RestrictObjectType &&
                    this.unionMember0 == other.unionMember0 &&
                    this.unionMember1 == other.unionMember1
            }

            override fun hashCode(): Int {
                return Objects.hash(unionMember0, unionMember1)
            }

            override fun toString(): String {
                return when {
                    unionMember0 != null -> "RestrictObjectType{unionMember0=$unionMember0}"
                    unionMember1 != null -> "RestrictObjectType{unionMember1=$unionMember1}"
                    _json != null -> "RestrictObjectType{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid RestrictObjectType")
                }
            }

            companion object {

                fun ofUnionMember0(unionMember0: UnionMember0) =
                    RestrictObjectType(unionMember0 = unionMember0)

                fun ofUnionMember1(unionMember1: UnionMember1) =
                    RestrictObjectType(unionMember1 = unionMember1)
            }

            interface Visitor<out T> {

                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitUnionMember1(unionMember1: UnionMember1): T

                fun unknown(json: JsonValue?): T {
                    throw BraintrustInvalidDataException("Unknown RestrictObjectType: $json")
                }
            }

            class Deserializer : BaseDeserializer<RestrictObjectType>(RestrictObjectType::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): RestrictObjectType {
                    val json = JsonValue.fromJsonNode(node)
                    tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                        return RestrictObjectType(unionMember0 = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                        ?.let {
                            return RestrictObjectType(unionMember1 = it, _json = json)
                        }

                    return RestrictObjectType(_json = json)
                }
            }

            class Serializer : BaseSerializer<RestrictObjectType>(RestrictObjectType::class) {

                override fun serialize(
                    value: RestrictObjectType,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid RestrictObjectType")
                    }
                }
            }

            class UnionMember0
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    val ORGANIZATION = UnionMember0(JsonField.of("organization"))

                    val PROJECT = UnionMember0(JsonField.of("project"))

                    val EXPERIMENT = UnionMember0(JsonField.of("experiment"))

                    val DATASET = UnionMember0(JsonField.of("dataset"))

                    val PROMPT = UnionMember0(JsonField.of("prompt"))

                    val PROMPT_SESSION = UnionMember0(JsonField.of("prompt_session"))

                    val PROJECT_SCORE = UnionMember0(JsonField.of("project_score"))

                    val PROJECT_TAG = UnionMember0(JsonField.of("project_tag"))

                    val GROUP = UnionMember0(JsonField.of("group"))

                    val ROLE = UnionMember0(JsonField.of("role"))

                    fun of(value: String) = UnionMember0(JsonField.of(value))
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
                        else -> throw BraintrustInvalidDataException("Unknown UnionMember0: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }

            @JsonDeserialize(builder = UnionMember1.Builder::class)
            @NoAutoDetect
            class UnionMember1
            private constructor(
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): UnionMember1 = apply {
                    if (!validated) {
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember1 &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode = Objects.hash(additionalProperties)
                    }
                    return hashCode
                }

                override fun toString() = "UnionMember1{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(unionMember1: UnionMember1) = apply {
                        additionalProperties(unionMember1.additionalProperties)
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        this.additionalProperties.putAll(additionalProperties)
                    }

                    @JsonAnySetter
                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        this.additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun build(): UnionMember1 = UnionMember1(additionalProperties.toUnmodifiable())
                }
            }
        }
    }

    @JsonDeserialize(builder = CreateGroupRoleAcl.Builder::class)
    @NoAutoDetect
    class CreateGroupRoleAcl
    private constructor(
        private val objectType: ObjectType?,
        private val objectId: String?,
        private val restrictObjectType: RestrictObjectType?,
        private val groupId: String?,
        private val roleId: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** The object type that the ACL applies to */
        @JsonProperty("object_type") fun objectType(): ObjectType? = objectType

        /** The id of the object the ACL applies to */
        @JsonProperty("object_id") fun objectId(): String? = objectId

        /** Optionally restricts the permission grant to just the specified object type */
        @JsonProperty("restrict_object_type")
        fun restrictObjectType(): RestrictObjectType? = restrictObjectType

        /** Id of the group the ACL applies to */
        @JsonProperty("group_id") fun groupId(): String? = groupId

        /** Id of the role the ACL grants */
        @JsonProperty("role_id") fun roleId(): String? = roleId

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CreateGroupRoleAcl &&
                this.objectType == other.objectType &&
                this.objectId == other.objectId &&
                this.restrictObjectType == other.restrictObjectType &&
                this.groupId == other.groupId &&
                this.roleId == other.roleId &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        objectType,
                        objectId,
                        restrictObjectType,
                        groupId,
                        roleId,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CreateGroupRoleAcl{objectType=$objectType, objectId=$objectId, restrictObjectType=$restrictObjectType, groupId=$groupId, roleId=$roleId, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var objectType: ObjectType? = null
            private var objectId: String? = null
            private var restrictObjectType: RestrictObjectType? = null
            private var groupId: String? = null
            private var roleId: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(createGroupRoleAcl: CreateGroupRoleAcl) = apply {
                this.objectType = createGroupRoleAcl.objectType
                this.objectId = createGroupRoleAcl.objectId
                this.restrictObjectType = createGroupRoleAcl.restrictObjectType
                this.groupId = createGroupRoleAcl.groupId
                this.roleId = createGroupRoleAcl.roleId
                additionalProperties(createGroupRoleAcl.additionalProperties)
            }

            /** The object type that the ACL applies to */
            @JsonProperty("object_type")
            fun objectType(objectType: ObjectType) = apply { this.objectType = objectType }

            /** The id of the object the ACL applies to */
            @JsonProperty("object_id")
            fun objectId(objectId: String) = apply { this.objectId = objectId }

            /** Optionally restricts the permission grant to just the specified object type */
            @JsonProperty("restrict_object_type")
            fun restrictObjectType(restrictObjectType: RestrictObjectType) = apply {
                this.restrictObjectType = restrictObjectType
            }

            /** Id of the group the ACL applies to */
            @JsonProperty("group_id")
            fun groupId(groupId: String) = apply { this.groupId = groupId }

            /** Id of the role the ACL grants */
            @JsonProperty("role_id") fun roleId(roleId: String) = apply { this.roleId = roleId }

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

            fun build(): CreateGroupRoleAcl =
                CreateGroupRoleAcl(
                    checkNotNull(objectType) { "`objectType` is required but was not set" },
                    checkNotNull(objectId) { "`objectId` is required but was not set" },
                    restrictObjectType,
                    checkNotNull(groupId) { "`groupId` is required but was not set" },
                    checkNotNull(roleId) { "`roleId` is required but was not set" },
                    additionalProperties.toUnmodifiable(),
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

        @JsonDeserialize(using = RestrictObjectType.Deserializer::class)
        @JsonSerialize(using = RestrictObjectType.Serializer::class)
        class RestrictObjectType
        private constructor(
            private val unionMember0: UnionMember0? = null,
            private val unionMember1: UnionMember1? = null,
            private val _json: JsonValue? = null,
        ) {

            private var validated: Boolean = false

            /** The object type that the ACL applies to */
            fun unionMember0(): UnionMember0? = unionMember0

            fun unionMember1(): UnionMember1? = unionMember1

            fun isUnionMember0(): Boolean = unionMember0 != null

            fun isUnionMember1(): Boolean = unionMember1 != null

            fun asUnionMember0(): UnionMember0 = unionMember0.getOrThrow("unionMember0")

            fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

            fun _json(): JsonValue? = _json

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    unionMember0 != null -> visitor.visitUnionMember0(unionMember0)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                    else -> visitor.unknown(_json)
                }
            }

            fun validate(): RestrictObjectType = apply {
                if (!validated) {
                    if (unionMember0 == null && unionMember1 == null) {
                        throw BraintrustInvalidDataException("Unknown RestrictObjectType: $_json")
                    }
                    unionMember1?.validate()
                    validated = true
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is RestrictObjectType &&
                    this.unionMember0 == other.unionMember0 &&
                    this.unionMember1 == other.unionMember1
            }

            override fun hashCode(): Int {
                return Objects.hash(unionMember0, unionMember1)
            }

            override fun toString(): String {
                return when {
                    unionMember0 != null -> "RestrictObjectType{unionMember0=$unionMember0}"
                    unionMember1 != null -> "RestrictObjectType{unionMember1=$unionMember1}"
                    _json != null -> "RestrictObjectType{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid RestrictObjectType")
                }
            }

            companion object {

                fun ofUnionMember0(unionMember0: UnionMember0) =
                    RestrictObjectType(unionMember0 = unionMember0)

                fun ofUnionMember1(unionMember1: UnionMember1) =
                    RestrictObjectType(unionMember1 = unionMember1)
            }

            interface Visitor<out T> {

                fun visitUnionMember0(unionMember0: UnionMember0): T

                fun visitUnionMember1(unionMember1: UnionMember1): T

                fun unknown(json: JsonValue?): T {
                    throw BraintrustInvalidDataException("Unknown RestrictObjectType: $json")
                }
            }

            class Deserializer : BaseDeserializer<RestrictObjectType>(RestrictObjectType::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): RestrictObjectType {
                    val json = JsonValue.fromJsonNode(node)
                    tryDeserialize(node, jacksonTypeRef<UnionMember0>())?.let {
                        return RestrictObjectType(unionMember0 = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                        ?.let {
                            return RestrictObjectType(unionMember1 = it, _json = json)
                        }

                    return RestrictObjectType(_json = json)
                }
            }

            class Serializer : BaseSerializer<RestrictObjectType>(RestrictObjectType::class) {

                override fun serialize(
                    value: RestrictObjectType,
                    generator: JsonGenerator,
                    provider: SerializerProvider
                ) {
                    when {
                        value.unionMember0 != null -> generator.writeObject(value.unionMember0)
                        value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid RestrictObjectType")
                    }
                }
            }

            class UnionMember0
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) : Enum {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember0 && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    val ORGANIZATION = UnionMember0(JsonField.of("organization"))

                    val PROJECT = UnionMember0(JsonField.of("project"))

                    val EXPERIMENT = UnionMember0(JsonField.of("experiment"))

                    val DATASET = UnionMember0(JsonField.of("dataset"))

                    val PROMPT = UnionMember0(JsonField.of("prompt"))

                    val PROMPT_SESSION = UnionMember0(JsonField.of("prompt_session"))

                    val PROJECT_SCORE = UnionMember0(JsonField.of("project_score"))

                    val PROJECT_TAG = UnionMember0(JsonField.of("project_tag"))

                    val GROUP = UnionMember0(JsonField.of("group"))

                    val ROLE = UnionMember0(JsonField.of("role"))

                    fun of(value: String) = UnionMember0(JsonField.of(value))
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
                        else -> throw BraintrustInvalidDataException("Unknown UnionMember0: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }

            @JsonDeserialize(builder = UnionMember1.Builder::class)
            @NoAutoDetect
            class UnionMember1
            private constructor(
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): UnionMember1 = apply {
                    if (!validated) {
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is UnionMember1 &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode = Objects.hash(additionalProperties)
                    }
                    return hashCode
                }

                override fun toString() = "UnionMember1{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(unionMember1: UnionMember1) = apply {
                        additionalProperties(unionMember1.additionalProperties)
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        this.additionalProperties.putAll(additionalProperties)
                    }

                    @JsonAnySetter
                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        this.additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun build(): UnionMember1 = UnionMember1(additionalProperties.toUnmodifiable())
                }
            }
        }
    }
}
