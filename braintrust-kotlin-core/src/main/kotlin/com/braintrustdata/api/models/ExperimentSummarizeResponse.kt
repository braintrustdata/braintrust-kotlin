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

/** Summary of an experiment */
@JsonDeserialize(builder = ExperimentSummarizeResponse.Builder::class)
@NoAutoDetect
class ExperimentSummarizeResponse private constructor(
  private val projectName: JsonField<String>,
  private val experimentName: JsonField<String>,
  private val projectUrl: JsonField<String>,
  private val experimentUrl: JsonField<String>,
  private val comparisonExperimentName: JsonField<String>,
  private val scores: JsonField<Scores>,
  private val metrics: JsonField<Metrics>,
  private val additionalProperties: Map<String, JsonValue>,

) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Name of the project that the experiment belongs to */
    fun projectName(): String = projectName.getRequired("project_name")

    /** Name of the experiment */
    fun experimentName(): String = experimentName.getRequired("experiment_name")

    /** URL to the project's page in the Braintrust app */
    fun projectUrl(): String = projectUrl.getRequired("project_url")

    /** URL to the experiment's page in the Braintrust app */
    fun experimentUrl(): String = experimentUrl.getRequired("experiment_url")

    /** The experiment which scores are baselined against */
    fun comparisonExperimentName(): String? = comparisonExperimentName.getNullable("comparison_experiment_name")

    /** Summary of the experiment's scores */
    fun scores(): Scores? = scores.getNullable("scores")

    /** Summary of the experiment's metrics */
    fun metrics(): Metrics? = metrics.getNullable("metrics")

    /** Name of the project that the experiment belongs to */
    @JsonProperty("project_name")
    @ExcludeMissing
    fun _projectName() = projectName

    /** Name of the experiment */
    @JsonProperty("experiment_name")
    @ExcludeMissing
    fun _experimentName() = experimentName

    /** URL to the project's page in the Braintrust app */
    @JsonProperty("project_url")
    @ExcludeMissing
    fun _projectUrl() = projectUrl

    /** URL to the experiment's page in the Braintrust app */
    @JsonProperty("experiment_url")
    @ExcludeMissing
    fun _experimentUrl() = experimentUrl

    /** The experiment which scores are baselined against */
    @JsonProperty("comparison_experiment_name")
    @ExcludeMissing
    fun _comparisonExperimentName() = comparisonExperimentName

    /** Summary of the experiment's scores */
    @JsonProperty("scores")
    @ExcludeMissing
    fun _scores() = scores

    /** Summary of the experiment's metrics */
    @JsonProperty("metrics")
    @ExcludeMissing
    fun _metrics() = metrics

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ExperimentSummarizeResponse = apply {
        if (!validated) {
          projectName()
          experimentName()
          projectUrl()
          experimentUrl()
          comparisonExperimentName()
          scores()?.validate()
          metrics()?.validate()
          validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return other is ExperimentSummarizeResponse &&
          this.projectName == other.projectName &&
          this.experimentName == other.experimentName &&
          this.projectUrl == other.projectUrl &&
          this.experimentUrl == other.experimentUrl &&
          this.comparisonExperimentName == other.comparisonExperimentName &&
          this.scores == other.scores &&
          this.metrics == other.metrics &&
          this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
      if (hashCode == 0) {
        hashCode = Objects.hash(
            projectName,
            experimentName,
            projectUrl,
            experimentUrl,
            comparisonExperimentName,
            scores,
            metrics,
            additionalProperties,
        )
      }
      return hashCode
    }

    override fun toString() = "ExperimentSummarizeResponse{projectName=$projectName, experimentName=$experimentName, projectUrl=$projectUrl, experimentUrl=$experimentUrl, comparisonExperimentName=$comparisonExperimentName, scores=$scores, metrics=$metrics, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var projectName: JsonField<String> = JsonMissing.of()
        private var experimentName: JsonField<String> = JsonMissing.of()
        private var projectUrl: JsonField<String> = JsonMissing.of()
        private var experimentUrl: JsonField<String> = JsonMissing.of()
        private var comparisonExperimentName: JsonField<String> = JsonMissing.of()
        private var scores: JsonField<Scores> = JsonMissing.of()
        private var metrics: JsonField<Metrics> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(experimentSummarizeResponse: ExperimentSummarizeResponse) = apply {
            this.projectName = experimentSummarizeResponse.projectName
            this.experimentName = experimentSummarizeResponse.experimentName
            this.projectUrl = experimentSummarizeResponse.projectUrl
            this.experimentUrl = experimentSummarizeResponse.experimentUrl
            this.comparisonExperimentName = experimentSummarizeResponse.comparisonExperimentName
            this.scores = experimentSummarizeResponse.scores
            this.metrics = experimentSummarizeResponse.metrics
            additionalProperties(experimentSummarizeResponse.additionalProperties)
        }

        /** Name of the project that the experiment belongs to */
        fun projectName(projectName: String) = projectName(JsonField.of(projectName))

        /** Name of the project that the experiment belongs to */
        @JsonProperty("project_name")
        @ExcludeMissing
        fun projectName(projectName: JsonField<String>) = apply {
            this.projectName = projectName
        }

        /** Name of the experiment */
        fun experimentName(experimentName: String) = experimentName(JsonField.of(experimentName))

        /** Name of the experiment */
        @JsonProperty("experiment_name")
        @ExcludeMissing
        fun experimentName(experimentName: JsonField<String>) = apply {
            this.experimentName = experimentName
        }

        /** URL to the project's page in the Braintrust app */
        fun projectUrl(projectUrl: String) = projectUrl(JsonField.of(projectUrl))

        /** URL to the project's page in the Braintrust app */
        @JsonProperty("project_url")
        @ExcludeMissing
        fun projectUrl(projectUrl: JsonField<String>) = apply {
            this.projectUrl = projectUrl
        }

        /** URL to the experiment's page in the Braintrust app */
        fun experimentUrl(experimentUrl: String) = experimentUrl(JsonField.of(experimentUrl))

        /** URL to the experiment's page in the Braintrust app */
        @JsonProperty("experiment_url")
        @ExcludeMissing
        fun experimentUrl(experimentUrl: JsonField<String>) = apply {
            this.experimentUrl = experimentUrl
        }

        /** The experiment which scores are baselined against */
        fun comparisonExperimentName(comparisonExperimentName: String) = comparisonExperimentName(JsonField.of(comparisonExperimentName))

        /** The experiment which scores are baselined against */
        @JsonProperty("comparison_experiment_name")
        @ExcludeMissing
        fun comparisonExperimentName(comparisonExperimentName: JsonField<String>) = apply {
            this.comparisonExperimentName = comparisonExperimentName
        }

        /** Summary of the experiment's scores */
        fun scores(scores: Scores) = scores(JsonField.of(scores))

        /** Summary of the experiment's scores */
        @JsonProperty("scores")
        @ExcludeMissing
        fun scores(scores: JsonField<Scores>) = apply {
            this.scores = scores
        }

        /** Summary of the experiment's metrics */
        fun metrics(metrics: Metrics) = metrics(JsonField.of(metrics))

        /** Summary of the experiment's metrics */
        @JsonProperty("metrics")
        @ExcludeMissing
        fun metrics(metrics: JsonField<Metrics>) = apply {
            this.metrics = metrics
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

        fun build(): ExperimentSummarizeResponse = ExperimentSummarizeResponse(
            projectName,
            experimentName,
            projectUrl,
            experimentUrl,
            comparisonExperimentName,
            scores,
            metrics,
            additionalProperties.toUnmodifiable(),
        )
    }

    /** Summary of the experiment's metrics */
    @JsonDeserialize(builder = Metrics.Builder::class)
    @NoAutoDetect
    class Metrics private constructor(private val additionalProperties: Map<String, JsonValue>, ) {

        private var validated: Boolean = false

        private var hashCode: Int = 0

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Metrics = apply {
            if (!validated) {
              validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return other is Metrics &&
              this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
          if (hashCode == 0) {
            hashCode = Objects.hash(additionalProperties)
          }
          return hashCode
        }

        override fun toString() = "Metrics{additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(metrics: Metrics) = apply {
                additionalProperties(metrics.additionalProperties)
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

            fun build(): Metrics = Metrics(additionalProperties.toUnmodifiable())
        }
    }

    /** Summary of the experiment's scores */
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
}
