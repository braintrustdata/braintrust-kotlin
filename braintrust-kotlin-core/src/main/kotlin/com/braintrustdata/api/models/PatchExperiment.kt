// File generated from our OpenAPI spec by Stainless.

package com.braintrustdata.api.models

import com.braintrustdata.api.core.ExcludeMissing
import com.braintrustdata.api.core.JsonField
import com.braintrustdata.api.core.JsonMissing
import com.braintrustdata.api.core.JsonValue
import com.braintrustdata.api.core.NoAutoDetect
import com.braintrustdata.api.core.toUnmodifiable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects

@JsonDeserialize(builder = PatchExperiment.Builder::class)
@NoAutoDetect
class PatchExperiment
private constructor(
    private val name: JsonField<String>,
    private val description: JsonField<String>,
    private val repoInfo: JsonField<RepoInfo>,
    private val baseExpId: JsonField<String>,
    private val datasetId: JsonField<String>,
    private val datasetVersion: JsonField<String>,
    private val public_: JsonField<Boolean>,
    private val metadata: JsonField<Metadata>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** Name of the experiment. Within a project, experiment names are unique */
    fun name(): String? = name.getNullable("name")

    /** Textual description of the experiment */
    fun description(): String? = description.getNullable("description")

    /** Metadata about the state of the repo when the experiment was created */
    fun repoInfo(): RepoInfo? = repoInfo.getNullable("repo_info")

    /** Id of default base experiment to compare against when viewing this experiment */
    fun baseExpId(): String? = baseExpId.getNullable("base_exp_id")

    /** Identifier of the linked dataset, or null if the experiment is not linked to a dataset */
    fun datasetId(): String? = datasetId.getNullable("dataset_id")

    /**
     * Version number of the linked dataset the experiment was run against. This can be used to
     * reproduce the experiment after the dataset has been modified.
     */
    fun datasetVersion(): String? = datasetVersion.getNullable("dataset_version")

    /**
     * Whether or not the experiment is public. Public experiments can be viewed by anybody inside
     * or outside the organization
     */
    fun public_(): Boolean? = public_.getNullable("public")

    /** User-controlled metadata about the experiment */
    fun metadata(): Metadata? = metadata.getNullable("metadata")

    /** Name of the experiment. Within a project, experiment names are unique */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    /** Textual description of the experiment */
    @JsonProperty("description") @ExcludeMissing fun _description() = description

    /** Metadata about the state of the repo when the experiment was created */
    @JsonProperty("repo_info") @ExcludeMissing fun _repoInfo() = repoInfo

    /** Id of default base experiment to compare against when viewing this experiment */
    @JsonProperty("base_exp_id") @ExcludeMissing fun _baseExpId() = baseExpId

    /** Identifier of the linked dataset, or null if the experiment is not linked to a dataset */
    @JsonProperty("dataset_id") @ExcludeMissing fun _datasetId() = datasetId

    /**
     * Version number of the linked dataset the experiment was run against. This can be used to
     * reproduce the experiment after the dataset has been modified.
     */
    @JsonProperty("dataset_version") @ExcludeMissing fun _datasetVersion() = datasetVersion

    /**
     * Whether or not the experiment is public. Public experiments can be viewed by anybody inside
     * or outside the organization
     */
    @JsonProperty("public") @ExcludeMissing fun _public_() = public_

    /** User-controlled metadata about the experiment */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata() = metadata

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): PatchExperiment = apply {
        if (!validated) {
            name()
            description()
            repoInfo()?.validate()
            baseExpId()
            datasetId()
            datasetVersion()
            public_()
            metadata()?.validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PatchExperiment &&
            this.name == other.name &&
            this.description == other.description &&
            this.repoInfo == other.repoInfo &&
            this.baseExpId == other.baseExpId &&
            this.datasetId == other.datasetId &&
            this.datasetVersion == other.datasetVersion &&
            this.public_ == other.public_ &&
            this.metadata == other.metadata &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    name,
                    description,
                    repoInfo,
                    baseExpId,
                    datasetId,
                    datasetVersion,
                    public_,
                    metadata,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "PatchExperiment{name=$name, description=$description, repoInfo=$repoInfo, baseExpId=$baseExpId, datasetId=$datasetId, datasetVersion=$datasetVersion, public_=$public_, metadata=$metadata, additionalProperties=$additionalProperties}"

    companion object {

        fun builder() = Builder()
    }

    class Builder {

        private var name: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var repoInfo: JsonField<RepoInfo> = JsonMissing.of()
        private var baseExpId: JsonField<String> = JsonMissing.of()
        private var datasetId: JsonField<String> = JsonMissing.of()
        private var datasetVersion: JsonField<String> = JsonMissing.of()
        private var public_: JsonField<Boolean> = JsonMissing.of()
        private var metadata: JsonField<Metadata> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(patchExperiment: PatchExperiment) = apply {
            this.name = patchExperiment.name
            this.description = patchExperiment.description
            this.repoInfo = patchExperiment.repoInfo
            this.baseExpId = patchExperiment.baseExpId
            this.datasetId = patchExperiment.datasetId
            this.datasetVersion = patchExperiment.datasetVersion
            this.public_ = patchExperiment.public_
            this.metadata = patchExperiment.metadata
            additionalProperties(patchExperiment.additionalProperties)
        }

        /** Name of the experiment. Within a project, experiment names are unique */
        fun name(name: String) = name(JsonField.of(name))

        /** Name of the experiment. Within a project, experiment names are unique */
        @JsonProperty("name")
        @ExcludeMissing
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Textual description of the experiment */
        fun description(description: String) = description(JsonField.of(description))

        /** Textual description of the experiment */
        @JsonProperty("description")
        @ExcludeMissing
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Metadata about the state of the repo when the experiment was created */
        fun repoInfo(repoInfo: RepoInfo) = repoInfo(JsonField.of(repoInfo))

        /** Metadata about the state of the repo when the experiment was created */
        @JsonProperty("repo_info")
        @ExcludeMissing
        fun repoInfo(repoInfo: JsonField<RepoInfo>) = apply { this.repoInfo = repoInfo }

        /** Id of default base experiment to compare against when viewing this experiment */
        fun baseExpId(baseExpId: String) = baseExpId(JsonField.of(baseExpId))

        /** Id of default base experiment to compare against when viewing this experiment */
        @JsonProperty("base_exp_id")
        @ExcludeMissing
        fun baseExpId(baseExpId: JsonField<String>) = apply { this.baseExpId = baseExpId }

        /**
         * Identifier of the linked dataset, or null if the experiment is not linked to a dataset
         */
        fun datasetId(datasetId: String) = datasetId(JsonField.of(datasetId))

        /**
         * Identifier of the linked dataset, or null if the experiment is not linked to a dataset
         */
        @JsonProperty("dataset_id")
        @ExcludeMissing
        fun datasetId(datasetId: JsonField<String>) = apply { this.datasetId = datasetId }

        /**
         * Version number of the linked dataset the experiment was run against. This can be used to
         * reproduce the experiment after the dataset has been modified.
         */
        fun datasetVersion(datasetVersion: String) = datasetVersion(JsonField.of(datasetVersion))

        /**
         * Version number of the linked dataset the experiment was run against. This can be used to
         * reproduce the experiment after the dataset has been modified.
         */
        @JsonProperty("dataset_version")
        @ExcludeMissing
        fun datasetVersion(datasetVersion: JsonField<String>) = apply {
            this.datasetVersion = datasetVersion
        }

        /**
         * Whether or not the experiment is public. Public experiments can be viewed by anybody
         * inside or outside the organization
         */
        fun public_(public_: Boolean) = public_(JsonField.of(public_))

        /**
         * Whether or not the experiment is public. Public experiments can be viewed by anybody
         * inside or outside the organization
         */
        @JsonProperty("public")
        @ExcludeMissing
        fun public_(public_: JsonField<Boolean>) = apply { this.public_ = public_ }

        /** User-controlled metadata about the experiment */
        fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

        /** User-controlled metadata about the experiment */
        @JsonProperty("metadata")
        @ExcludeMissing
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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

        fun build(): PatchExperiment =
            PatchExperiment(
                name,
                description,
                repoInfo,
                baseExpId,
                datasetId,
                datasetVersion,
                public_,
                metadata,
                additionalProperties.toUnmodifiable(),
            )
    }

    /** User-controlled metadata about the experiment */
    @JsonDeserialize(builder = Metadata.Builder::class)
    @NoAutoDetect
    class Metadata
    private constructor(
        private val additionalProperties: Map<String, JsonValue>,
    ) {

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

            return other is Metadata && this.additionalProperties == other.additionalProperties
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
}
