package com.comento.dbless.person.dto

import com.comento.dbless.person.domain.Person

data class FilterRequestDto (
    val persons: List<Person>,
    val ageCutoff: Int?,
    val heightCutoff: Int?,
    val except: List<String>?
)
