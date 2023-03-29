package com.comento.jpa.dto

import com.comento.jpa.domain.company.Company
import com.comento.jpa.domain.country.Country
import com.comento.jpa.domain.person.Person

data class PersonDto(
    val personId: Int,
    val age: Int?,
    val height: Int?,
    val weight: Int?,
    val name: String,
    val gender: String?,
    val isMarried: Boolean?,
    val company: String?,
    val country: String
) {
    fun toEntity(country: Country, company: Company?): Person {
        return Person(
            age = this.age,
            height = this.height,
            weight = this.weight,
            name = this.name,
            gender = this.gender,
            isMarried = this.isMarried,
            company = company,
            country = country,
        )
    }
}
