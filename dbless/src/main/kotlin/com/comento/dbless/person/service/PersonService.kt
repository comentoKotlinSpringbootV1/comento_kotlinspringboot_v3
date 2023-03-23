package com.comento.dbless.person.service

import com.comento.dbless.person.constant.SortOrder
import com.comento.dbless.person.domain.Person

interface PersonService {
    fun validatePersons(persons: List<Person>)
    fun sortPersons(persons: List<Person>, sortBy: String, sortOrder: SortOrder): List<Person>
    fun filterPersons(persons: List<Person>, ageCutoff: Int?, heightCutoff: Int?, except: List<String>?): List<Person>
}
