package com.comento.dbless.person.domain

data class Person(
    val age: Int,
    val height: Int,
    val id: String,
    val name: String
){
    init{
        validate()
    }

    fun validate() {
        if (age !in 1..100) {
            throw IllegalArgumentException("age 범위: [0~100]")
        }
        if (height !in 130..200) {
            throw IllegalArgumentException("height 범위: [130~200]")
        }
        if (!id.matches(Regex("^ID\\d{4}$"))) {
            throw IllegalArgumentException("id 형식: “ID****”")
        }
        if (!name.matches(Regex("^[a-zA-Z]*$"))) {
            throw IllegalArgumentException("name 범위: [A..Z, `a`.. `z`]")
        }
    }
}
