package com.comento.jpa.advice

import org.h2.api.ErrorCode
import org.springframework.http.HttpStatus

open class ExceptionResult(
    val code: ErrorCode? = null,
    message: String,
    val status: HttpStatus,
) : RuntimeException(message)
