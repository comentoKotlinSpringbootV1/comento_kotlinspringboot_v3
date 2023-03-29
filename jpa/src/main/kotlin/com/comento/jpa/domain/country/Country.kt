package com.comento.jpa.domain.country

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "country")
class Country(
    zipCode: Long,
    name: String,
    capitalCity: String
) : Serializable {
    @Id
    @Column(name = "zip_code")
    private var _zipCode: Long? = zipCode

    @Column(name = "name", nullable = false)
    var name: String = name
        protected set

    @Column(name = "capital_city", nullable = false)
    var capitalCity: String = capitalCity
        protected set

    val zipCode
        get() = _zipCode ?: throw RuntimeException()

    override fun equals(other: Any?): Boolean = kotlinEquals(other, properties = arrayOf(Country::_zipCode))
    override fun hashCode() = kotlinHashCode(properties = arrayOf(Country::_zipCode))
    override fun toString(): String = kotlinToString(
        properties = arrayOf(
            Country::_zipCode,
            Country::name,
            Country::capitalCity
        )
    )
}
