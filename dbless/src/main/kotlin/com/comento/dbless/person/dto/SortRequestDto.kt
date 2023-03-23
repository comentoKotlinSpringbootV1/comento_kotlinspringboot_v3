package com.comento.dbless.person.dto

import com.comento.dbless.person.constant.SortOrder
import com.comento.dbless.person.domain.Person

data class SortRequestDto(
    val persons: List<Person>,
    val sortBy: String,
    val sortOrder: SortOrder
)
