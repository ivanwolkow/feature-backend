package com.featurebackend.model.dto

import java.time.Instant

data class FeatureResponse(
    var id: String?,
    var timestamp: Instant?,
    var beginViewingDate: Instant?,
    var endViewingDate: Instant?,
    var missionName: String?
)
