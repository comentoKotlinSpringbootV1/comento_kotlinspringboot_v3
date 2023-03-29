package com.comento.jpa.presentation

import com.comento.jpa.dto.PersonDto
import com.comento.jpa.dto.PersonResultDto
import com.comento.jpa.service.PersonService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/persons")
class PersonController (
    private val personService : PersonService
    ){
    @PutMapping
    fun createOrChangePersons(@RequestBody personList: List<PersonDto>): PersonResultDto {
        return personService.createOrChangePersons(personList)
    }
}
