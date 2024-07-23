// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.apache.hc.core5.http.ContentType
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Objects
import java.util.Optional
import java.util.UUID
import com.braintrustdata.api.core.BaseDeserializer
import com.braintrustdata.api.core.BaseSerializer
import com.braintrustdata.api.core.getOrThrow
import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.MultipartFormValue
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.Enum
import com.braintrustdata.api.core.ContentTypes
import com.braintrustdata.api.errors.BraintrustInvalidDataException
import com.braintrustdata.api.models.*

class ProjectLogInsertParams constructor(
  private val projectId: String,
  private val events: List<Event>,
  private val additionalQueryParams: Map<String, List<String>>,
  private val additionalHeaders: Map<String, List<String>>,
  private val additionalBodyProperties: Map<String, JsonValue>,

) {

    fun projectId(): String = projectId

    fun events(): List<Event> = events

    internal fun getBody(): ProjectLogInsertBody {
      return ProjectLogInsertBody(events, additionalBodyProperties)
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> projectId
          else -> ""
      }
    }

    @JsonDeserialize(builder = ProjectLogInsertBody.Builder::class)
    @NoAutoDetect
    class ProjectLogInsertBody internal constructor(private val events: List<Event>?, private val additionalProperties: Map<String, JsonValue>, ) {

        private var hashCode: Int = 0

        /** A list of project logs events to insert */
        @JsonProperty("events")
        fun events(): List<Event>? = events

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is ProjectLogInsertBody &&
              this.events == other.events &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(events, additionalProperties)
          }
          return hashCode
        }

        override fun toString() = "ProjectLogInsertBody{events=$events, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var events: List<Event>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(projectLogInsertBody: ProjectLogInsertBody) = apply {
                this.events = projectLogInsertBody.events
                additionalProperties(projectLogInsertBody.additionalProperties)
            }

            /** A list of project logs events to insert */
            @JsonProperty("events")
            fun events(events: List<Event>) = apply {
                this.events = events
            }

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

            fun build(): ProjectLogInsertBody = ProjectLogInsertBody(checkNotNull(events) {
                "`events` is required but was not set"
            }.toUnmodifiable(), additionalProperties.toUnmodifiable())
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is ProjectLogInsertParams &&
          this.projectId == other.projectId &&
          this.events == other.events &&
          this.additionalQueryParams == other.additionalQueryParams &&
          this.additionalHeaders == other.additionalHeaders &&
          this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
      return Objects.hash(
          projectId,
          events,
          additionalQueryParams,
          additionalHeaders,
          additionalBodyProperties,
      )
    }

    override fun toString() = "ProjectLogInsertParams{projectId=$projectId, events=$events, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var projectId: String? = null
        private var events: MutableList<Event> = mutableListOf()
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(projectLogInsertParams: ProjectLogInsertParams) = apply {
            this.projectId = projectLogInsertParams.projectId
            this.events(projectLogInsertParams.events)
            additionalQueryParams(projectLogInsertParams.additionalQueryParams)
            additionalHeaders(projectLogInsertParams.additionalHeaders)
            additionalBodyProperties(projectLogInsertParams.additionalBodyProperties)
        }

        /** Project id */
        fun projectId(projectId: String) = apply {
            this.projectId = projectId
        }

        /** A list of project logs events to insert */
        fun events(events: List<Event>) = apply {
            this.events.clear()
            this.events.addAll(events)
        }

        /** A list of project logs events to insert */
        fun addEvent(event: Event) = apply {
            this.events.add(event)
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

        fun removeHeader(name: String) = apply {
            this.additionalHeaders.put(name, mutableListOf())
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun build(): ProjectLogInsertParams = ProjectLogInsertParams(
            checkNotNull(projectId) {
                "`projectId` is required but was not set"
            },
            checkNotNull(events) {
                "`events` is required but was not set"
            }.toUnmodifiable(),
            additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
            additionalBodyProperties.toUnmodifiable(),
        )
    }

    @JsonDeserialize(using = Event.Deserializer::class)
    @JsonSerialize(using = Event.Serializer::class)
    class Event private constructor(private val insertProjectLogsEventReplace: InsertProjectLogsEventReplace? = null, private val insertProjectLogsEventMerge: InsertProjectLogsEventMerge? = null, private val _json: JsonValue? = null, ) {

        private var validated: Boolean = false

        fun insertProjectLogsEventReplace(): InsertProjectLogsEventReplace? = insertProjectLogsEventReplace
        fun insertProjectLogsEventMerge(): InsertProjectLogsEventMerge? = insertProjectLogsEventMerge

        fun isInsertProjectLogsEventReplace(): Boolean = insertProjectLogsEventReplace != null
        fun isInsertProjectLogsEventMerge(): Boolean = insertProjectLogsEventMerge != null

        fun asInsertProjectLogsEventReplace(): InsertProjectLogsEventReplace = insertProjectLogsEventReplace.getOrThrow("insertProjectLogsEventReplace")
        fun asInsertProjectLogsEventMerge(): InsertProjectLogsEventMerge = insertProjectLogsEventMerge.getOrThrow("insertProjectLogsEventMerge")

        fun _json(): JsonValue? = _json

        fun <T> accept(visitor: Visitor<T>): T {
          return when {
              insertProjectLogsEventReplace != null -> visitor.visitInsertProjectLogsEventReplace(insertProjectLogsEventReplace)
              insertProjectLogsEventMerge != null -> visitor.visitInsertProjectLogsEventMerge(insertProjectLogsEventMerge)
              else -> visitor.unknown(_json)
          }
        }

        fun validate(): Event = apply {
            if (!validated) {
              if (insertProjectLogsEventReplace == null && insertProjectLogsEventMerge == null) {
                throw BraintrustInvalidDataException("Unknown Event: $_json")
              }
              insertProjectLogsEventReplace?.validate()
              insertProjectLogsEventMerge?.validate()
              validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Event &&
              this.insertProjectLogsEventReplace == other.insertProjectLogsEventReplace &&
              this.insertProjectLogsEventMerge == other.insertProjectLogsEventMerge
        }

        override fun hashCode(): Int {
          return Objects.hash(insertProjectLogsEventReplace, insertProjectLogsEventMerge)
        }

        override fun toString(): String {
          return when {
              insertProjectLogsEventReplace != null -> "Event{insertProjectLogsEventReplace=$insertProjectLogsEventReplace}"
              insertProjectLogsEventMerge != null -> "Event{insertProjectLogsEventMerge=$insertProjectLogsEventMerge}"
              _json != null -> "Event{_unknown=$_json}"
              else -> throw IllegalStateException("Invalid Event")
          }
        }

        companion object {

            fun ofInsertProjectLogsEventReplace(insertProjectLogsEventReplace: InsertProjectLogsEventReplace) = Event(insertProjectLogsEventReplace = insertProjectLogsEventReplace)

            fun ofInsertProjectLogsEventMerge(insertProjectLogsEventMerge: InsertProjectLogsEventMerge) = Event(insertProjectLogsEventMerge = insertProjectLogsEventMerge)
        }

        interface Visitor<out T> {

            fun visitInsertProjectLogsEventReplace(insertProjectLogsEventReplace: InsertProjectLogsEventReplace): T

            fun visitInsertProjectLogsEventMerge(insertProjectLogsEventMerge: InsertProjectLogsEventMerge): T

            fun unknown(json: JsonValue?): T {
              throw BraintrustInvalidDataException("Unknown Event: $json")
            }
        }

        class Deserializer : BaseDeserializer<Event>(Event::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Event {
              val json = JsonValue.fromJsonNode(node)
              tryDeserialize(node, jacksonTypeRef<InsertProjectLogsEventReplace>()){ it.validate() }?.let {
                  return Event(insertProjectLogsEventReplace = it, _json = json)
              }
              tryDeserialize(node, jacksonTypeRef<InsertProjectLogsEventMerge>()){ it.validate() }?.let {
                  return Event(insertProjectLogsEventMerge = it, _json = json)
              }

              return Event(_json = json)
            }
        }

        class Serializer : BaseSerializer<Event>(Event::class) {

            override fun serialize(value: Event, generator: JsonGenerator, provider: SerializerProvider) {
              when {
                  value.insertProjectLogsEventReplace != null -> generator.writeObject(value.insertProjectLogsEventReplace)
                  value.insertProjectLogsEventMerge != null -> generator.writeObject(value.insertProjectLogsEventMerge)
                  value._json != null -> generator.writeObject(value._json)
                  else -> throw IllegalStateException("Invalid Event")
              }
            }
        }

        @JsonDeserialize(builder = InsertProjectLogsEventReplace.Builder::class)
        @NoAutoDetect
        class InsertProjectLogsEventReplace private constructor(
          private val input: JsonValue,
          private val output: JsonValue,
          private val expected: JsonValue,
          private val scores: JsonField<Scores>,
          private val metadata: JsonField<Metadata>,
          private val tags: JsonField<List<String>>,
          private val metrics: JsonField<Metrics>,
          private val context: JsonField<Context>,
          private val spanAttributes: JsonField<SpanAttributes>,
          private val id: JsonField<String>,
          private val created: JsonField<OffsetDateTime>,
          private val _objectDelete: JsonField<Boolean>,
          private val _isMerge: JsonField<Boolean>,
          private val _parentId: JsonField<String>,
          private val additionalProperties: Map<String, JsonValue>,

        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            /**
             * The arguments that uniquely define a user input (an arbitrary, JSON serializable
             * object).
             */
            fun input(): JsonValue = input

            /**
             * The output of your application, including post-processing (an arbitrary, JSON
             * serializable object), that allows you to determine whether the result is correct
             * or not. For example, in an app that generates SQL queries, the `output` should
             * be the _result_ of the SQL query generated by the model, not the query itself,
             * because there may be multiple valid queries that answer a single question.
             */
            fun output(): JsonValue = output

            /**
             * The ground truth value (an arbitrary, JSON serializable object) that you'd
             * compare to `output` to determine if your `output` value is correct or not.
             * Braintrust currently does not compare `output` to `expected` for you, since
             * there are so many different ways to do that correctly. Instead, these values are
             * just used to help you navigate while digging into analyses. However, we may
             * later use these values to re-score outputs or fine-tune your models.
             */
            fun expected(): JsonValue = expected

            /**
             * A dictionary of numeric values (between 0 and 1) to log. The scores should give
             * you a variety of signals that help you determine how accurate the outputs are
             * compared to what you expect and diagnose failures. For example, a summarization
             * app might have one score that tells you how accurate the summary is, and another
             * that measures the word similarity between the generated and grouth truth
             * summary. The word similarity score could help you determine whether the
             * summarization was covering similar concepts or not. You can use these scores to
             * help you sort, filter, and compare logs.
             */
            fun scores(): Scores? = scores.getNullable("scores")

            /**
             * A dictionary with additional data about the test example, model outputs, or just
             * about anything else that's relevant, that you can use to help find and analyze
             * examples later. For example, you could log the `prompt`, example's `id`, or
             * anything else that would be useful to slice/dice later. The values in `metadata`
             * can be any JSON-serializable type, but its keys must be strings
             */
            fun metadata(): Metadata? = metadata.getNullable("metadata")

            /** A list of tags to log */
            fun tags(): List<String>? = tags.getNullable("tags")

            /**
             * Metrics are numerical measurements tracking the execution of the code that
             * produced the project logs event. Use "start" and "end" to track the time span
             * over which the project logs event was produced
             */
            fun metrics(): Metrics? = metrics.getNullable("metrics")

            /**
             * Context is additional information about the code that produced the project logs
             * event. It is essentially the textual counterpart to `metrics`. Use the
             * `caller_*` attributes to track the location in code which produced the project
             * logs event
             */
            fun context(): Context? = context.getNullable("context")

            /** Human-identifying attributes of the span, such as name, type, etc. */
            fun spanAttributes(): SpanAttributes? = spanAttributes.getNullable("span_attributes")

            /**
             * A unique identifier for the project logs event. If you don't provide one,
             * BrainTrust will generate one for you
             */
            fun id(): String? = id.getNullable("id")

            /** The timestamp the project logs event was created */
            fun created(): OffsetDateTime? = created.getNullable("created")

            /**
             * Pass `_object_delete=true` to mark the project logs event deleted. Deleted
             * events will not show up in subsequent fetches for this project logs
             */
            fun _objectDelete(): Boolean? = _objectDelete.getNullable("_object_delete")

            /**
             * The `_is_merge` field controls how the row is merged with any existing row with
             * the same id in the DB. By default (or when set to `false`), the existing row is
             * completely replaced by the new row. When set to `true`, the new row is
             * deep-merged into the existing row
             *
             * For example, say there is an existing row in the DB
             * `{"id": "foo", "input": {"a": 5, "b": 10}}`. If we merge a new row as
             * `{"_is_merge": true, "id": "foo", "input": {"b": 11, "c": 20}}`, the new row
             * will be `{"id": "foo", "input": {"a": 5, "b": 11, "c": 20}}`. If we replace the
             * new row as `{"id": "foo", "input": {"b": 11, "c": 20}}`, the new row will be
             * `{"id": "foo", "input": {"b": 11, "c": 20}}`
             */
            fun _isMerge(): Boolean? = _isMerge.getNullable("_is_merge")

            /**
             * Use the `_parent_id` field to create this row as a subspan of an existing row.
             * It cannot be specified alongside `_is_merge=true`. Tracking hierarchical
             * relationships are important for tracing (see the
             * [guide](https://www.braintrust.dev/docs/guides/tracing) for full details).
             *
             * For example, say we have logged a row
             * `{"id": "abc", "input": "foo", "output": "bar", "expected": "boo", "scores": {"correctness": 0.33}}`.
             * We can create a sub-span of the parent row by logging
             * `{"_parent_id": "abc", "id": "llm_call", "input": {"prompt": "What comes after foo?"}, "output": "bar", "metrics": {"tokens": 1}}`.
             * In the webapp, only the root span row `"abc"` will show up in the summary view.
             * You can view the full trace hierarchy (in this case, the `"llm_call"` row) by
             * clicking on the "abc" row.
             */
            fun _parentId(): String? = _parentId.getNullable("_parent_id")

            /**
             * The arguments that uniquely define a user input (an arbitrary, JSON serializable
             * object).
             */
            @JsonProperty("input")
            @ExcludeMissing
            fun _input() = input

            /**
             * The output of your application, including post-processing (an arbitrary, JSON
             * serializable object), that allows you to determine whether the result is correct
             * or not. For example, in an app that generates SQL queries, the `output` should
             * be the _result_ of the SQL query generated by the model, not the query itself,
             * because there may be multiple valid queries that answer a single question.
             */
            @JsonProperty("output")
            @ExcludeMissing
            fun _output() = output

            /**
             * The ground truth value (an arbitrary, JSON serializable object) that you'd
             * compare to `output` to determine if your `output` value is correct or not.
             * Braintrust currently does not compare `output` to `expected` for you, since
             * there are so many different ways to do that correctly. Instead, these values are
             * just used to help you navigate while digging into analyses. However, we may
             * later use these values to re-score outputs or fine-tune your models.
             */
            @JsonProperty("expected")
            @ExcludeMissing
            fun _expected() = expected

            /**
             * A dictionary of numeric values (between 0 and 1) to log. The scores should give
             * you a variety of signals that help you determine how accurate the outputs are
             * compared to what you expect and diagnose failures. For example, a summarization
             * app might have one score that tells you how accurate the summary is, and another
             * that measures the word similarity between the generated and grouth truth
             * summary. The word similarity score could help you determine whether the
             * summarization was covering similar concepts or not. You can use these scores to
             * help you sort, filter, and compare logs.
             */
            @JsonProperty("scores")
            @ExcludeMissing
            fun _scores() = scores

            /**
             * A dictionary with additional data about the test example, model outputs, or just
             * about anything else that's relevant, that you can use to help find and analyze
             * examples later. For example, you could log the `prompt`, example's `id`, or
             * anything else that would be useful to slice/dice later. The values in `metadata`
             * can be any JSON-serializable type, but its keys must be strings
             */
            @JsonProperty("metadata")
            @ExcludeMissing
            fun _metadata() = metadata

            /** A list of tags to log */
            @JsonProperty("tags")
            @ExcludeMissing
            fun _tags() = tags

            /**
             * Metrics are numerical measurements tracking the execution of the code that
             * produced the project logs event. Use "start" and "end" to track the time span
             * over which the project logs event was produced
             */
            @JsonProperty("metrics")
            @ExcludeMissing
            fun _metrics() = metrics

            /**
             * Context is additional information about the code that produced the project logs
             * event. It is essentially the textual counterpart to `metrics`. Use the
             * `caller_*` attributes to track the location in code which produced the project
             * logs event
             */
            @JsonProperty("context")
            @ExcludeMissing
            fun _context() = context

            /** Human-identifying attributes of the span, such as name, type, etc. */
            @JsonProperty("span_attributes")
            @ExcludeMissing
            fun _spanAttributes() = spanAttributes

            /**
             * A unique identifier for the project logs event. If you don't provide one,
             * BrainTrust will generate one for you
             */
            @JsonProperty("id")
            @ExcludeMissing
            fun _id() = id

            /** The timestamp the project logs event was created */
            @JsonProperty("created")
            @ExcludeMissing
            fun _created() = created

            /**
             * Pass `_object_delete=true` to mark the project logs event deleted. Deleted
             * events will not show up in subsequent fetches for this project logs
             */
            @JsonProperty("_object_delete")
            @ExcludeMissing
            fun __objectDelete() = _objectDelete

            /**
             * The `_is_merge` field controls how the row is merged with any existing row with
             * the same id in the DB. By default (or when set to `false`), the existing row is
             * completely replaced by the new row. When set to `true`, the new row is
             * deep-merged into the existing row
             *
             * For example, say there is an existing row in the DB
             * `{"id": "foo", "input": {"a": 5, "b": 10}}`. If we merge a new row as
             * `{"_is_merge": true, "id": "foo", "input": {"b": 11, "c": 20}}`, the new row
             * will be `{"id": "foo", "input": {"a": 5, "b": 11, "c": 20}}`. If we replace the
             * new row as `{"id": "foo", "input": {"b": 11, "c": 20}}`, the new row will be
             * `{"id": "foo", "input": {"b": 11, "c": 20}}`
             */
            @JsonProperty("_is_merge")
            @ExcludeMissing
            fun __isMerge() = _isMerge

            /**
             * Use the `_parent_id` field to create this row as a subspan of an existing row.
             * It cannot be specified alongside `_is_merge=true`. Tracking hierarchical
             * relationships are important for tracing (see the
             * [guide](https://www.braintrust.dev/docs/guides/tracing) for full details).
             *
             * For example, say we have logged a row
             * `{"id": "abc", "input": "foo", "output": "bar", "expected": "boo", "scores": {"correctness": 0.33}}`.
             * We can create a sub-span of the parent row by logging
             * `{"_parent_id": "abc", "id": "llm_call", "input": {"prompt": "What comes after foo?"}, "output": "bar", "metrics": {"tokens": 1}}`.
             * In the webapp, only the root span row `"abc"` will show up in the summary view.
             * You can view the full trace hierarchy (in this case, the `"llm_call"` row) by
             * clicking on the "abc" row.
             */
            @JsonProperty("_parent_id")
            @ExcludeMissing
            fun __parentId() = _parentId

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): InsertProjectLogsEventReplace = apply {
                if (!validated) {
                  input()
                  output()
                  expected()
                  scores()?.validate()
                  metadata()?.validate()
                  tags()
                  metrics()?.validate()
                  context()?.validate()
                  spanAttributes()?.validate()
                  id()
                  created()
                  _objectDelete()
                  _isMerge()
                  _parentId()
                  validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is InsertProjectLogsEventReplace &&
                  this.input == other.input &&
                  this.output == other.output &&
                  this.expected == other.expected &&
                  this.scores == other.scores &&
                  this.metadata == other.metadata &&
                  this.tags == other.tags &&
                  this.metrics == other.metrics &&
                  this.context == other.context &&
                  this.spanAttributes == other.spanAttributes &&
                  this.id == other.id &&
                  this.created == other.created &&
                  this._objectDelete == other._objectDelete &&
                  this._isMerge == other._isMerge &&
                  this._parentId == other._parentId &&
                  this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
              if (hashCode == 0) {
                hashCode = Objects.hash(
                    input,
                    output,
                    expected,
                    scores,
                    metadata,
                    tags,
                    metrics,
                    context,
                    spanAttributes,
                    id,
                    created,
                    _objectDelete,
                    _isMerge,
                    _parentId,
                    additionalProperties,
                )
              }
              return hashCode
            }

            override fun toString() = "InsertProjectLogsEventReplace{input=$input, output=$output, expected=$expected, scores=$scores, metadata=$metadata, tags=$tags, metrics=$metrics, context=$context, spanAttributes=$spanAttributes, id=$id, created=$created, _objectDelete=$_objectDelete, _isMerge=$_isMerge, _parentId=$_parentId, additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var input: JsonValue = JsonMissing.of()
                private var output: JsonValue = JsonMissing.of()
                private var expected: JsonValue = JsonMissing.of()
                private var scores: JsonField<Scores> = JsonMissing.of()
                private var metadata: JsonField<Metadata> = JsonMissing.of()
                private var tags: JsonField<List<String>> = JsonMissing.of()
                private var metrics: JsonField<Metrics> = JsonMissing.of()
                private var context: JsonField<Context> = JsonMissing.of()
                private var spanAttributes: JsonField<SpanAttributes> = JsonMissing.of()
                private var id: JsonField<String> = JsonMissing.of()
                private var created: JsonField<OffsetDateTime> = JsonMissing.of()
                private var _objectDelete: JsonField<Boolean> = JsonMissing.of()
                private var _isMerge: JsonField<Boolean> = JsonMissing.of()
                private var _parentId: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(insertProjectLogsEventReplace: InsertProjectLogsEventReplace) = apply {
                    this.input = insertProjectLogsEventReplace.input
                    this.output = insertProjectLogsEventReplace.output
                    this.expected = insertProjectLogsEventReplace.expected
                    this.scores = insertProjectLogsEventReplace.scores
                    this.metadata = insertProjectLogsEventReplace.metadata
                    this.tags = insertProjectLogsEventReplace.tags
                    this.metrics = insertProjectLogsEventReplace.metrics
                    this.context = insertProjectLogsEventReplace.context
                    this.spanAttributes = insertProjectLogsEventReplace.spanAttributes
                    this.id = insertProjectLogsEventReplace.id
                    this.created = insertProjectLogsEventReplace.created
                    this._objectDelete = insertProjectLogsEventReplace._objectDelete
                    this._isMerge = insertProjectLogsEventReplace._isMerge
                    this._parentId = insertProjectLogsEventReplace._parentId
                    additionalProperties(insertProjectLogsEventReplace.additionalProperties)
                }

                /**
                 * The arguments that uniquely define a user input (an arbitrary, JSON serializable
                 * object).
                 */
                @JsonProperty("input")
                @ExcludeMissing
                fun input(input: JsonValue) = apply {
                    this.input = input
                }

                /**
                 * The output of your application, including post-processing (an arbitrary, JSON
                 * serializable object), that allows you to determine whether the result is correct
                 * or not. For example, in an app that generates SQL queries, the `output` should
                 * be the _result_ of the SQL query generated by the model, not the query itself,
                 * because there may be multiple valid queries that answer a single question.
                 */
                @JsonProperty("output")
                @ExcludeMissing
                fun output(output: JsonValue) = apply {
                    this.output = output
                }

                /**
                 * The ground truth value (an arbitrary, JSON serializable object) that you'd
                 * compare to `output` to determine if your `output` value is correct or not.
                 * Braintrust currently does not compare `output` to `expected` for you, since
                 * there are so many different ways to do that correctly. Instead, these values are
                 * just used to help you navigate while digging into analyses. However, we may
                 * later use these values to re-score outputs or fine-tune your models.
                 */
                @JsonProperty("expected")
                @ExcludeMissing
                fun expected(expected: JsonValue) = apply {
                    this.expected = expected
                }

                /**
                 * A dictionary of numeric values (between 0 and 1) to log. The scores should give
                 * you a variety of signals that help you determine how accurate the outputs are
                 * compared to what you expect and diagnose failures. For example, a summarization
                 * app might have one score that tells you how accurate the summary is, and another
                 * that measures the word similarity between the generated and grouth truth
                 * summary. The word similarity score could help you determine whether the
                 * summarization was covering similar concepts or not. You can use these scores to
                 * help you sort, filter, and compare logs.
                 */
                fun scores(scores: Scores) = scores(JsonField.of(scores))

                /**
                 * A dictionary of numeric values (between 0 and 1) to log. The scores should give
                 * you a variety of signals that help you determine how accurate the outputs are
                 * compared to what you expect and diagnose failures. For example, a summarization
                 * app might have one score that tells you how accurate the summary is, and another
                 * that measures the word similarity between the generated and grouth truth
                 * summary. The word similarity score could help you determine whether the
                 * summarization was covering similar concepts or not. You can use these scores to
                 * help you sort, filter, and compare logs.
                 */
                @JsonProperty("scores")
                @ExcludeMissing
                fun scores(scores: JsonField<Scores>) = apply {
                    this.scores = scores
                }

                /**
                 * A dictionary with additional data about the test example, model outputs, or just
                 * about anything else that's relevant, that you can use to help find and analyze
                 * examples later. For example, you could log the `prompt`, example's `id`, or
                 * anything else that would be useful to slice/dice later. The values in `metadata`
                 * can be any JSON-serializable type, but its keys must be strings
                 */
                fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

                /**
                 * A dictionary with additional data about the test example, model outputs, or just
                 * about anything else that's relevant, that you can use to help find and analyze
                 * examples later. For example, you could log the `prompt`, example's `id`, or
                 * anything else that would be useful to slice/dice later. The values in `metadata`
                 * can be any JSON-serializable type, but its keys must be strings
                 */
                @JsonProperty("metadata")
                @ExcludeMissing
                fun metadata(metadata: JsonField<Metadata>) = apply {
                    this.metadata = metadata
                }

                /** A list of tags to log */
                fun tags(tags: List<String>) = tags(JsonField.of(tags))

                /** A list of tags to log */
                @JsonProperty("tags")
                @ExcludeMissing
                fun tags(tags: JsonField<List<String>>) = apply {
                    this.tags = tags
                }

                /**
                 * Metrics are numerical measurements tracking the execution of the code that
                 * produced the project logs event. Use "start" and "end" to track the time span
                 * over which the project logs event was produced
                 */
                fun metrics(metrics: Metrics) = metrics(JsonField.of(metrics))

                /**
                 * Metrics are numerical measurements tracking the execution of the code that
                 * produced the project logs event. Use "start" and "end" to track the time span
                 * over which the project logs event was produced
                 */
                @JsonProperty("metrics")
                @ExcludeMissing
                fun metrics(metrics: JsonField<Metrics>) = apply {
                    this.metrics = metrics
                }

                /**
                 * Context is additional information about the code that produced the project logs
                 * event. It is essentially the textual counterpart to `metrics`. Use the
                 * `caller_*` attributes to track the location in code which produced the project
                 * logs event
                 */
                fun context(context: Context) = context(JsonField.of(context))

                /**
                 * Context is additional information about the code that produced the project logs
                 * event. It is essentially the textual counterpart to `metrics`. Use the
                 * `caller_*` attributes to track the location in code which produced the project
                 * logs event
                 */
                @JsonProperty("context")
                @ExcludeMissing
                fun context(context: JsonField<Context>) = apply {
                    this.context = context
                }

                /** Human-identifying attributes of the span, such as name, type, etc. */
                fun spanAttributes(spanAttributes: SpanAttributes) = spanAttributes(JsonField.of(spanAttributes))

                /** Human-identifying attributes of the span, such as name, type, etc. */
                @JsonProperty("span_attributes")
                @ExcludeMissing
                fun spanAttributes(spanAttributes: JsonField<SpanAttributes>) = apply {
                    this.spanAttributes = spanAttributes
                }

                /**
                 * A unique identifier for the project logs event. If you don't provide one,
                 * BrainTrust will generate one for you
                 */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * A unique identifier for the project logs event. If you don't provide one,
                 * BrainTrust will generate one for you
                 */
                @JsonProperty("id")
                @ExcludeMissing
                fun id(id: JsonField<String>) = apply {
                    this.id = id
                }

                /** The timestamp the project logs event was created */
                fun created(created: OffsetDateTime) = created(JsonField.of(created))

                /** The timestamp the project logs event was created */
                @JsonProperty("created")
                @ExcludeMissing
                fun created(created: JsonField<OffsetDateTime>) = apply {
                    this.created = created
                }

                /**
                 * Pass `_object_delete=true` to mark the project logs event deleted. Deleted
                 * events will not show up in subsequent fetches for this project logs
                 */
                fun _objectDelete(_objectDelete: Boolean) = _objectDelete(JsonField.of(_objectDelete))

                /**
                 * Pass `_object_delete=true` to mark the project logs event deleted. Deleted
                 * events will not show up in subsequent fetches for this project logs
                 */
                @JsonProperty("_object_delete")
                @ExcludeMissing
                fun _objectDelete(_objectDelete: JsonField<Boolean>) = apply {
                    this._objectDelete = _objectDelete
                }

                /**
                 * The `_is_merge` field controls how the row is merged with any existing row with
                 * the same id in the DB. By default (or when set to `false`), the existing row is
                 * completely replaced by the new row. When set to `true`, the new row is
                 * deep-merged into the existing row
                 *
                 * For example, say there is an existing row in the DB
                 * `{"id": "foo", "input": {"a": 5, "b": 10}}`. If we merge a new row as
                 * `{"_is_merge": true, "id": "foo", "input": {"b": 11, "c": 20}}`, the new row
                 * will be `{"id": "foo", "input": {"a": 5, "b": 11, "c": 20}}`. If we replace the
                 * new row as `{"id": "foo", "input": {"b": 11, "c": 20}}`, the new row will be
                 * `{"id": "foo", "input": {"b": 11, "c": 20}}`
                 */
                fun _isMerge(_isMerge: Boolean) = _isMerge(JsonField.of(_isMerge))

                /**
                 * The `_is_merge` field controls how the row is merged with any existing row with
                 * the same id in the DB. By default (or when set to `false`), the existing row is
                 * completely replaced by the new row. When set to `true`, the new row is
                 * deep-merged into the existing row
                 *
                 * For example, say there is an existing row in the DB
                 * `{"id": "foo", "input": {"a": 5, "b": 10}}`. If we merge a new row as
                 * `{"_is_merge": true, "id": "foo", "input": {"b": 11, "c": 20}}`, the new row
                 * will be `{"id": "foo", "input": {"a": 5, "b": 11, "c": 20}}`. If we replace the
                 * new row as `{"id": "foo", "input": {"b": 11, "c": 20}}`, the new row will be
                 * `{"id": "foo", "input": {"b": 11, "c": 20}}`
                 */
                @JsonProperty("_is_merge")
                @ExcludeMissing
                fun _isMerge(_isMerge: JsonField<Boolean>) = apply {
                    this._isMerge = _isMerge
                }

                /**
                 * Use the `_parent_id` field to create this row as a subspan of an existing row.
                 * It cannot be specified alongside `_is_merge=true`. Tracking hierarchical
                 * relationships are important for tracing (see the
                 * [guide](https://www.braintrust.dev/docs/guides/tracing) for full details).
                 *
                 * For example, say we have logged a row
                 * `{"id": "abc", "input": "foo", "output": "bar", "expected": "boo", "scores": {"correctness": 0.33}}`.
                 * We can create a sub-span of the parent row by logging
                 * `{"_parent_id": "abc", "id": "llm_call", "input": {"prompt": "What comes after foo?"}, "output": "bar", "metrics": {"tokens": 1}}`.
                 * In the webapp, only the root span row `"abc"` will show up in the summary view.
                 * You can view the full trace hierarchy (in this case, the `"llm_call"` row) by
                 * clicking on the "abc" row.
                 */
                fun _parentId(_parentId: String) = _parentId(JsonField.of(_parentId))

                /**
                 * Use the `_parent_id` field to create this row as a subspan of an existing row.
                 * It cannot be specified alongside `_is_merge=true`. Tracking hierarchical
                 * relationships are important for tracing (see the
                 * [guide](https://www.braintrust.dev/docs/guides/tracing) for full details).
                 *
                 * For example, say we have logged a row
                 * `{"id": "abc", "input": "foo", "output": "bar", "expected": "boo", "scores": {"correctness": 0.33}}`.
                 * We can create a sub-span of the parent row by logging
                 * `{"_parent_id": "abc", "id": "llm_call", "input": {"prompt": "What comes after foo?"}, "output": "bar", "metrics": {"tokens": 1}}`.
                 * In the webapp, only the root span row `"abc"` will show up in the summary view.
                 * You can view the full trace hierarchy (in this case, the `"llm_call"` row) by
                 * clicking on the "abc" row.
                 */
                @JsonProperty("_parent_id")
                @ExcludeMissing
                fun _parentId(_parentId: JsonField<String>) = apply {
                    this._parentId = _parentId
                }

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

                fun build(): InsertProjectLogsEventReplace = InsertProjectLogsEventReplace(
                    input,
                    output,
                    expected,
                    scores,
                    metadata,
                    tags.map { it.toUnmodifiable() },
                    metrics,
                    context,
                    spanAttributes,
                    id,
                    created,
                    _objectDelete,
                    _isMerge,
                    _parentId,
                    additionalProperties.toUnmodifiable(),
                )
            }

            /**
             * Context is additional information about the code that produced the project logs
             * event. It is essentially the textual counterpart to `metrics`. Use the
             * `caller_*` attributes to track the location in code which produced the project
             * logs event
             */
            @JsonDeserialize(builder = Context.Builder::class)
            @NoAutoDetect
            class Context private constructor(
              private val callerFunctionname: JsonField<String>,
              private val callerFilename: JsonField<String>,
              private val callerLineno: JsonField<Long>,
              private val additionalProperties: Map<String, JsonValue>,

            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                /** The function in code which created the project logs event */
                fun callerFunctionname(): String? = callerFunctionname.getNullable("caller_functionname")

                /** Name of the file in code where the project logs event was created */
                fun callerFilename(): String? = callerFilename.getNullable("caller_filename")

                /** Line of code where the project logs event was created */
                fun callerLineno(): Long? = callerLineno.getNullable("caller_lineno")

                /** The function in code which created the project logs event */
                @JsonProperty("caller_functionname")
                @ExcludeMissing
                fun _callerFunctionname() = callerFunctionname

                /** Name of the file in code where the project logs event was created */
                @JsonProperty("caller_filename")
                @ExcludeMissing
                fun _callerFilename() = callerFilename

                /** Line of code where the project logs event was created */
                @JsonProperty("caller_lineno")
                @ExcludeMissing
                fun _callerLineno() = callerLineno

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): Context = apply {
                    if (!validated) {
                      callerFunctionname()
                      callerFilename()
                      callerLineno()
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is Context &&
                      this.callerFunctionname == other.callerFunctionname &&
                      this.callerFilename == other.callerFilename &&
                      this.callerLineno == other.callerLineno &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(
                        callerFunctionname,
                        callerFilename,
                        callerLineno,
                        additionalProperties,
                    )
                  }
                  return hashCode
                }

                override fun toString() = "Context{callerFunctionname=$callerFunctionname, callerFilename=$callerFilename, callerLineno=$callerLineno, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var callerFunctionname: JsonField<String> = JsonMissing.of()
                    private var callerFilename: JsonField<String> = JsonMissing.of()
                    private var callerLineno: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(context: Context) = apply {
                        this.callerFunctionname = context.callerFunctionname
                        this.callerFilename = context.callerFilename
                        this.callerLineno = context.callerLineno
                        additionalProperties(context.additionalProperties)
                    }

                    /** The function in code which created the project logs event */
                    fun callerFunctionname(callerFunctionname: String) = callerFunctionname(JsonField.of(callerFunctionname))

                    /** The function in code which created the project logs event */
                    @JsonProperty("caller_functionname")
                    @ExcludeMissing
                    fun callerFunctionname(callerFunctionname: JsonField<String>) = apply {
                        this.callerFunctionname = callerFunctionname
                    }

                    /** Name of the file in code where the project logs event was created */
                    fun callerFilename(callerFilename: String) = callerFilename(JsonField.of(callerFilename))

                    /** Name of the file in code where the project logs event was created */
                    @JsonProperty("caller_filename")
                    @ExcludeMissing
                    fun callerFilename(callerFilename: JsonField<String>) = apply {
                        this.callerFilename = callerFilename
                    }

                    /** Line of code where the project logs event was created */
                    fun callerLineno(callerLineno: Long) = callerLineno(JsonField.of(callerLineno))

                    /** Line of code where the project logs event was created */
                    @JsonProperty("caller_lineno")
                    @ExcludeMissing
                    fun callerLineno(callerLineno: JsonField<Long>) = apply {
                        this.callerLineno = callerLineno
                    }

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

                    fun build(): Context = Context(
                        callerFunctionname,
                        callerFilename,
                        callerLineno,
                        additionalProperties.toUnmodifiable(),
                    )
                }
            }

            /**
             * A dictionary with additional data about the test example, model outputs, or just
             * about anything else that's relevant, that you can use to help find and analyze
             * examples later. For example, you could log the `prompt`, example's `id`, or
             * anything else that would be useful to slice/dice later. The values in `metadata`
             * can be any JSON-serializable type, but its keys must be strings
             */
            @JsonDeserialize(builder = Metadata.Builder::class)
            @NoAutoDetect
            class Metadata private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): Metadata = apply {
                    if (!validated) {
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is Metadata &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(additionalProperties)
                  }
                  return hashCode
                }

                override fun toString() = "Metadata{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(metadata: Metadata) = apply {
                        additionalProperties(metadata.additionalProperties)
                    }

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

                    fun build(): Metadata = Metadata(additionalProperties.toUnmodifiable())
                }
            }

            /**
             * Metrics are numerical measurements tracking the execution of the code that
             * produced the project logs event. Use "start" and "end" to track the time span
             * over which the project logs event was produced
             */
            @JsonDeserialize(builder = Metrics.Builder::class)
            @NoAutoDetect
            class Metrics private constructor(
              private val start: JsonField<Double>,
              private val end: JsonField<Double>,
              private val promptTokens: JsonField<Long>,
              private val completionTokens: JsonField<Long>,
              private val tokens: JsonField<Long>,
              private val additionalProperties: Map<String, JsonValue>,

            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                /**
                 * A unix timestamp recording when the section of code which produced the project
                 * logs event started
                 */
                fun start(): Double? = start.getNullable("start")

                /**
                 * A unix timestamp recording when the section of code which produced the project
                 * logs event finished
                 */
                fun end(): Double? = end.getNullable("end")

                /**
                 * The number of tokens in the prompt used to generate the project logs event (only
                 * set if this is an LLM span)
                 */
                fun promptTokens(): Long? = promptTokens.getNullable("prompt_tokens")

                /**
                 * The number of tokens in the completion generated by the model (only set if this
                 * is an LLM span)
                 */
                fun completionTokens(): Long? = completionTokens.getNullable("completion_tokens")

                /** The total number of tokens in the input and output of the project logs event. */
                fun tokens(): Long? = tokens.getNullable("tokens")

                /**
                 * A unix timestamp recording when the section of code which produced the project
                 * logs event started
                 */
                @JsonProperty("start")
                @ExcludeMissing
                fun _start() = start

                /**
                 * A unix timestamp recording when the section of code which produced the project
                 * logs event finished
                 */
                @JsonProperty("end")
                @ExcludeMissing
                fun _end() = end

                /**
                 * The number of tokens in the prompt used to generate the project logs event (only
                 * set if this is an LLM span)
                 */
                @JsonProperty("prompt_tokens")
                @ExcludeMissing
                fun _promptTokens() = promptTokens

                /**
                 * The number of tokens in the completion generated by the model (only set if this
                 * is an LLM span)
                 */
                @JsonProperty("completion_tokens")
                @ExcludeMissing
                fun _completionTokens() = completionTokens

                /** The total number of tokens in the input and output of the project logs event. */
                @JsonProperty("tokens")
                @ExcludeMissing
                fun _tokens() = tokens

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): Metrics = apply {
                    if (!validated) {
                      start()
                      end()
                      promptTokens()
                      completionTokens()
                      tokens()
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is Metrics &&
                      this.start == other.start &&
                      this.end == other.end &&
                      this.promptTokens == other.promptTokens &&
                      this.completionTokens == other.completionTokens &&
                      this.tokens == other.tokens &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(
                        start,
                        end,
                        promptTokens,
                        completionTokens,
                        tokens,
                        additionalProperties,
                    )
                  }
                  return hashCode
                }

                override fun toString() = "Metrics{start=$start, end=$end, promptTokens=$promptTokens, completionTokens=$completionTokens, tokens=$tokens, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var start: JsonField<Double> = JsonMissing.of()
                    private var end: JsonField<Double> = JsonMissing.of()
                    private var promptTokens: JsonField<Long> = JsonMissing.of()
                    private var completionTokens: JsonField<Long> = JsonMissing.of()
                    private var tokens: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(metrics: Metrics) = apply {
                        this.start = metrics.start
                        this.end = metrics.end
                        this.promptTokens = metrics.promptTokens
                        this.completionTokens = metrics.completionTokens
                        this.tokens = metrics.tokens
                        additionalProperties(metrics.additionalProperties)
                    }

                    /**
                     * A unix timestamp recording when the section of code which produced the project
                     * logs event started
                     */
                    fun start(start: Double) = start(JsonField.of(start))

                    /**
                     * A unix timestamp recording when the section of code which produced the project
                     * logs event started
                     */
                    @JsonProperty("start")
                    @ExcludeMissing
                    fun start(start: JsonField<Double>) = apply {
                        this.start = start
                    }

                    /**
                     * A unix timestamp recording when the section of code which produced the project
                     * logs event finished
                     */
                    fun end(end: Double) = end(JsonField.of(end))

                    /**
                     * A unix timestamp recording when the section of code which produced the project
                     * logs event finished
                     */
                    @JsonProperty("end")
                    @ExcludeMissing
                    fun end(end: JsonField<Double>) = apply {
                        this.end = end
                    }

                    /**
                     * The number of tokens in the prompt used to generate the project logs event (only
                     * set if this is an LLM span)
                     */
                    fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

                    /**
                     * The number of tokens in the prompt used to generate the project logs event (only
                     * set if this is an LLM span)
                     */
                    @JsonProperty("prompt_tokens")
                    @ExcludeMissing
                    fun promptTokens(promptTokens: JsonField<Long>) = apply {
                        this.promptTokens = promptTokens
                    }

                    /**
                     * The number of tokens in the completion generated by the model (only set if this
                     * is an LLM span)
                     */
                    fun completionTokens(completionTokens: Long) = completionTokens(JsonField.of(completionTokens))

                    /**
                     * The number of tokens in the completion generated by the model (only set if this
                     * is an LLM span)
                     */
                    @JsonProperty("completion_tokens")
                    @ExcludeMissing
                    fun completionTokens(completionTokens: JsonField<Long>) = apply {
                        this.completionTokens = completionTokens
                    }

                    /** The total number of tokens in the input and output of the project logs event. */
                    fun tokens(tokens: Long) = tokens(JsonField.of(tokens))

                    /** The total number of tokens in the input and output of the project logs event. */
                    @JsonProperty("tokens")
                    @ExcludeMissing
                    fun tokens(tokens: JsonField<Long>) = apply {
                        this.tokens = tokens
                    }

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

                    fun build(): Metrics = Metrics(
                        start,
                        end,
                        promptTokens,
                        completionTokens,
                        tokens,
                        additionalProperties.toUnmodifiable(),
                    )
                }
            }

            /**
             * A dictionary of numeric values (between 0 and 1) to log. The scores should give
             * you a variety of signals that help you determine how accurate the outputs are
             * compared to what you expect and diagnose failures. For example, a summarization
             * app might have one score that tells you how accurate the summary is, and another
             * that measures the word similarity between the generated and grouth truth
             * summary. The word similarity score could help you determine whether the
             * summarization was covering similar concepts or not. You can use these scores to
             * help you sort, filter, and compare logs.
             */
            @JsonDeserialize(builder = Scores.Builder::class)
            @NoAutoDetect
            class Scores private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): Scores = apply {
                    if (!validated) {
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is Scores &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(additionalProperties)
                  }
                  return hashCode
                }

                override fun toString() = "Scores{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(scores: Scores) = apply {
                        additionalProperties(scores.additionalProperties)
                    }

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

                    fun build(): Scores = Scores(additionalProperties.toUnmodifiable())
                }
            }

            /** Human-identifying attributes of the span, such as name, type, etc. */
            @JsonDeserialize(builder = SpanAttributes.Builder::class)
            @NoAutoDetect
            class SpanAttributes private constructor(private val name: JsonField<String>, private val type: JsonField<Type>, private val additionalProperties: Map<String, JsonValue>, ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                /** Name of the span, for display purposes only */
                fun name(): String? = name.getNullable("name")

                /** Type of the span, for display purposes only */
                fun type(): Type? = type.getNullable("type")

                /** Name of the span, for display purposes only */
                @JsonProperty("name")
                @ExcludeMissing
                fun _name() = name

                /** Type of the span, for display purposes only */
                @JsonProperty("type")
                @ExcludeMissing
                fun _type() = type

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): SpanAttributes = apply {
                    if (!validated) {
                      name()
                      type()
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is SpanAttributes &&
                      this.name == other.name &&
                      this.type == other.type &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(
                        name,
                        type,
                        additionalProperties,
                    )
                  }
                  return hashCode
                }

                override fun toString() = "SpanAttributes{name=$name, type=$type, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var name: JsonField<String> = JsonMissing.of()
                    private var type: JsonField<Type> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(spanAttributes: SpanAttributes) = apply {
                        this.name = spanAttributes.name
                        this.type = spanAttributes.type
                        additionalProperties(spanAttributes.additionalProperties)
                    }

                    /** Name of the span, for display purposes only */
                    fun name(name: String) = name(JsonField.of(name))

                    /** Name of the span, for display purposes only */
                    @JsonProperty("name")
                    @ExcludeMissing
                    fun name(name: JsonField<String>) = apply {
                        this.name = name
                    }

                    /** Type of the span, for display purposes only */
                    fun type(type: Type) = type(JsonField.of(type))

                    /** Type of the span, for display purposes only */
                    @JsonProperty("type")
                    @ExcludeMissing
                    fun type(type: JsonField<Type>) = apply {
                        this.type = type
                    }

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

                    fun build(): SpanAttributes = SpanAttributes(
                        name,
                        type,
                        additionalProperties.toUnmodifiable(),
                    )
                }

                class Type @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    override fun equals(other: Any?): Boolean {
                      if (this === other) {
                          return true
                      }

                      return other is Type &&
                          this.value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()

                    companion object {

                        val LLM = Type(JsonField.of("llm"))

                        val SCORE = Type(JsonField.of("score"))

                        val FUNCTION = Type(JsonField.of("function"))

                        val EVAL = Type(JsonField.of("eval"))

                        val TASK = Type(JsonField.of("task"))

                        val TOOL = Type(JsonField.of("tool"))

                        fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        LLM,
                        SCORE,
                        FUNCTION,
                        EVAL,
                        TASK,
                        TOOL,
                    }

                    enum class Value {
                        LLM,
                        SCORE,
                        FUNCTION,
                        EVAL,
                        TASK,
                        TOOL,
                        _UNKNOWN,
                    }

                    fun value(): Value = when (this) {
                        LLM -> Value.LLM
                        SCORE -> Value.SCORE
                        FUNCTION -> Value.FUNCTION
                        EVAL -> Value.EVAL
                        TASK -> Value.TASK
                        TOOL -> Value.TOOL
                        else -> Value._UNKNOWN
                    }

                    fun known(): Known = when (this) {
                        LLM -> Known.LLM
                        SCORE -> Known.SCORE
                        FUNCTION -> Known.FUNCTION
                        EVAL -> Known.EVAL
                        TASK -> Known.TASK
                        TOOL -> Known.TOOL
                        else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                    }

                    fun asString(): String = _value().asStringOrThrow()
                }
            }
        }

        @JsonDeserialize(builder = InsertProjectLogsEventMerge.Builder::class)
        @NoAutoDetect
        class InsertProjectLogsEventMerge private constructor(
          private val input: JsonValue,
          private val output: JsonValue,
          private val expected: JsonValue,
          private val scores: JsonField<Scores>,
          private val metadata: JsonField<Metadata>,
          private val tags: JsonField<List<String>>,
          private val metrics: JsonField<Metrics>,
          private val context: JsonField<Context>,
          private val spanAttributes: JsonField<SpanAttributes>,
          private val id: JsonField<String>,
          private val created: JsonField<OffsetDateTime>,
          private val _objectDelete: JsonField<Boolean>,
          private val _isMerge: JsonField<Boolean>,
          private val _mergePaths: JsonField<List<List<String>>>,
          private val additionalProperties: Map<String, JsonValue>,

        ) {

            private var validated: Boolean = false

            private var hashCode: Int = 0

            /**
             * The arguments that uniquely define a user input (an arbitrary, JSON serializable
             * object).
             */
            fun input(): JsonValue = input

            /**
             * The output of your application, including post-processing (an arbitrary, JSON
             * serializable object), that allows you to determine whether the result is correct
             * or not. For example, in an app that generates SQL queries, the `output` should
             * be the _result_ of the SQL query generated by the model, not the query itself,
             * because there may be multiple valid queries that answer a single question.
             */
            fun output(): JsonValue = output

            /**
             * The ground truth value (an arbitrary, JSON serializable object) that you'd
             * compare to `output` to determine if your `output` value is correct or not.
             * Braintrust currently does not compare `output` to `expected` for you, since
             * there are so many different ways to do that correctly. Instead, these values are
             * just used to help you navigate while digging into analyses. However, we may
             * later use these values to re-score outputs or fine-tune your models.
             */
            fun expected(): JsonValue = expected

            /**
             * A dictionary of numeric values (between 0 and 1) to log. The scores should give
             * you a variety of signals that help you determine how accurate the outputs are
             * compared to what you expect and diagnose failures. For example, a summarization
             * app might have one score that tells you how accurate the summary is, and another
             * that measures the word similarity between the generated and grouth truth
             * summary. The word similarity score could help you determine whether the
             * summarization was covering similar concepts or not. You can use these scores to
             * help you sort, filter, and compare logs.
             */
            fun scores(): Scores? = scores.getNullable("scores")

            /**
             * A dictionary with additional data about the test example, model outputs, or just
             * about anything else that's relevant, that you can use to help find and analyze
             * examples later. For example, you could log the `prompt`, example's `id`, or
             * anything else that would be useful to slice/dice later. The values in `metadata`
             * can be any JSON-serializable type, but its keys must be strings
             */
            fun metadata(): Metadata? = metadata.getNullable("metadata")

            /** A list of tags to log */
            fun tags(): List<String>? = tags.getNullable("tags")

            /**
             * Metrics are numerical measurements tracking the execution of the code that
             * produced the project logs event. Use "start" and "end" to track the time span
             * over which the project logs event was produced
             */
            fun metrics(): Metrics? = metrics.getNullable("metrics")

            /**
             * Context is additional information about the code that produced the project logs
             * event. It is essentially the textual counterpart to `metrics`. Use the
             * `caller_*` attributes to track the location in code which produced the project
             * logs event
             */
            fun context(): Context? = context.getNullable("context")

            /** Human-identifying attributes of the span, such as name, type, etc. */
            fun spanAttributes(): SpanAttributes? = spanAttributes.getNullable("span_attributes")

            /**
             * A unique identifier for the project logs event. If you don't provide one,
             * BrainTrust will generate one for you
             */
            fun id(): String? = id.getNullable("id")

            /** The timestamp the project logs event was created */
            fun created(): OffsetDateTime? = created.getNullable("created")

            /**
             * Pass `_object_delete=true` to mark the project logs event deleted. Deleted
             * events will not show up in subsequent fetches for this project logs
             */
            fun _objectDelete(): Boolean? = _objectDelete.getNullable("_object_delete")

            /**
             * The `_is_merge` field controls how the row is merged with any existing row with
             * the same id in the DB. By default (or when set to `false`), the existing row is
             * completely replaced by the new row. When set to `true`, the new row is
             * deep-merged into the existing row
             *
             * For example, say there is an existing row in the DB
             * `{"id": "foo", "input": {"a": 5, "b": 10}}`. If we merge a new row as
             * `{"_is_merge": true, "id": "foo", "input": {"b": 11, "c": 20}}`, the new row
             * will be `{"id": "foo", "input": {"a": 5, "b": 11, "c": 20}}`. If we replace the
             * new row as `{"id": "foo", "input": {"b": 11, "c": 20}}`, the new row will be
             * `{"id": "foo", "input": {"b": 11, "c": 20}}`
             */
            fun _isMerge(): Boolean = _isMerge.getRequired("_is_merge")

            /**
             * The `_merge_paths` field allows controlling the depth of the merge. It can only
             * be specified alongside `_is_merge=true`. `_merge_paths` is a list of paths,
             * where each path is a list of field names. The deep merge will not descend below
             * any of the specified merge paths.
             *
             * For example, say there is an existing row in the DB
             * `{"id": "foo", "input": {"a": {"b": 10}, "c": {"d": 20}}, "output": {"a": 20}}`.
             * If we merge a new row as
             * `{"_is_merge": true, "_merge_paths": [["input", "a"], ["output"]], "input": {"a": {"q": 30}, "c": {"e": 30}, "bar": "baz"}, "output": {"d": 40}}`,
             * the new row will be
             * `{"id": "foo": "input": {"a": {"q": 30}, "c": {"d": 20, "e": 30}, "bar": "baz"}, "output": {"d": 40}}`.
             * In this case, due to the merge paths, we have replaced `input.a` and `output`,
             * but have still deep-merged `input` and `input.c`.
             */
            fun _mergePaths(): List<List<String>>? = _mergePaths.getNullable("_merge_paths")

            /**
             * The arguments that uniquely define a user input (an arbitrary, JSON serializable
             * object).
             */
            @JsonProperty("input")
            @ExcludeMissing
            fun _input() = input

            /**
             * The output of your application, including post-processing (an arbitrary, JSON
             * serializable object), that allows you to determine whether the result is correct
             * or not. For example, in an app that generates SQL queries, the `output` should
             * be the _result_ of the SQL query generated by the model, not the query itself,
             * because there may be multiple valid queries that answer a single question.
             */
            @JsonProperty("output")
            @ExcludeMissing
            fun _output() = output

            /**
             * The ground truth value (an arbitrary, JSON serializable object) that you'd
             * compare to `output` to determine if your `output` value is correct or not.
             * Braintrust currently does not compare `output` to `expected` for you, since
             * there are so many different ways to do that correctly. Instead, these values are
             * just used to help you navigate while digging into analyses. However, we may
             * later use these values to re-score outputs or fine-tune your models.
             */
            @JsonProperty("expected")
            @ExcludeMissing
            fun _expected() = expected

            /**
             * A dictionary of numeric values (between 0 and 1) to log. The scores should give
             * you a variety of signals that help you determine how accurate the outputs are
             * compared to what you expect and diagnose failures. For example, a summarization
             * app might have one score that tells you how accurate the summary is, and another
             * that measures the word similarity between the generated and grouth truth
             * summary. The word similarity score could help you determine whether the
             * summarization was covering similar concepts or not. You can use these scores to
             * help you sort, filter, and compare logs.
             */
            @JsonProperty("scores")
            @ExcludeMissing
            fun _scores() = scores

            /**
             * A dictionary with additional data about the test example, model outputs, or just
             * about anything else that's relevant, that you can use to help find and analyze
             * examples later. For example, you could log the `prompt`, example's `id`, or
             * anything else that would be useful to slice/dice later. The values in `metadata`
             * can be any JSON-serializable type, but its keys must be strings
             */
            @JsonProperty("metadata")
            @ExcludeMissing
            fun _metadata() = metadata

            /** A list of tags to log */
            @JsonProperty("tags")
            @ExcludeMissing
            fun _tags() = tags

            /**
             * Metrics are numerical measurements tracking the execution of the code that
             * produced the project logs event. Use "start" and "end" to track the time span
             * over which the project logs event was produced
             */
            @JsonProperty("metrics")
            @ExcludeMissing
            fun _metrics() = metrics

            /**
             * Context is additional information about the code that produced the project logs
             * event. It is essentially the textual counterpart to `metrics`. Use the
             * `caller_*` attributes to track the location in code which produced the project
             * logs event
             */
            @JsonProperty("context")
            @ExcludeMissing
            fun _context() = context

            /** Human-identifying attributes of the span, such as name, type, etc. */
            @JsonProperty("span_attributes")
            @ExcludeMissing
            fun _spanAttributes() = spanAttributes

            /**
             * A unique identifier for the project logs event. If you don't provide one,
             * BrainTrust will generate one for you
             */
            @JsonProperty("id")
            @ExcludeMissing
            fun _id() = id

            /** The timestamp the project logs event was created */
            @JsonProperty("created")
            @ExcludeMissing
            fun _created() = created

            /**
             * Pass `_object_delete=true` to mark the project logs event deleted. Deleted
             * events will not show up in subsequent fetches for this project logs
             */
            @JsonProperty("_object_delete")
            @ExcludeMissing
            fun __objectDelete() = _objectDelete

            /**
             * The `_is_merge` field controls how the row is merged with any existing row with
             * the same id in the DB. By default (or when set to `false`), the existing row is
             * completely replaced by the new row. When set to `true`, the new row is
             * deep-merged into the existing row
             *
             * For example, say there is an existing row in the DB
             * `{"id": "foo", "input": {"a": 5, "b": 10}}`. If we merge a new row as
             * `{"_is_merge": true, "id": "foo", "input": {"b": 11, "c": 20}}`, the new row
             * will be `{"id": "foo", "input": {"a": 5, "b": 11, "c": 20}}`. If we replace the
             * new row as `{"id": "foo", "input": {"b": 11, "c": 20}}`, the new row will be
             * `{"id": "foo", "input": {"b": 11, "c": 20}}`
             */
            @JsonProperty("_is_merge")
            @ExcludeMissing
            fun __isMerge() = _isMerge

            /**
             * The `_merge_paths` field allows controlling the depth of the merge. It can only
             * be specified alongside `_is_merge=true`. `_merge_paths` is a list of paths,
             * where each path is a list of field names. The deep merge will not descend below
             * any of the specified merge paths.
             *
             * For example, say there is an existing row in the DB
             * `{"id": "foo", "input": {"a": {"b": 10}, "c": {"d": 20}}, "output": {"a": 20}}`.
             * If we merge a new row as
             * `{"_is_merge": true, "_merge_paths": [["input", "a"], ["output"]], "input": {"a": {"q": 30}, "c": {"e": 30}, "bar": "baz"}, "output": {"d": 40}}`,
             * the new row will be
             * `{"id": "foo": "input": {"a": {"q": 30}, "c": {"d": 20, "e": 30}, "bar": "baz"}, "output": {"d": 40}}`.
             * In this case, due to the merge paths, we have replaced `input.a` and `output`,
             * but have still deep-merged `input` and `input.c`.
             */
            @JsonProperty("_merge_paths")
            @ExcludeMissing
            fun __mergePaths() = _mergePaths

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun validate(): InsertProjectLogsEventMerge = apply {
                if (!validated) {
                  input()
                  output()
                  expected()
                  scores()?.validate()
                  metadata()?.validate()
                  tags()
                  metrics()?.validate()
                  context()?.validate()
                  spanAttributes()?.validate()
                  id()
                  created()
                  _objectDelete()
                  _isMerge()
                  _mergePaths()
                  validated = true
                }
            }

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return other is InsertProjectLogsEventMerge &&
                  this.input == other.input &&
                  this.output == other.output &&
                  this.expected == other.expected &&
                  this.scores == other.scores &&
                  this.metadata == other.metadata &&
                  this.tags == other.tags &&
                  this.metrics == other.metrics &&
                  this.context == other.context &&
                  this.spanAttributes == other.spanAttributes &&
                  this.id == other.id &&
                  this.created == other.created &&
                  this._objectDelete == other._objectDelete &&
                  this._isMerge == other._isMerge &&
                  this._mergePaths == other._mergePaths &&
                  this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
              if (hashCode == 0) {
                hashCode = Objects.hash(
                    input,
                    output,
                    expected,
                    scores,
                    metadata,
                    tags,
                    metrics,
                    context,
                    spanAttributes,
                    id,
                    created,
                    _objectDelete,
                    _isMerge,
                    _mergePaths,
                    additionalProperties,
                )
              }
              return hashCode
            }

            override fun toString() = "InsertProjectLogsEventMerge{input=$input, output=$output, expected=$expected, scores=$scores, metadata=$metadata, tags=$tags, metrics=$metrics, context=$context, spanAttributes=$spanAttributes, id=$id, created=$created, _objectDelete=$_objectDelete, _isMerge=$_isMerge, _mergePaths=$_mergePaths, additionalProperties=$additionalProperties}"

            companion object {

                fun builder() = Builder()
            }

            class Builder {

                private var input: JsonValue = JsonMissing.of()
                private var output: JsonValue = JsonMissing.of()
                private var expected: JsonValue = JsonMissing.of()
                private var scores: JsonField<Scores> = JsonMissing.of()
                private var metadata: JsonField<Metadata> = JsonMissing.of()
                private var tags: JsonField<List<String>> = JsonMissing.of()
                private var metrics: JsonField<Metrics> = JsonMissing.of()
                private var context: JsonField<Context> = JsonMissing.of()
                private var spanAttributes: JsonField<SpanAttributes> = JsonMissing.of()
                private var id: JsonField<String> = JsonMissing.of()
                private var created: JsonField<OffsetDateTime> = JsonMissing.of()
                private var _objectDelete: JsonField<Boolean> = JsonMissing.of()
                private var _isMerge: JsonField<Boolean> = JsonMissing.of()
                private var _mergePaths: JsonField<List<List<String>>> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                internal fun from(insertProjectLogsEventMerge: InsertProjectLogsEventMerge) = apply {
                    this.input = insertProjectLogsEventMerge.input
                    this.output = insertProjectLogsEventMerge.output
                    this.expected = insertProjectLogsEventMerge.expected
                    this.scores = insertProjectLogsEventMerge.scores
                    this.metadata = insertProjectLogsEventMerge.metadata
                    this.tags = insertProjectLogsEventMerge.tags
                    this.metrics = insertProjectLogsEventMerge.metrics
                    this.context = insertProjectLogsEventMerge.context
                    this.spanAttributes = insertProjectLogsEventMerge.spanAttributes
                    this.id = insertProjectLogsEventMerge.id
                    this.created = insertProjectLogsEventMerge.created
                    this._objectDelete = insertProjectLogsEventMerge._objectDelete
                    this._isMerge = insertProjectLogsEventMerge._isMerge
                    this._mergePaths = insertProjectLogsEventMerge._mergePaths
                    additionalProperties(insertProjectLogsEventMerge.additionalProperties)
                }

                /**
                 * The arguments that uniquely define a user input (an arbitrary, JSON serializable
                 * object).
                 */
                @JsonProperty("input")
                @ExcludeMissing
                fun input(input: JsonValue) = apply {
                    this.input = input
                }

                /**
                 * The output of your application, including post-processing (an arbitrary, JSON
                 * serializable object), that allows you to determine whether the result is correct
                 * or not. For example, in an app that generates SQL queries, the `output` should
                 * be the _result_ of the SQL query generated by the model, not the query itself,
                 * because there may be multiple valid queries that answer a single question.
                 */
                @JsonProperty("output")
                @ExcludeMissing
                fun output(output: JsonValue) = apply {
                    this.output = output
                }

                /**
                 * The ground truth value (an arbitrary, JSON serializable object) that you'd
                 * compare to `output` to determine if your `output` value is correct or not.
                 * Braintrust currently does not compare `output` to `expected` for you, since
                 * there are so many different ways to do that correctly. Instead, these values are
                 * just used to help you navigate while digging into analyses. However, we may
                 * later use these values to re-score outputs or fine-tune your models.
                 */
                @JsonProperty("expected")
                @ExcludeMissing
                fun expected(expected: JsonValue) = apply {
                    this.expected = expected
                }

                /**
                 * A dictionary of numeric values (between 0 and 1) to log. The scores should give
                 * you a variety of signals that help you determine how accurate the outputs are
                 * compared to what you expect and diagnose failures. For example, a summarization
                 * app might have one score that tells you how accurate the summary is, and another
                 * that measures the word similarity between the generated and grouth truth
                 * summary. The word similarity score could help you determine whether the
                 * summarization was covering similar concepts or not. You can use these scores to
                 * help you sort, filter, and compare logs.
                 */
                fun scores(scores: Scores) = scores(JsonField.of(scores))

                /**
                 * A dictionary of numeric values (between 0 and 1) to log. The scores should give
                 * you a variety of signals that help you determine how accurate the outputs are
                 * compared to what you expect and diagnose failures. For example, a summarization
                 * app might have one score that tells you how accurate the summary is, and another
                 * that measures the word similarity between the generated and grouth truth
                 * summary. The word similarity score could help you determine whether the
                 * summarization was covering similar concepts or not. You can use these scores to
                 * help you sort, filter, and compare logs.
                 */
                @JsonProperty("scores")
                @ExcludeMissing
                fun scores(scores: JsonField<Scores>) = apply {
                    this.scores = scores
                }

                /**
                 * A dictionary with additional data about the test example, model outputs, or just
                 * about anything else that's relevant, that you can use to help find and analyze
                 * examples later. For example, you could log the `prompt`, example's `id`, or
                 * anything else that would be useful to slice/dice later. The values in `metadata`
                 * can be any JSON-serializable type, but its keys must be strings
                 */
                fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

                /**
                 * A dictionary with additional data about the test example, model outputs, or just
                 * about anything else that's relevant, that you can use to help find and analyze
                 * examples later. For example, you could log the `prompt`, example's `id`, or
                 * anything else that would be useful to slice/dice later. The values in `metadata`
                 * can be any JSON-serializable type, but its keys must be strings
                 */
                @JsonProperty("metadata")
                @ExcludeMissing
                fun metadata(metadata: JsonField<Metadata>) = apply {
                    this.metadata = metadata
                }

                /** A list of tags to log */
                fun tags(tags: List<String>) = tags(JsonField.of(tags))

                /** A list of tags to log */
                @JsonProperty("tags")
                @ExcludeMissing
                fun tags(tags: JsonField<List<String>>) = apply {
                    this.tags = tags
                }

                /**
                 * Metrics are numerical measurements tracking the execution of the code that
                 * produced the project logs event. Use "start" and "end" to track the time span
                 * over which the project logs event was produced
                 */
                fun metrics(metrics: Metrics) = metrics(JsonField.of(metrics))

                /**
                 * Metrics are numerical measurements tracking the execution of the code that
                 * produced the project logs event. Use "start" and "end" to track the time span
                 * over which the project logs event was produced
                 */
                @JsonProperty("metrics")
                @ExcludeMissing
                fun metrics(metrics: JsonField<Metrics>) = apply {
                    this.metrics = metrics
                }

                /**
                 * Context is additional information about the code that produced the project logs
                 * event. It is essentially the textual counterpart to `metrics`. Use the
                 * `caller_*` attributes to track the location in code which produced the project
                 * logs event
                 */
                fun context(context: Context) = context(JsonField.of(context))

                /**
                 * Context is additional information about the code that produced the project logs
                 * event. It is essentially the textual counterpart to `metrics`. Use the
                 * `caller_*` attributes to track the location in code which produced the project
                 * logs event
                 */
                @JsonProperty("context")
                @ExcludeMissing
                fun context(context: JsonField<Context>) = apply {
                    this.context = context
                }

                /** Human-identifying attributes of the span, such as name, type, etc. */
                fun spanAttributes(spanAttributes: SpanAttributes) = spanAttributes(JsonField.of(spanAttributes))

                /** Human-identifying attributes of the span, such as name, type, etc. */
                @JsonProperty("span_attributes")
                @ExcludeMissing
                fun spanAttributes(spanAttributes: JsonField<SpanAttributes>) = apply {
                    this.spanAttributes = spanAttributes
                }

                /**
                 * A unique identifier for the project logs event. If you don't provide one,
                 * BrainTrust will generate one for you
                 */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * A unique identifier for the project logs event. If you don't provide one,
                 * BrainTrust will generate one for you
                 */
                @JsonProperty("id")
                @ExcludeMissing
                fun id(id: JsonField<String>) = apply {
                    this.id = id
                }

                /** The timestamp the project logs event was created */
                fun created(created: OffsetDateTime) = created(JsonField.of(created))

                /** The timestamp the project logs event was created */
                @JsonProperty("created")
                @ExcludeMissing
                fun created(created: JsonField<OffsetDateTime>) = apply {
                    this.created = created
                }

                /**
                 * Pass `_object_delete=true` to mark the project logs event deleted. Deleted
                 * events will not show up in subsequent fetches for this project logs
                 */
                fun _objectDelete(_objectDelete: Boolean) = _objectDelete(JsonField.of(_objectDelete))

                /**
                 * Pass `_object_delete=true` to mark the project logs event deleted. Deleted
                 * events will not show up in subsequent fetches for this project logs
                 */
                @JsonProperty("_object_delete")
                @ExcludeMissing
                fun _objectDelete(_objectDelete: JsonField<Boolean>) = apply {
                    this._objectDelete = _objectDelete
                }

                /**
                 * The `_is_merge` field controls how the row is merged with any existing row with
                 * the same id in the DB. By default (or when set to `false`), the existing row is
                 * completely replaced by the new row. When set to `true`, the new row is
                 * deep-merged into the existing row
                 *
                 * For example, say there is an existing row in the DB
                 * `{"id": "foo", "input": {"a": 5, "b": 10}}`. If we merge a new row as
                 * `{"_is_merge": true, "id": "foo", "input": {"b": 11, "c": 20}}`, the new row
                 * will be `{"id": "foo", "input": {"a": 5, "b": 11, "c": 20}}`. If we replace the
                 * new row as `{"id": "foo", "input": {"b": 11, "c": 20}}`, the new row will be
                 * `{"id": "foo", "input": {"b": 11, "c": 20}}`
                 */
                fun _isMerge(_isMerge: Boolean) = _isMerge(JsonField.of(_isMerge))

                /**
                 * The `_is_merge` field controls how the row is merged with any existing row with
                 * the same id in the DB. By default (or when set to `false`), the existing row is
                 * completely replaced by the new row. When set to `true`, the new row is
                 * deep-merged into the existing row
                 *
                 * For example, say there is an existing row in the DB
                 * `{"id": "foo", "input": {"a": 5, "b": 10}}`. If we merge a new row as
                 * `{"_is_merge": true, "id": "foo", "input": {"b": 11, "c": 20}}`, the new row
                 * will be `{"id": "foo", "input": {"a": 5, "b": 11, "c": 20}}`. If we replace the
                 * new row as `{"id": "foo", "input": {"b": 11, "c": 20}}`, the new row will be
                 * `{"id": "foo", "input": {"b": 11, "c": 20}}`
                 */
                @JsonProperty("_is_merge")
                @ExcludeMissing
                fun _isMerge(_isMerge: JsonField<Boolean>) = apply {
                    this._isMerge = _isMerge
                }

                /**
                 * The `_merge_paths` field allows controlling the depth of the merge. It can only
                 * be specified alongside `_is_merge=true`. `_merge_paths` is a list of paths,
                 * where each path is a list of field names. The deep merge will not descend below
                 * any of the specified merge paths.
                 *
                 * For example, say there is an existing row in the DB
                 * `{"id": "foo", "input": {"a": {"b": 10}, "c": {"d": 20}}, "output": {"a": 20}}`.
                 * If we merge a new row as
                 * `{"_is_merge": true, "_merge_paths": [["input", "a"], ["output"]], "input": {"a": {"q": 30}, "c": {"e": 30}, "bar": "baz"}, "output": {"d": 40}}`,
                 * the new row will be
                 * `{"id": "foo": "input": {"a": {"q": 30}, "c": {"d": 20, "e": 30}, "bar": "baz"}, "output": {"d": 40}}`.
                 * In this case, due to the merge paths, we have replaced `input.a` and `output`,
                 * but have still deep-merged `input` and `input.c`.
                 */
                fun _mergePaths(_mergePaths: List<List<String>>) = _mergePaths(JsonField.of(_mergePaths))

                /**
                 * The `_merge_paths` field allows controlling the depth of the merge. It can only
                 * be specified alongside `_is_merge=true`. `_merge_paths` is a list of paths,
                 * where each path is a list of field names. The deep merge will not descend below
                 * any of the specified merge paths.
                 *
                 * For example, say there is an existing row in the DB
                 * `{"id": "foo", "input": {"a": {"b": 10}, "c": {"d": 20}}, "output": {"a": 20}}`.
                 * If we merge a new row as
                 * `{"_is_merge": true, "_merge_paths": [["input", "a"], ["output"]], "input": {"a": {"q": 30}, "c": {"e": 30}, "bar": "baz"}, "output": {"d": 40}}`,
                 * the new row will be
                 * `{"id": "foo": "input": {"a": {"q": 30}, "c": {"d": 20, "e": 30}, "bar": "baz"}, "output": {"d": 40}}`.
                 * In this case, due to the merge paths, we have replaced `input.a` and `output`,
                 * but have still deep-merged `input` and `input.c`.
                 */
                @JsonProperty("_merge_paths")
                @ExcludeMissing
                fun _mergePaths(_mergePaths: JsonField<List<List<String>>>) = apply {
                    this._mergePaths = _mergePaths
                }

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

                fun build(): InsertProjectLogsEventMerge = InsertProjectLogsEventMerge(
                    input,
                    output,
                    expected,
                    scores,
                    metadata,
                    tags.map { it.toUnmodifiable() },
                    metrics,
                    context,
                    spanAttributes,
                    id,
                    created,
                    _objectDelete,
                    _isMerge,
                    _mergePaths.map { it.toUnmodifiable() },
                    additionalProperties.toUnmodifiable(),
                )
            }

            /**
             * Context is additional information about the code that produced the project logs
             * event. It is essentially the textual counterpart to `metrics`. Use the
             * `caller_*` attributes to track the location in code which produced the project
             * logs event
             */
            @JsonDeserialize(builder = Context.Builder::class)
            @NoAutoDetect
            class Context private constructor(
              private val callerFunctionname: JsonField<String>,
              private val callerFilename: JsonField<String>,
              private val callerLineno: JsonField<Long>,
              private val additionalProperties: Map<String, JsonValue>,

            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                /** The function in code which created the project logs event */
                fun callerFunctionname(): String? = callerFunctionname.getNullable("caller_functionname")

                /** Name of the file in code where the project logs event was created */
                fun callerFilename(): String? = callerFilename.getNullable("caller_filename")

                /** Line of code where the project logs event was created */
                fun callerLineno(): Long? = callerLineno.getNullable("caller_lineno")

                /** The function in code which created the project logs event */
                @JsonProperty("caller_functionname")
                @ExcludeMissing
                fun _callerFunctionname() = callerFunctionname

                /** Name of the file in code where the project logs event was created */
                @JsonProperty("caller_filename")
                @ExcludeMissing
                fun _callerFilename() = callerFilename

                /** Line of code where the project logs event was created */
                @JsonProperty("caller_lineno")
                @ExcludeMissing
                fun _callerLineno() = callerLineno

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): Context = apply {
                    if (!validated) {
                      callerFunctionname()
                      callerFilename()
                      callerLineno()
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is Context &&
                      this.callerFunctionname == other.callerFunctionname &&
                      this.callerFilename == other.callerFilename &&
                      this.callerLineno == other.callerLineno &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(
                        callerFunctionname,
                        callerFilename,
                        callerLineno,
                        additionalProperties,
                    )
                  }
                  return hashCode
                }

                override fun toString() = "Context{callerFunctionname=$callerFunctionname, callerFilename=$callerFilename, callerLineno=$callerLineno, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var callerFunctionname: JsonField<String> = JsonMissing.of()
                    private var callerFilename: JsonField<String> = JsonMissing.of()
                    private var callerLineno: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(context: Context) = apply {
                        this.callerFunctionname = context.callerFunctionname
                        this.callerFilename = context.callerFilename
                        this.callerLineno = context.callerLineno
                        additionalProperties(context.additionalProperties)
                    }

                    /** The function in code which created the project logs event */
                    fun callerFunctionname(callerFunctionname: String) = callerFunctionname(JsonField.of(callerFunctionname))

                    /** The function in code which created the project logs event */
                    @JsonProperty("caller_functionname")
                    @ExcludeMissing
                    fun callerFunctionname(callerFunctionname: JsonField<String>) = apply {
                        this.callerFunctionname = callerFunctionname
                    }

                    /** Name of the file in code where the project logs event was created */
                    fun callerFilename(callerFilename: String) = callerFilename(JsonField.of(callerFilename))

                    /** Name of the file in code where the project logs event was created */
                    @JsonProperty("caller_filename")
                    @ExcludeMissing
                    fun callerFilename(callerFilename: JsonField<String>) = apply {
                        this.callerFilename = callerFilename
                    }

                    /** Line of code where the project logs event was created */
                    fun callerLineno(callerLineno: Long) = callerLineno(JsonField.of(callerLineno))

                    /** Line of code where the project logs event was created */
                    @JsonProperty("caller_lineno")
                    @ExcludeMissing
                    fun callerLineno(callerLineno: JsonField<Long>) = apply {
                        this.callerLineno = callerLineno
                    }

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

                    fun build(): Context = Context(
                        callerFunctionname,
                        callerFilename,
                        callerLineno,
                        additionalProperties.toUnmodifiable(),
                    )
                }
            }

            /**
             * A dictionary with additional data about the test example, model outputs, or just
             * about anything else that's relevant, that you can use to help find and analyze
             * examples later. For example, you could log the `prompt`, example's `id`, or
             * anything else that would be useful to slice/dice later. The values in `metadata`
             * can be any JSON-serializable type, but its keys must be strings
             */
            @JsonDeserialize(builder = Metadata.Builder::class)
            @NoAutoDetect
            class Metadata private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): Metadata = apply {
                    if (!validated) {
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is Metadata &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(additionalProperties)
                  }
                  return hashCode
                }

                override fun toString() = "Metadata{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(metadata: Metadata) = apply {
                        additionalProperties(metadata.additionalProperties)
                    }

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

                    fun build(): Metadata = Metadata(additionalProperties.toUnmodifiable())
                }
            }

            /**
             * Metrics are numerical measurements tracking the execution of the code that
             * produced the project logs event. Use "start" and "end" to track the time span
             * over which the project logs event was produced
             */
            @JsonDeserialize(builder = Metrics.Builder::class)
            @NoAutoDetect
            class Metrics private constructor(
              private val start: JsonField<Double>,
              private val end: JsonField<Double>,
              private val promptTokens: JsonField<Long>,
              private val completionTokens: JsonField<Long>,
              private val tokens: JsonField<Long>,
              private val additionalProperties: Map<String, JsonValue>,

            ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                /**
                 * A unix timestamp recording when the section of code which produced the project
                 * logs event started
                 */
                fun start(): Double? = start.getNullable("start")

                /**
                 * A unix timestamp recording when the section of code which produced the project
                 * logs event finished
                 */
                fun end(): Double? = end.getNullable("end")

                /**
                 * The number of tokens in the prompt used to generate the project logs event (only
                 * set if this is an LLM span)
                 */
                fun promptTokens(): Long? = promptTokens.getNullable("prompt_tokens")

                /**
                 * The number of tokens in the completion generated by the model (only set if this
                 * is an LLM span)
                 */
                fun completionTokens(): Long? = completionTokens.getNullable("completion_tokens")

                /** The total number of tokens in the input and output of the project logs event. */
                fun tokens(): Long? = tokens.getNullable("tokens")

                /**
                 * A unix timestamp recording when the section of code which produced the project
                 * logs event started
                 */
                @JsonProperty("start")
                @ExcludeMissing
                fun _start() = start

                /**
                 * A unix timestamp recording when the section of code which produced the project
                 * logs event finished
                 */
                @JsonProperty("end")
                @ExcludeMissing
                fun _end() = end

                /**
                 * The number of tokens in the prompt used to generate the project logs event (only
                 * set if this is an LLM span)
                 */
                @JsonProperty("prompt_tokens")
                @ExcludeMissing
                fun _promptTokens() = promptTokens

                /**
                 * The number of tokens in the completion generated by the model (only set if this
                 * is an LLM span)
                 */
                @JsonProperty("completion_tokens")
                @ExcludeMissing
                fun _completionTokens() = completionTokens

                /** The total number of tokens in the input and output of the project logs event. */
                @JsonProperty("tokens")
                @ExcludeMissing
                fun _tokens() = tokens

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): Metrics = apply {
                    if (!validated) {
                      start()
                      end()
                      promptTokens()
                      completionTokens()
                      tokens()
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is Metrics &&
                      this.start == other.start &&
                      this.end == other.end &&
                      this.promptTokens == other.promptTokens &&
                      this.completionTokens == other.completionTokens &&
                      this.tokens == other.tokens &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(
                        start,
                        end,
                        promptTokens,
                        completionTokens,
                        tokens,
                        additionalProperties,
                    )
                  }
                  return hashCode
                }

                override fun toString() = "Metrics{start=$start, end=$end, promptTokens=$promptTokens, completionTokens=$completionTokens, tokens=$tokens, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var start: JsonField<Double> = JsonMissing.of()
                    private var end: JsonField<Double> = JsonMissing.of()
                    private var promptTokens: JsonField<Long> = JsonMissing.of()
                    private var completionTokens: JsonField<Long> = JsonMissing.of()
                    private var tokens: JsonField<Long> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(metrics: Metrics) = apply {
                        this.start = metrics.start
                        this.end = metrics.end
                        this.promptTokens = metrics.promptTokens
                        this.completionTokens = metrics.completionTokens
                        this.tokens = metrics.tokens
                        additionalProperties(metrics.additionalProperties)
                    }

                    /**
                     * A unix timestamp recording when the section of code which produced the project
                     * logs event started
                     */
                    fun start(start: Double) = start(JsonField.of(start))

                    /**
                     * A unix timestamp recording when the section of code which produced the project
                     * logs event started
                     */
                    @JsonProperty("start")
                    @ExcludeMissing
                    fun start(start: JsonField<Double>) = apply {
                        this.start = start
                    }

                    /**
                     * A unix timestamp recording when the section of code which produced the project
                     * logs event finished
                     */
                    fun end(end: Double) = end(JsonField.of(end))

                    /**
                     * A unix timestamp recording when the section of code which produced the project
                     * logs event finished
                     */
                    @JsonProperty("end")
                    @ExcludeMissing
                    fun end(end: JsonField<Double>) = apply {
                        this.end = end
                    }

                    /**
                     * The number of tokens in the prompt used to generate the project logs event (only
                     * set if this is an LLM span)
                     */
                    fun promptTokens(promptTokens: Long) = promptTokens(JsonField.of(promptTokens))

                    /**
                     * The number of tokens in the prompt used to generate the project logs event (only
                     * set if this is an LLM span)
                     */
                    @JsonProperty("prompt_tokens")
                    @ExcludeMissing
                    fun promptTokens(promptTokens: JsonField<Long>) = apply {
                        this.promptTokens = promptTokens
                    }

                    /**
                     * The number of tokens in the completion generated by the model (only set if this
                     * is an LLM span)
                     */
                    fun completionTokens(completionTokens: Long) = completionTokens(JsonField.of(completionTokens))

                    /**
                     * The number of tokens in the completion generated by the model (only set if this
                     * is an LLM span)
                     */
                    @JsonProperty("completion_tokens")
                    @ExcludeMissing
                    fun completionTokens(completionTokens: JsonField<Long>) = apply {
                        this.completionTokens = completionTokens
                    }

                    /** The total number of tokens in the input and output of the project logs event. */
                    fun tokens(tokens: Long) = tokens(JsonField.of(tokens))

                    /** The total number of tokens in the input and output of the project logs event. */
                    @JsonProperty("tokens")
                    @ExcludeMissing
                    fun tokens(tokens: JsonField<Long>) = apply {
                        this.tokens = tokens
                    }

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

                    fun build(): Metrics = Metrics(
                        start,
                        end,
                        promptTokens,
                        completionTokens,
                        tokens,
                        additionalProperties.toUnmodifiable(),
                    )
                }
            }

            /**
             * A dictionary of numeric values (between 0 and 1) to log. The scores should give
             * you a variety of signals that help you determine how accurate the outputs are
             * compared to what you expect and diagnose failures. For example, a summarization
             * app might have one score that tells you how accurate the summary is, and another
             * that measures the word similarity between the generated and grouth truth
             * summary. The word similarity score could help you determine whether the
             * summarization was covering similar concepts or not. You can use these scores to
             * help you sort, filter, and compare logs.
             */
            @JsonDeserialize(builder = Scores.Builder::class)
            @NoAutoDetect
            class Scores private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): Scores = apply {
                    if (!validated) {
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is Scores &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(additionalProperties)
                  }
                  return hashCode
                }

                override fun toString() = "Scores{additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(scores: Scores) = apply {
                        additionalProperties(scores.additionalProperties)
                    }

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

                    fun build(): Scores = Scores(additionalProperties.toUnmodifiable())
                }
            }

            /** Human-identifying attributes of the span, such as name, type, etc. */
            @JsonDeserialize(builder = SpanAttributes.Builder::class)
            @NoAutoDetect
            class SpanAttributes private constructor(private val name: JsonField<String>, private val type: JsonField<Type>, private val additionalProperties: Map<String, JsonValue>, ) {

                private var validated: Boolean = false

                private var hashCode: Int = 0

                /** Name of the span, for display purposes only */
                fun name(): String? = name.getNullable("name")

                /** Type of the span, for display purposes only */
                fun type(): Type? = type.getNullable("type")

                /** Name of the span, for display purposes only */
                @JsonProperty("name")
                @ExcludeMissing
                fun _name() = name

                /** Type of the span, for display purposes only */
                @JsonProperty("type")
                @ExcludeMissing
                fun _type() = type

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun validate(): SpanAttributes = apply {
                    if (!validated) {
                      name()
                      type()
                      validated = true
                    }
                }

                fun toBuilder() = Builder().from(this)

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return other is SpanAttributes &&
                      this.name == other.name &&
                      this.type == other.type &&
                      this.additionalProperties == other.additionalProperties
                }

                override fun hashCode(): Int {
                  if (hashCode == 0) {
                    hashCode = Objects.hash(
                        name,
                        type,
                        additionalProperties,
                    )
                  }
                  return hashCode
                }

                override fun toString() = "SpanAttributes{name=$name, type=$type, additionalProperties=$additionalProperties}"

                companion object {

                    fun builder() = Builder()
                }

                class Builder {

                    private var name: JsonField<String> = JsonMissing.of()
                    private var type: JsonField<Type> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    internal fun from(spanAttributes: SpanAttributes) = apply {
                        this.name = spanAttributes.name
                        this.type = spanAttributes.type
                        additionalProperties(spanAttributes.additionalProperties)
                    }

                    /** Name of the span, for display purposes only */
                    fun name(name: String) = name(JsonField.of(name))

                    /** Name of the span, for display purposes only */
                    @JsonProperty("name")
                    @ExcludeMissing
                    fun name(name: JsonField<String>) = apply {
                        this.name = name
                    }

                    /** Type of the span, for display purposes only */
                    fun type(type: Type) = type(JsonField.of(type))

                    /** Type of the span, for display purposes only */
                    @JsonProperty("type")
                    @ExcludeMissing
                    fun type(type: JsonField<Type>) = apply {
                        this.type = type
                    }

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

                    fun build(): SpanAttributes = SpanAttributes(
                        name,
                        type,
                        additionalProperties.toUnmodifiable(),
                    )
                }

                class Type @JsonCreator private constructor(private val value: JsonField<String>, ) : Enum {

                    @com.fasterxml.jackson.annotation.JsonValue
                    fun _value(): JsonField<String> = value

                    override fun equals(other: Any?): Boolean {
                      if (this === other) {
                          return true
                      }

                      return other is Type &&
                          this.value == other.value
                    }

                    override fun hashCode() = value.hashCode()

                    override fun toString() = value.toString()

                    companion object {

                        val LLM = Type(JsonField.of("llm"))

                        val SCORE = Type(JsonField.of("score"))

                        val FUNCTION = Type(JsonField.of("function"))

                        val EVAL = Type(JsonField.of("eval"))

                        val TASK = Type(JsonField.of("task"))

                        val TOOL = Type(JsonField.of("tool"))

                        fun of(value: String) = Type(JsonField.of(value))
                    }

                    enum class Known {
                        LLM,
                        SCORE,
                        FUNCTION,
                        EVAL,
                        TASK,
                        TOOL,
                    }

                    enum class Value {
                        LLM,
                        SCORE,
                        FUNCTION,
                        EVAL,
                        TASK,
                        TOOL,
                        _UNKNOWN,
                    }

                    fun value(): Value = when (this) {
                        LLM -> Value.LLM
                        SCORE -> Value.SCORE
                        FUNCTION -> Value.FUNCTION
                        EVAL -> Value.EVAL
                        TASK -> Value.TASK
                        TOOL -> Value.TOOL
                        else -> Value._UNKNOWN
                    }

                    fun known(): Known = when (this) {
                        LLM -> Known.LLM
                        SCORE -> Known.SCORE
                        FUNCTION -> Known.FUNCTION
                        EVAL -> Known.EVAL
                        TASK -> Known.TASK
                        TOOL -> Known.TOOL
                        else -> throw BraintrustInvalidDataException("Unknown Type: $value")
                    }

                    fun asString(): String = _value().asStringOrThrow()
                }
            }
        }
    }
}
