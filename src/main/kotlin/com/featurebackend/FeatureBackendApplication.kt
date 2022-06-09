package com.featurebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class FeatureBackendApplication

fun main(args: Array<String>) {
    runApplication<FeatureBackendApplication>(*args)
}
