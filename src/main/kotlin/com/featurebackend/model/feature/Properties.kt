package com.featurebackend.model.feature

import java.time.Instant

data class Properties(
    var id: String?,
    var timestamp: Instant?,
    var acquisition: Acquisition?,
    var quicklook: String?
)
