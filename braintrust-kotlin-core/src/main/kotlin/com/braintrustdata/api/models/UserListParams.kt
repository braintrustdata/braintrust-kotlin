// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.BaseDeserializer
import com.braintrustdata.api.core.BaseSerializer
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.getOrThrow
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.errors.BraintrustInvalidDataException
import com.braintrustdata.api.models.*
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects

class UserListParams
constructor(
    private val email: Email?,
    private val endingBefore: String?,
    private val familyName: FamilyName?,
    private val givenName: GivenName?,
    private val ids: Ids?,
    private val limit: Long?,
    private val orgName: String?,
    private val startingAfter: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
) {

    fun email(): Email? = email

    fun endingBefore(): String? = endingBefore

    fun familyName(): FamilyName? = familyName

    fun givenName(): GivenName? = givenName

    fun ids(): Ids? = ids

    fun limit(): Long? = limit

    fun orgName(): String? = orgName

    fun startingAfter(): String? = startingAfter

    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.email?.let { params.put("email", listOf(it.toString())) }
        this.endingBefore?.let { params.put("ending_before", listOf(it.toString())) }
        this.familyName?.let { params.put("family_name", listOf(it.toString())) }
        this.givenName?.let { params.put("given_name", listOf(it.toString())) }
        this.ids?.let { params.put("ids", listOf(it.toString())) }
        this.limit?.let { params.put("limit", listOf(it.toString())) }
        this.orgName?.let { params.put("org_name", listOf(it.toString())) }
        this.startingAfter?.let { params.put("starting_after", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UserListParams &&
            this.email == other.email &&
            this.endingBefore == other.endingBefore &&
            this.familyName == other.familyName &&
            this.givenName == other.givenName &&
            this.ids == other.ids &&
            this.limit == other.limit &&
            this.orgName == other.orgName &&
            this.startingAfter == other.startingAfter &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders
    }

    override fun hashCode(): Int {
        return Objects.hash(
            email,
            endingBefore,
            familyName,
            givenName,
            ids,
            limit,
            orgName,
            startingAfter,
            additionalQueryParams,
            additionalHeaders,
        )
    }

    override fun toString() =
        "UserListParams{email=$email, endingBefore=$endingBefore, familyName=$familyName, givenName=$givenName, ids=$ids, limit=$limit, orgName=$orgName, startingAfter=$startingAfter, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var email: Email? = null
        private var endingBefore: String? = null
        private var familyName: FamilyName? = null
        private var givenName: GivenName? = null
        private var ids: Ids? = null
        private var limit: Long? = null
        private var orgName: String? = null
        private var startingAfter: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()

        internal fun from(userListParams: UserListParams) = apply {
            this.email = userListParams.email
            this.endingBefore = userListParams.endingBefore
            this.familyName = userListParams.familyName
            this.givenName = userListParams.givenName
            this.ids = userListParams.ids
            this.limit = userListParams.limit
            this.orgName = userListParams.orgName
            this.startingAfter = userListParams.startingAfter
            additionalQueryParams(userListParams.additionalQueryParams)
            additionalHeaders(userListParams.additionalHeaders)
        }

        /**
         * Email of the user to search for. You may pass the param multiple times to filter for more
         * than one email
         */
        fun email(email: Email) = apply { this.email = email }

        /**
         * Email of the user to search for. You may pass the param multiple times to filter for more
         * than one email
         */
        fun email(string: String) = apply { this.email = Email.ofString(string) }

        /**
         * Email of the user to search for. You may pass the param multiple times to filter for more
         * than one email
         */
        fun email(strings: List<String>) = apply { this.email = Email.ofStrings(strings) }

        /**
         * Pagination cursor id.
         *
         * For example, if the initial item in the last page you fetched had an id of `foo`, pass
         * `ending_before=foo` to fetch the previous page. Note: you may only pass one of
         * `starting_after` and `ending_before`
         */
        fun endingBefore(endingBefore: String) = apply { this.endingBefore = endingBefore }

        /**
         * Family name of the user to search for. You may pass the param multiple times to filter
         * for more than one family name
         */
        fun familyName(familyName: FamilyName) = apply { this.familyName = familyName }

        /**
         * Family name of the user to search for. You may pass the param multiple times to filter
         * for more than one family name
         */
        fun familyName(string: String) = apply { this.familyName = FamilyName.ofString(string) }

        /**
         * Family name of the user to search for. You may pass the param multiple times to filter
         * for more than one family name
         */
        fun familyName(strings: List<String>) = apply {
            this.familyName = FamilyName.ofStrings(strings)
        }

        /**
         * Given name of the user to search for. You may pass the param multiple times to filter for
         * more than one given name
         */
        fun givenName(givenName: GivenName) = apply { this.givenName = givenName }

        /**
         * Given name of the user to search for. You may pass the param multiple times to filter for
         * more than one given name
         */
        fun givenName(string: String) = apply { this.givenName = GivenName.ofString(string) }

        /**
         * Given name of the user to search for. You may pass the param multiple times to filter for
         * more than one given name
         */
        fun givenName(strings: List<String>) = apply {
            this.givenName = GivenName.ofStrings(strings)
        }

        /**
         * Filter search results to a particular set of object IDs. To specify a list of IDs,
         * include the query param multiple times
         */
        fun ids(ids: Ids) = apply { this.ids = ids }

        /**
         * Filter search results to a particular set of object IDs. To specify a list of IDs,
         * include the query param multiple times
         */
        fun ids(string: String) = apply { this.ids = Ids.ofString(string) }

        /**
         * Filter search results to a particular set of object IDs. To specify a list of IDs,
         * include the query param multiple times
         */
        fun ids(strings: List<String>) = apply { this.ids = Ids.ofStrings(strings) }

        /** Limit the number of objects to return */
        fun limit(limit: Long) = apply { this.limit = limit }

        /** Filter search results to within a particular organization */
        fun orgName(orgName: String) = apply { this.orgName = orgName }

        /**
         * Pagination cursor id.
         *
         * For example, if the final item in the last page you fetched had an id of `foo`, pass
         * `starting_after=foo` to fetch the next page. Note: you may only pass one of
         * `starting_after` and `ending_before`
         */
        fun startingAfter(startingAfter: String) = apply { this.startingAfter = startingAfter }

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

        fun build(): UserListParams =
            UserListParams(
                email,
                endingBefore,
                familyName,
                givenName,
                ids,
                limit,
                orgName,
                startingAfter,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            )
    }

    @JsonDeserialize(using = Email.Deserializer::class)
    @JsonSerialize(using = Email.Serializer::class)
    class Email
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

        fun validate(): Email = apply {
            if (!validated) {
                if (string == null && strings == null) {
                    throw BraintrustInvalidDataException("Unknown Email: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Email && this.string == other.string && this.strings == other.strings
        }

        override fun hashCode(): Int {
            return Objects.hash(string, strings)
        }

        override fun toString(): String {
            return when {
                string != null -> "Email{string=$string}"
                strings != null -> "Email{strings=$strings}"
                _json != null -> "Email{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Email")
            }
        }

        companion object {

            fun ofString(string: String) = Email(string = string)

            fun ofStrings(strings: List<String>) = Email(strings = strings)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun unknown(json: JsonValue?): T {
                throw BraintrustInvalidDataException("Unknown Email: $json")
            }
        }

        class Deserializer : BaseDeserializer<Email>(Email::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Email {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Email(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Email(strings = it, _json = json)
                }

                return Email(_json = json)
            }
        }

        class Serializer : BaseSerializer<Email>(Email::class) {

            override fun serialize(
                value: Email,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Email")
                }
            }
        }
    }

    @JsonDeserialize(using = FamilyName.Deserializer::class)
    @JsonSerialize(using = FamilyName.Serializer::class)
    class FamilyName
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

        fun validate(): FamilyName = apply {
            if (!validated) {
                if (string == null && strings == null) {
                    throw BraintrustInvalidDataException("Unknown FamilyName: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FamilyName &&
                this.string == other.string &&
                this.strings == other.strings
        }

        override fun hashCode(): Int {
            return Objects.hash(string, strings)
        }

        override fun toString(): String {
            return when {
                string != null -> "FamilyName{string=$string}"
                strings != null -> "FamilyName{strings=$strings}"
                _json != null -> "FamilyName{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid FamilyName")
            }
        }

        companion object {

            fun ofString(string: String) = FamilyName(string = string)

            fun ofStrings(strings: List<String>) = FamilyName(strings = strings)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun unknown(json: JsonValue?): T {
                throw BraintrustInvalidDataException("Unknown FamilyName: $json")
            }
        }

        class Deserializer : BaseDeserializer<FamilyName>(FamilyName::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): FamilyName {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return FamilyName(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return FamilyName(strings = it, _json = json)
                }

                return FamilyName(_json = json)
            }
        }

        class Serializer : BaseSerializer<FamilyName>(FamilyName::class) {

            override fun serialize(
                value: FamilyName,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid FamilyName")
                }
            }
        }
    }

    @JsonDeserialize(using = GivenName.Deserializer::class)
    @JsonSerialize(using = GivenName.Serializer::class)
    class GivenName
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

        fun validate(): GivenName = apply {
            if (!validated) {
                if (string == null && strings == null) {
                    throw BraintrustInvalidDataException("Unknown GivenName: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is GivenName &&
                this.string == other.string &&
                this.strings == other.strings
        }

        override fun hashCode(): Int {
            return Objects.hash(string, strings)
        }

        override fun toString(): String {
            return when {
                string != null -> "GivenName{string=$string}"
                strings != null -> "GivenName{strings=$strings}"
                _json != null -> "GivenName{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid GivenName")
            }
        }

        companion object {

            fun ofString(string: String) = GivenName(string = string)

            fun ofStrings(strings: List<String>) = GivenName(strings = strings)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun unknown(json: JsonValue?): T {
                throw BraintrustInvalidDataException("Unknown GivenName: $json")
            }
        }

        class Deserializer : BaseDeserializer<GivenName>(GivenName::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): GivenName {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return GivenName(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return GivenName(strings = it, _json = json)
                }

                return GivenName(_json = json)
            }
        }

        class Serializer : BaseSerializer<GivenName>(GivenName::class) {

            override fun serialize(
                value: GivenName,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid GivenName")
                }
            }
        }
    }

    @JsonDeserialize(using = Ids.Deserializer::class)
    @JsonSerialize(using = Ids.Serializer::class)
    class Ids
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

        fun validate(): Ids = apply {
            if (!validated) {
                if (string == null && strings == null) {
                    throw BraintrustInvalidDataException("Unknown Ids: $_json")
                }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Ids && this.string == other.string && this.strings == other.strings
        }

        override fun hashCode(): Int {
            return Objects.hash(string, strings)
        }

        override fun toString(): String {
            return when {
                string != null -> "Ids{string=$string}"
                strings != null -> "Ids{strings=$strings}"
                _json != null -> "Ids{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Ids")
            }
        }

        companion object {

            fun ofString(string: String) = Ids(string = string)

            fun ofStrings(strings: List<String>) = Ids(strings = strings)
        }

        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitStrings(strings: List<String>): T

            fun unknown(json: JsonValue?): T {
                throw BraintrustInvalidDataException("Unknown Ids: $json")
            }
        }

        class Deserializer : BaseDeserializer<Ids>(Ids::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Ids {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Ids(string = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                    return Ids(strings = it, _json = json)
                }

                return Ids(_json = json)
            }
        }

        class Serializer : BaseSerializer<Ids>(Ids::class) {

            override fun serialize(
                value: Ids,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Ids")
                }
            }
        }
    }
}
