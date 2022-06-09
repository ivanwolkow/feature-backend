package com.featurebackend.config

import com.featurebackend.properties.FeaturesProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.InputStreamSource

@Configuration
class FeaturesConfiguration {

    @Bean
    fun featuresInputStreamSource(featuresProperties: FeaturesProperties): InputStreamSource =
        ClassPathResource(featuresProperties.staticPath)
}
