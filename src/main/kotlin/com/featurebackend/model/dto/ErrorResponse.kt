package com.featurebackend.model.dto

/**
 * A unified error representation
 * May include fields like error id, error description etc
 * But let's keep it simple for now
 */
data class ErrorResponse(
    val message: String?
)
