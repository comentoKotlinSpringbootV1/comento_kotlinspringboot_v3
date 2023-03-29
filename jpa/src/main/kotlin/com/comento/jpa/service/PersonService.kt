package com.comento.jpa.service

import com.comento.jpa.dto.PersonDto
import com.comento.jpa.dto.PersonResultDto

interface PersonService {
    fun createOrChangePersons(personList: List<PersonDto>): PersonResultDto
}
