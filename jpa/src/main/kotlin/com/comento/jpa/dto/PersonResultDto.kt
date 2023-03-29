package com.comento.jpa.dto

import com.comento.jpa.enums.PersonResultType

data class PersonResultDto(
    val resultType: List<PersonResultType>,
    val personIds: List<Int>,
)
