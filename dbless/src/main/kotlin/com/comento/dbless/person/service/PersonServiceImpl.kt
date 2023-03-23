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
        println("finish validate")
    }

    override fun sortPersons(persons: List<Person>, sortBy: String, sortOrder: String): List<Person> {
        val sortedPersons = when (sortBy) {
            "name" -> persons.sortedBy { it.name }
            "age" -> persons.sortedBy { it.age }
            "height" -> persons.sortedBy { it.height }
            else -> throw IllegalArgumentException("sortBy는 name, age, height 중 하나여야 합니다.")
        }

        return if (sortOrder == SortOrder.DES.lowerCase) sortedPersons.reversed() else sortedPersons
    }
}
