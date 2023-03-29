package com.comento.jpa.advice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler
    fun exceptionHandler(e: ExceptionResult) =
        ResponseEntity(
            ExceptionResult(
                code = e.code,
                message = e.message.toString(),
                status=e.status
            ),
            e.status,
        )

}
