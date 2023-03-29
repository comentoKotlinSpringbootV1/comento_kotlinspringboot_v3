package com.comento.jpa.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class CompanyDto(
    val name: String,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val foundingDate: String,
    val country: String
) {
    constructor(name: String, foundingDate: LocalDateTime, country: String) : this(
        name,
        foundingDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
        country
    )
}
