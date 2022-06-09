package com.featurebackend.service

import com.featurebackend.exception.FeatureNotFoundException
import com.featurebackend.model.dto.FeatureResponse
import com.featurebackend.model.feature.Feature
import com.featurebackend.service.featuresprovider.FeaturesProvider
import org.springframework.stereotype.Service
import java.util.Base64

@Service
class FeaturesService(val featuresProvider: FeaturesProvider) {

    fun getQuickLookById(id: String): ByteArray {
        val feature = featuresProvider.getFeatures()[id] ?: throw FeatureNotFoundException()
        return feature.properties?.quicklook.let { Base64.getDecoder().decode(it) }
    }

    fun getFeatures(): List<FeatureResponse> =
        featuresProvider.getFeatures().values
            .map { mapToResponse(it) }
            .toList()

    private fun mapToResponse(feature: Feature) = FeatureResponse(
        feature.properties?.id,
        feature.properties?.timestamp,
        feature.properties?.acquisition?.beginViewingDate,
        feature.properties?.acquisition?.endViewingDate,
        feature.properties?.acquisition?.missionName
    )
}
