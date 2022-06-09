package com.featurebackend.model.feature

import java.time.Instant

data class Acquisition(
    var beginViewingDate: Instant?,
    var endViewingDate: Instant?,
    var missionName: String?
)
