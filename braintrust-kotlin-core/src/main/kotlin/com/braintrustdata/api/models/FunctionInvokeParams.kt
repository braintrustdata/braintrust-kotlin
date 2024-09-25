// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.BaseDeserializer
import com.braintrustdata.api.core.BaseSerializer
import com.braintrustdata.api.core.Enum
import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.getOrThrow
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.errors.BraintrustInvalidDataException
import com.braintrustdata.api.models.*
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

class FunctionInvokeParams
constructor(
    private val functionId: String,
    private val input: JsonValue?,
    private val messages: List<Messages>?,
    private val mode: Mode?,
    private val parent: Parent?,
    private val stream: Boolean?,
    private val version: String?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun functionId(): String = functionId

    fun input(): JsonValue? = input

    fun messages(): List<Messages>? = messages

    fun mode(): Mode? = mode

    fun parent(): Parent? = parent

    fun stream(): Boolean? = stream

    fun version(): String? = version

    internal fun getBody(): FunctionInvokeBody {
        return FunctionInvokeBody(
            input,
            messages,
            mode,
            parent,
            stream,
            version,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> functionId
            else -> ""
        }
    }

    /** The request to invoke a function */
    @JsonDeserialize(builder = FunctionInvokeBody.Builder::class)
    @NoAutoDetect
    class FunctionInvokeBody
    internal constructor(
        private val input: JsonValue?,
        private val messages: List<Messages>?,
        private val mode: Mode?,
        private val parent: Parent?,
        private val stream: Boolean?,
        private val version: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        /** Argument to the function, which can be any JSON serializable value */
        @JsonProperty("input") fun input(): JsonValue? = input

        /** If the function is an LLM, additional messages to pass along to it */
        @JsonProperty("messages") fun messages(): List<Messages>? = messages

        /** The mode format of the returned value (defaults to 'auto') */
        @JsonProperty("mode") fun mode(): Mode? = mode

        /** Options for tracing the function call */
        @JsonProperty("parent") fun parent(): Parent? = parent

        /**
         * Whether to stream the response. If true, results will be returned in the Braintrust SSE
         * format.
         */
        @JsonProperty("stream") fun stream(): Boolean? = stream

        /** The version of the function */
        @JsonProperty("version") fun version(): String? = version

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FunctionInvokeBody &&
                this.input == other.input &&
                this.messages == other.messages &&
                this.mode == other.mode &&
                this.parent == other.parent &&
                this.stream == other.stream &&
                this.version == other.version &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        input,
                        messages,
                        mode,
                        parent,
                        stream,
                        version,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "FunctionInvokeBody{input=$input, messages=$messages, mode=$mode, parent=$parent, stream=$stream, version=$version, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var input: JsonValue? = null
            private var messages: List<Messages>? = null
            private var mode: Mode? = null
            private var parent: Parent? = null
            private var stream: Boolean? = null
            private var version: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(functionInvokeBody: FunctionInvokeBody) = apply {
                this.input = functionInvokeBody.input
                this.messages = functionInvokeBody.messages
                this.mode = functionInvokeBody.mode
                this.parent = functionInvokeBody.parent
                this.stream = functionInvokeBody.stream
                this.version = functionInvokeBody.version
                additionalProperties(functionInvokeBody.additionalProperties)
            }

            /** Argument to the function, which can be any JSON serializable value */
            @JsonProperty("input") fun input(input: JsonValue) = apply { this.input = input }

            /** If the function is an LLM, additional messages to pass along to it */
            @JsonProperty("messages")
            fun messages(messages: List<Messages>) = apply { this.messages = messages }

            /** The mode format of the returned value (defaults to 'auto') */
            @JsonProperty("mode") fun mode(mode: Mode) = apply { this.mode = mode }

            /** Options for tracing the function call */
            @JsonProperty("parent") fun parent(parent: Parent) = apply { this.parent = parent }

            /**
             * Whether to stream the response. If true, results will be returned in the Braintrust
             * SSE format.
             */
            @JsonProperty("stream") fun stream(stream: Boolean) = apply { this.stream = stream }

            /** The version of the function */
            @JsonProperty("version") fun version(version: String) = apply { this.version = version }

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

            fun build(): FunctionInvokeBody =
                FunctionInvokeBody(
                    input,
                    messages?.toUnmodifiable(),
                    mode,
                    parent,
                    stream,
                    version,
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

        return other is FunctionInvokeParams &&
            this.functionId == other.functionId &&
            this.input == other.input &&
            this.messages == other.messages &&
            this.mode == other.mode &&
            this.parent == other.parent &&
            this.stream == other.stream &&
            this.version == other.version &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            functionId,
            input,
            messages,
            mode,
            parent,
            stream,
            version,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "FunctionInvokeParams{functionId=$functionId, input=$input, messages=$messages, mode=$mode, parent=$parent, stream=$stream, version=$version, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var functionId: String? = null
        private var input: JsonValue? = null
        private var messages: MutableList<Messages> = mutableListOf()
        private var mode: Mode? = null
        private var parent: Parent? = null
        private var stream: Boolean? = null
        private var version: String? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(functionInvokeParams: FunctionInvokeParams) = apply {
            this.functionId = functionInvokeParams.functionId
            this.input = functionInvokeParams.input
            this.messages(functionInvokeParams.messages ?: listOf())
            this.mode = functionInvokeParams.mode
            this.parent = functionInvokeParams.parent
            this.stream = functionInvokeParams.stream
            this.version = functionInvokeParams.version
            additionalQueryParams(functionInvokeParams.additionalQueryParams)
            additionalHeaders(functionInvokeParams.additionalHeaders)
            additionalBodyProperties(functionInvokeParams.additionalBodyProperties)
        }

        /** Function id */
        fun functionId(functionId: String) = apply { this.functionId = functionId }

        /** Argument to the function, which can be any JSON serializable value */
        fun input(input: JsonValue) = apply { this.input = input }

        /** If the function is an LLM, additional messages to pass along to it */
        fun messages(messages: List<Messages>) = apply {
            this.messages.clear()
            this.messages.addAll(messages)
        }

        /** If the function is an LLM, additional messages to pass along to it */
        fun addMessage(message: Messages) = apply { this.messages.add(message) }

        /** The mode format of the returned value (defaults to 'auto') */
        fun mode(mode: Mode) = apply { this.mode = mode }

        /** Options for tracing the function call */
        fun parent(parent: Parent) = apply { this.parent = parent }

        /** Options for tracing the function call */
        fun parent(spanParentStruct: Parent.SpanParentStruct) = apply {
            this.parent = Parent.ofSpanParentStruct(spanParentStruct)
        }

        /** Options for tracing the function call */
        fun parent(string: String) = apply { this.parent = Parent.ofString(string) }

        /**
         * Whether to stream the response. If true, results will be returned in the Braintrust SSE
         * format.
         */
        fun stream(stream: Boolean) = apply { this.stream = stream }

        /** The version of the function */
        fun version(version: String) = apply { this.version = version }

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

        fun build(): FunctionInvokeParams =
            FunctionInvokeParams(
                checkNotNull(functionId) { "`functionId` is required but was not set" },
                input,
                if (messages.size == 0) null else messages.toUnmodifiable(),
                mode,
                parent,
                stream,
                version,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    class Mode
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Mode && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val AUTO = Mode(JsonField.of("auto"))

            val PARALLEL = Mode(JsonField.of("parallel"))

            fun of(value: String) = Mode(JsonField.of(value))
        }

        enum class Known {
            AUTO,
            PARALLEL,
        }

        enum class Value {
            AUTO,
            PARALLEL,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                AUTO -> Value.AUTO
                PARALLEL -> Value.PARALLEL
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                AUTO -> Known.AUTO
                PARALLEL -> Known.PARALLEL
                else -> throw BraintrustInvalidDataException("Unknown Mode: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    @JsonDeserialize(using = Parent.Deserializer::class)
    @JsonSerialize(using = Parent.Serializer::class)
    class Parent
    private constructor(
        private val spanParentStruct: SpanParentStruct? = null,
        private val string: String? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** Span parent properties */
        fun spanParentStruct(): SpanParentStruct? = spanParentStruct
        /** The parent's span identifier, created by calling `.export()` on a span */
        fun string(): String? = string

        fun isSpanParentStruct(): Boolean = spanParentStruct != null

        fun isString(): Boolean = string != null

        fun asSpanParentStruct(): SpanParentStruct = spanParentStruct.getOrThrow("spanParentStruct")

        fun asString(): String = string.getOrThrow("string")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                spanParentStruct != null -> visitor.visitSpanParentStruct(spanParentStruct)
                string != null -> visitor.visitString(string)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Parent = apply {
            if (!validated) {
                if (spanParentStruct == null && string == null) {
                    throw BraintrustInvalidDataException("Unknown Parent: $_json")
                }
                spanParentStruct?.validate()
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Parent &&
                this.spanParentStruct == other.spanParentStruct &&
                this.string == other.string
        }

        override fun hashCode(): Int {
            return Objects.hash(spanParentStruct, string)
        }

        override fun toString(): String {
            return when {
                spanParentStruct != null -> "Parent{spanParentStruct=$spanParentStruct}"
                string != null -> "Parent{string=$string}"
                _json != null -> "Parent{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Parent")
            }
        }

        companion object {

            fun ofSpanParentStruct(spanParentStruct: SpanParentStruct) =
                Parent(spanParentStruct = spanParentStruct)

            fun ofString(string: String) = Parent(string = string)
        }

        interface Visitor<out T> {

            fun visitSpanParentStruct(spanParentStruct: SpanParentStruct): T

            fun visitString(string: String): T

            fun unknown(json: JsonValue?): T {
                throw BraintrustInvalidDataException("Unknown Parent: $json")
            }
        }

        class Deserializer : BaseDeserializer<Parent>(Parent::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Parent {
                val json = JsonValue.fromJsonNode(node)
                tryDeserialize(node, jacksonTypeRef<SpanParentStruct>()) { it.validate() }
                    ?.let {
                        return Parent(spanParentStruct = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Parent(string = it, _json = json)
                }

                return Parent(_json = json)
            }
        }

        class Serializer : BaseSerializer<Parent>(Parent::class) {

            override fun serialize(
                value: Parent,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.spanParentStruct != null -> generator.writeObject(value.spanParentStruct)
                    value.string != null -> generator.writeObject(value.string)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Parent")
                }
            }
        }

        /** Span parent properties */
        @JsonDeserialize(builder = SpanParentStruct.Builder::class)
        @NoAutoDetect
        class SpanParentStruct
        private constructor(
            private val objectType: JsonField<ObjectType>,
            private val objectId: JsonField<String>,
            private val rowIds: JsonField<RowIds>,
            private val propagatedEvent: JsonField<PropagatedEvent>,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            fun objectType(): ObjectType = objectType.getRequired("object_type")

            /** The id of the container object you are logging to */
            fun objectId(): String = objectId.getRequired("object_id")

            /** Identifiers for the row to to log a subspan under */
            fun rowIds(): RowIds? = rowIds.getNullable("row_ids")

            /** Include these properties in every span created under this parent */
            fun propagatedEvent(): PropagatedEvent? =
                propagatedEvent.getNullable("propagated_event")

            @JsonProperty("object_type") @ExcludeMissing fun _objectType() = objectType

            /** The id of the container object you are logging to */
            @JsonProperty("object_id") @ExcludeMissing fun _objectId() = objectId

            /** Identifiers for the row to to log a subspan under */
            @JsonProperty("row_ids") @ExcludeMissing fun _rowIds() = rowIds

            /** Include these properties in every span created under this parent */
            @JsonProperty("propagated_event")
            @ExcludeMissing
            fun _propagatedEvent() = propagatedEvent

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): SpanParentStruct = apply {
                if (!validated) {
                    objectType()
                    objectId()
                    rowIds()?.validate()
                    propagatedEvent()?.validate()
                    validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is SpanParentStruct &&
                    this.objectType == other.objectType &&
                    this.objectId == other.objectId &&
                    this.rowIds == other.rowIds &&
                    this.propagatedEvent == other.propagatedEvent &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            objectType,
                            objectId,
                            rowIds,
                            propagatedEvent,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "SpanParentStruct{objectType=$objectType, objectId=$objectId, rowIds=$rowIds, propagatedEvent=$propagatedEvent, additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var objectType: JsonField<ObjectType> = JsonMissing.of()
                private var objectId: JsonField<String> = JsonMissing.of()
                private var rowIds: JsonField<RowIds> = JsonMissing.of()
                private var propagatedEvent: JsonField<PropagatedEvent> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(spanParentStruct: SpanParentStruct) = apply {
                    this.objectType = spanParentStruct.objectType
                    this.objectId = spanParentStruct.objectId
                    this.rowIds = spanParentStruct.rowIds
                    this.propagatedEvent = spanParentStruct.propagatedEvent
                    additionalProperties(spanParentStruct.additionalProperties)
                }

                fun objectType(objectType: ObjectType) = objectType(JsonField.of(objectType))

                @JsonProperty("object_type")
                @ExcludeMissing
                fun objectType(objectType: JsonField<ObjectType>) = apply {
                    this.objectType = objectType
                }

                /** The id of the container object you are logging to */
                fun objectId(objectId: String) = objectId(JsonField.of(objectId))

                /** The id of the container object you are logging to */
                @JsonProperty("object_id")
                @ExcludeMissing
                fun objectId(objectId: JsonField<String>) = apply { this.objectId = objectId }

                /** Identifiers for the row to to log a subspan under */
                fun rowIds(rowIds: RowIds) = rowIds(JsonField.of(rowIds))

                /** Identifiers for the row to to log a subspan under */
                @JsonProperty("row_ids")
                @ExcludeMissing
                fun rowIds(rowIds: JsonField<RowIds>) = apply { this.rowIds = rowIds }

                /** Include these properties in every span created under this parent */
                fun propagatedEvent(propagatedEvent: PropagatedEvent) =
                    propagatedEvent(JsonField.of(propagatedEvent))

                /** Include these properties in every span created under this parent */
                @JsonProperty("propagated_event")
                @ExcludeMissing
                fun propagatedEvent(propagatedEvent: JsonField<PropagatedEvent>) = apply {
                    this.propagatedEvent = propagatedEvent
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

                fun build(): SpanParentStruct =
                    SpanParentStruct(
                        objectType,
                        objectId,
                        rowIds,
                        propagatedEvent,
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

                    val PROJECT_LOGS = ObjectType(JsonField.of("project_logs"))

                    val EXPERIMENT = ObjectType(JsonField.of("experiment"))

                    fun of(value: String) = ObjectType(JsonField.of(value))
                }

                enum class Known {
                    PROJECT_LOGS,
                    EXPERIMENT,
                }

                enum class Value {
                    PROJECT_LOGS,
                    EXPERIMENT,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        PROJECT_LOGS -> Value.PROJECT_LOGS
                        EXPERIMENT -> Value.EXPERIMENT
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        PROJECT_LOGS -> Known.PROJECT_LOGS
                        EXPERIMENT -> Known.EXPERIMENT
                        else -> throw BraintrustInvalidDataException("Unknown ObjectType: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }

            /** Include these properties in every span created under this parent */
            @JsonDeserialize(builder = PropagatedEvent.Builder::class)
            @NoAutoDetect
            class PropagatedEvent
            private constructor(
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): PropagatedEvent = apply {
                    if (!validated) {
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is PropagatedEvent &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode = Objects.hash(additionalProperties)
                    }
                    return hashCode
                }

                override fun toString() =
                    "PropagatedEvent{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(propagatedEvent: PropagatedEvent) = apply {
                        additionalProperties(propagatedEvent.additionalProperties)
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

                    fun build(): PropagatedEvent =
                        PropagatedEvent(additionalProperties.toUnmodifiable())
                }
            }

            /** Identifiers for the row to to log a subspan under */
            @JsonDeserialize(builder = RowIds.Builder::class)
            @NoAutoDetect
            class RowIds
            private constructor(
                private val id: JsonField<String>,
                private val spanId: JsonField<String>,
                private val rootSpanId: JsonField<String>,
                private val additionalProperties: Map<String, JsonValue>,
            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                /** The id of the row */
                fun id(): String = id.getRequired("id")

                /** The span_id of the row */
                fun spanId(): String = spanId.getRequired("span_id")

                /** The root_span_id of the row */
                fun rootSpanId(): String = rootSpanId.getRequired("root_span_id")

                /** The id of the row */
                @JsonProperty("id") @ExcludeMissing fun _id() = id

                /** The span_id of the row */
                @JsonProperty("span_id") @ExcludeMissing fun _spanId() = spanId

                /** The root_span_id of the row */
                @JsonProperty("root_span_id") @ExcludeMissing fun _rootSpanId() = rootSpanId

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): RowIds = apply {
                    if (!validated) {
                        id()
                        spanId()
                        rootSpanId()
                        validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is RowIds &&
                        this.id == other.id &&
                        this.spanId == other.spanId &&
                        this.rootSpanId == other.rootSpanId &&
                        this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                    if (hashCode == 0) {
                        hashCode =
                            Objects.hash(
                                id,
                                spanId,
                                rootSpanId,
                                additionalProperties,
                            )
                    }
                    return hashCode
                }

                override fun toString() =
                    "RowIds{id=$id, spanId=$spanId, rootSpanId=$rootSpanId, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var id: JsonField<String> = JsonMissing.of()
                    private var spanId: JsonField<String> = JsonMissing.of()
                    private var rootSpanId: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(rowIds: RowIds) = apply {
                        this.id = rowIds.id
                        this.spanId = rowIds.spanId
                        this.rootSpanId = rowIds.rootSpanId
                        additionalProperties(rowIds.additionalProperties)
                    }

                    /** The id of the row */
                    fun id(id: String) = id(JsonField.of(id))

                    /** The id of the row */
                    @JsonProperty("id")
                    @ExcludeMissing
                    fun id(id: JsonField<String>) = apply { this.id = id }

                    /** The span_id of the row */
                    fun spanId(spanId: String) = spanId(JsonField.of(spanId))

                    /** The span_id of the row */
                    @JsonProperty("span_id")
                    @ExcludeMissing
                    fun spanId(spanId: JsonField<String>) = apply { this.spanId = spanId }

                    /** The root_span_id of the row */
                    fun rootSpanId(rootSpanId: String) = rootSpanId(JsonField.of(rootSpanId))

                    /** The root_span_id of the row */
                    @JsonProperty("root_span_id")
                    @ExcludeMissing
                    fun rootSpanId(rootSpanId: JsonField<String>) = apply {
                        this.rootSpanId = rootSpanId
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

                    fun build(): RowIds =
                        RowIds(
                            id,
                            spanId,
                            rootSpanId,
                            additionalProperties.toUnmodifiable(),
                        )
                }
            }
        }
    }
}
