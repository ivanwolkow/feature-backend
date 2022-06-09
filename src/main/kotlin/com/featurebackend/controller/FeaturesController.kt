package com.featurebackend.controller

import com.featurebackend.model.dto.FeatureResponse
import com.featurebackend.service.FeaturesService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/features")
class FeaturesController(
    val featuresService: FeaturesService
) {
    /**
     * Return all the features
     * @return list of features
     */
    @GetMapping
    fun getFeatures(): List<FeatureResponse> = featuresService.getFeatures()

    /**
     * Returns the quicklook for a feature
     * @param featureId uuid of a feature
     * @return quicklook binary content
     */
    @GetMapping("/{featureId}/quicklook", produces = [MediaType.IMAGE_PNG_VALUE])
    fun getQuickLookById(@PathVariable featureId: String) = featuresService.getQuickLookById(featureId)
}
