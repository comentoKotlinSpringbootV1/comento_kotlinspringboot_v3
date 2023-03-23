package com.comento.dbless.person.presentation

import com.comento.dbless.person.domain.Person
import com.comento.dbless.person.dto.FilterRequestDto
import com.comento.dbless.person.dto.SortRequestDto
import com.comento.dbless.person.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/persons")
class PersonController(
    private val personService: PersonService
) {
    @PostMapping("/sort")
    fun sortPersons(@RequestBody sortRequestDto: SortRequestDto): List<Person> {
        try {
            val (persons, sortBy, sortOrder) = sortRequestDto

            personService.validatePersons(persons)

            return personService.sortPersons(persons, sortBy, sortOrder)
        } catch (e: IllegalArgumentException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message)
        }
    }

    @PostMapping("/filter")
    fun filterPersons(@RequestBody filterRequestDto: FilterRequestDto): List<Person> {
        try {
            val (persons, ageCutoff, heightCutoff, except) = filterRequestDto

            personService.validatePersons(persons)

            return personService.filterPersons(
                persons, ageCutoff, heightCutoff, except
            )
        } catch (e: IllegalArgumentException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message)
        }
    }
}
