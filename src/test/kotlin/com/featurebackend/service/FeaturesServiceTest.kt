package com.featurebackend.service

import com.featurebackend.exception.FeatureNotFoundException
import com.featurebackend.model.feature.Feature
import com.featurebackend.model.feature.Properties
import com.featurebackend.service.featuresprovider.FeaturesProvider
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import java.time.Instant
import kotlin.text.Charsets.UTF_8

@ExtendWith(MockitoExtension::class)
internal class FeaturesServiceTest {

    @InjectMocks
    private lateinit var featuresService: FeaturesService

    @Mock
    private lateinit var featuresProvider: FeaturesProvider

    @BeforeEach
    internal fun setUp() {
        val now = Instant.now()
        val featuresResponse = mapOf(
            "1" to Feature(
                Properties(
                    id = "1",
                    timestamp = now,
                    acquisition = null,
                    quicklook = "dGVzdA=="
                )
            ),
            "3" to Feature(
                Properties(
                    id = "2",
                    timestamp = now,
                    acquisition = null,
                    quicklook = "corrupted data"
                )
            )
        )

        doReturn(featuresResponse).`when`(featuresProvider).getFeatures()
    }

    @Test
    internal fun `should return quicklook by id`() {
        val resultData = featuresService.getQuickLookById("1")
        val expectedData = "test".toByteArray(UTF_8)
        assertArrayEquals(expectedData, resultData)
    }

    @Test
    internal fun `should throw exception when feature is missing`() {
        assertThrows(FeatureNotFoundException::class.java) {
            featuresService.getQuickLookById("2")
        }
    }

    @Test
    internal fun `should throw exception when overlook data is corrupted`() {
        assertThrows(IllegalArgumentException::class.java) {
            featuresService.getQuickLookById("3")
        }
    }
}
