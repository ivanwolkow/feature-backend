package com.featurebackend.service.featuresprovider

import com.featurebackend.model.feature.Feature

/**
 * Abstraction responsible for fetching the features
 */
interface FeaturesProvider {

    fun getFeatures(): Map<String, Feature>
}
