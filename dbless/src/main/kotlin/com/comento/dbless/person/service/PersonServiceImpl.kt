package com.comento.dbless.person.service

import com.comento.dbless.person.constant.SortOrder
import com.comento.dbless.person.domain.Person
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl : PersonService {
    override fun validatePersons(persons: List<Person>) {
        persons.forEach {
            it.validate()
        }
    }

    override fun sortPersons(persons: List<Person>, sortBy: String, sortOrder: SortOrder): List<Person> {
        val sortedPersons = when (sortBy) {
            "name" -> persons.sortedBy { it.name }
            "age" -> persons.sortedBy { it.age }
            "height" -> persons.sortedBy { it.height }
            else -> throw IllegalArgumentException("sortBy는 name, age, height 중 하나여야 합니다.")
        }

        return if (sortOrder == SortOrder.des) sortedPersons.reversed() else sortedPersons
    }
}
