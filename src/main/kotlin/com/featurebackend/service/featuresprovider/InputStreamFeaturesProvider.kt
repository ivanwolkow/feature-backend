package com.featurebackend.service.featuresprovider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.featurebackend.model.feature.Feature
import com.featurebackend.model.feature.FeatureCollection
import org.slf4j.LoggerFactory
import org.springframework.core.io.InputStreamSource
import org.springframework.stereotype.Service

/**
 * Fetches all features from the input stream
 */
@Service
class InputStreamFeaturesProvider(
    objectMapper: ObjectMapper,
    featuresInputStreamSource: InputStreamSource
) : FeaturesProvider {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private lateinit var features: Map<String, Feature>

    init {
        logger.info("Fetching features ...")

        val inputStream = featuresInputStreamSource.inputStream

        this.features = objectMapper.readValue<List<FeatureCollection>>(inputStream)
            .flatMap { it.features }
            .mapNotNull { f -> f.properties?.id?.let { Pair(f.properties?.id!!, f) } }
            .toMap()

        logger.info("Fetched ${features.size} features")
    }

    override fun getFeatures(): Map<String, Feature> = this.features
}
