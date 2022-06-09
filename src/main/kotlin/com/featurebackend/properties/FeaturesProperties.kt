package com.featurebackend.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "features")
class FeaturesProperties {
    lateinit var staticPath: String
}
