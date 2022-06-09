package com.featurebackend.controller

import com.featurebackend.exception.FeatureNotFoundException
import com.featurebackend.model.dto.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(FeatureNotFoundException::class)
    fun handleFeatureNotFound(exception: FeatureNotFoundException): ResponseEntity<ErrorResponse> {
        logger.error(exception.message, exception)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ErrorResponse(exception.message))
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleInternalError(exception: RuntimeException): ResponseEntity<ErrorResponse> {
        logger.error(exception.message, exception)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase))
    }
}
