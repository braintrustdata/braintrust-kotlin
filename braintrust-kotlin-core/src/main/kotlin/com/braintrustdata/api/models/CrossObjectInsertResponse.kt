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
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.JsonNull
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.Enum
import com.braintrustdata.api.core.toUnmodifiable
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.errors.BraintrustInvalidDataException

@JsonDeserialize(builder = CrossObjectInsertResponse.Builder::class)
@NoAutoDetect
class CrossObjectInsertResponse private constructor(
  private val experiment: JsonField<Experiment>,
  private val dataset: JsonField<Dataset>,
  private val projectLogs: JsonField<ProjectLogs>,
  private val additionalProperties: Map<String, JsonValue>,

) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** A mapping from experiment id to row ids for inserted `events` */
    fun experiment(): Experiment? = experiment.getNullable("experiment")

    /** A mapping from dataset id to row ids for inserted `events` */
    fun dataset(): Dataset? = dataset.getNullable("dataset")

    /** A mapping from project id to row ids for inserted `events` */
    fun projectLogs(): ProjectLogs? = projectLogs.getNullable("project_logs")

    /** A mapping from experiment id to row ids for inserted `events` */
    @JsonProperty("experiment")
    @ExcludeMissing
    fun _experiment() = experiment

    /** A mapping from dataset id to row ids for inserted `events` */
    @JsonProperty("dataset")
    @ExcludeMissing
    fun _dataset() = dataset

    /** A mapping from project id to row ids for inserted `events` */
    @JsonProperty("project_logs")
    @ExcludeMissing
    fun _projectLogs() = projectLogs

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): CrossObjectInsertResponse = apply {
        if (!validated) {
          experiment()?.validate()
          dataset()?.validate()
          projectLogs()?.validate()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is CrossObjectInsertResponse &&
          this.experiment == other.experiment &&
          this.dataset == other.dataset &&
          this.projectLogs == other.projectLogs &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            experiment,
            dataset,
            projectLogs,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "CrossObjectInsertResponse{experiment=$experiment, dataset=$dataset, projectLogs=$projectLogs, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var experiment: JsonField<Experiment> = JsonMissing.of()
        private var dataset: JsonField<Dataset> = JsonMissing.of()
        private var projectLogs: JsonField<ProjectLogs> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(crossObjectInsertResponse: CrossObjectInsertResponse) = apply {
            this.experiment = crossObjectInsertResponse.experiment
            this.dataset = crossObjectInsertResponse.dataset
            this.projectLogs = crossObjectInsertResponse.projectLogs
            additionalProperties(crossObjectInsertResponse.additionalProperties)
        }

        /** A mapping from experiment id to row ids for inserted `events` */
        fun experiment(experiment: Experiment) = experiment(JsonField.of(experiment))

        /** A mapping from experiment id to row ids for inserted `events` */
        @JsonProperty("experiment")
        @ExcludeMissing
        fun experiment(experiment: JsonField<Experiment>) = apply {
            this.experiment = experiment
        }

        /** A mapping from dataset id to row ids for inserted `events` */
        fun dataset(dataset: Dataset) = dataset(JsonField.of(dataset))

        /** A mapping from dataset id to row ids for inserted `events` */
        @JsonProperty("dataset")
        @ExcludeMissing
        fun dataset(dataset: JsonField<Dataset>) = apply {
            this.dataset = dataset
        }

        /** A mapping from project id to row ids for inserted `events` */
        fun projectLogs(projectLogs: ProjectLogs) = projectLogs(JsonField.of(projectLogs))

        /** A mapping from project id to row ids for inserted `events` */
        @JsonProperty("project_logs")
        @ExcludeMissing
        fun projectLogs(projectLogs: JsonField<ProjectLogs>) = apply {
            this.projectLogs = projectLogs
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

        fun build(): CrossObjectInsertResponse = CrossObjectInsertResponse(
            experiment,
            dataset,
            projectLogs,
            additionalProperties.toUnmodifiable(),
        )
    }

    /** A mapping from dataset id to row ids for inserted `events` */
    @JsonDeserialize(builder = Dataset.Builder::class)
    @NoAutoDetect
    class Dataset private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Dataset = apply {
            if (!validated) {
              validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Dataset &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(additionalProperties)
          }
          return hashCode
        }

        override fun toString() = "Dataset{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(dataset: Dataset) = apply {
                additionalProperties(dataset.additionalProperties)
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

            fun build(): Dataset = Dataset(additionalProperties.toUnmodifiable())
        }
    }

    /** A mapping from experiment id to row ids for inserted `events` */
    @JsonDeserialize(builder = Experiment.Builder::class)
    @NoAutoDetect
    class Experiment private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Experiment = apply {
            if (!validated) {
              validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Experiment &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(additionalProperties)
          }
          return hashCode
        }

        override fun toString() = "Experiment{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(experiment: Experiment) = apply {
                additionalProperties(experiment.additionalProperties)
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

            fun build(): Experiment = Experiment(additionalProperties.toUnmodifiable())
        }
    }

    /** A mapping from project id to row ids for inserted `events` */
    @JsonDeserialize(builder = ProjectLogs.Builder::class)
    @NoAutoDetect
    class ProjectLogs private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): ProjectLogs = apply {
            if (!validated) {
              validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is ProjectLogs &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(additionalProperties)
          }
          return hashCode
        }

        override fun toString() = "ProjectLogs{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(projectLogs: ProjectLogs) = apply {
                additionalProperties(projectLogs.additionalProperties)
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

            fun build(): ProjectLogs = ProjectLogs(additionalProperties.toUnmodifiable())
        }
    }
}
