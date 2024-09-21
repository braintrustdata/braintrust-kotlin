// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.BaseDeserializer
import com.braintrustdata.api.core.BaseSerializer
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.getOrThrow
import com.braintrustdata.api.errors.BraintrustInvalidDataException
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects

@JsonDeserialize(using = UserEmail.Deserializer::class)
@JsonSerialize(using = UserEmail.Serializer::class)
class UserEmail
private constructor(
    private val string: String? = null,
    private val strings: List<String>? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    fun string(): String? = string

    fun strings(): List<String>? = strings

    fun isString(): Boolean = string != null

    fun isStrings(): Boolean = strings != null

    fun asString(): String = string.getOrThrow("string")

    fun asStrings(): List<String> = strings.getOrThrow("strings")

    fun _json(): JsonValue? = _json

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            string != null -> visitor.visitString(string)
            strings != null -> visitor.visitStrings(strings)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): UserEmail = apply {
        if (!validated) {
            if (string == null && strings == null) {
                throw BraintrustInvalidDataException("Unknown UserEmail: $_json")
            }
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserEmail && this.string == other.string && this.strings == other.strings
    }

    override fun hashCode(): Int {
        return Objects.hash(string, strings)
    }

    override fun toString(): String {
        return when {
            string != null -> "UserEmail{string=$string}"
            strings != null -> "UserEmail{strings=$strings}"
            _json != null -> "UserEmail{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid UserEmail")
        }
    }

    companion object {

        fun ofString(string: String) = UserEmail(string = string)

        fun ofStrings(strings: List<String>) = UserEmail(strings = strings)
    }

    interface Visitor<out T> {

        fun visitString(string: String): T

        fun visitStrings(strings: List<String>): T

        fun unknown(json: JsonValue?): T {
            throw BraintrustInvalidDataException("Unknown UserEmail: $json")
        }
    }

    class Deserializer : BaseDeserializer<UserEmail>(UserEmail::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): UserEmail {
            val json = JsonValue.fromJsonNode(node)
            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                return UserEmail(string = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                return UserEmail(strings = it, _json = json)
            }

            return UserEmail(_json = json)
        }
    }

    class Serializer : BaseSerializer<UserEmail>(UserEmail::class) {

        override fun serialize(
            value: UserEmail,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.strings != null -> generator.writeObject(value.strings)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid UserEmail")
            }
        }
    }
}