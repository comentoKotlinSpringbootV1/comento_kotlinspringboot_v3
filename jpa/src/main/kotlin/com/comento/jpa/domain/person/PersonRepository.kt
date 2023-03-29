package com.comento.jpa.domain.person

import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Int> {
    fun save(person: Person)
}
