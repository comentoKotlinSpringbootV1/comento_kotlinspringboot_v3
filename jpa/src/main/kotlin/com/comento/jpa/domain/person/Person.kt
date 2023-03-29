package com.comento.jpa.domain.person

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import com.comento.jpa.domain.company.Company
import com.comento.jpa.domain.country.Country
import org.hibernate.annotations.ColumnDefault
import org.jetbrains.annotations.NotNull
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "person")
class Person(
    name: String,
    age: Int?,
    height: Int?,
    weight: Int?,
    gender: String?,
    isMarried: Boolean?,
    company: Company?,
    country: Country,
) : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private var _id: Int? = null

    @Column(name = "age")
    var age: Int? = age
        protected set

    @Column(name = "height")
    var height: Int? = height
        protected set

    @Column(name = "weight")
    var weight: Int? = weight
        protected set

    @Column(name = "name") @NotNull
    var name: String = name
        protected set

    @Column(name = "gender")
    @ColumnDefault("UnKnown")
    var gender: String? = gender
        protected set

    @Column(name = "is_married")
    @ColumnDefault("false")
    var isMarried: Boolean? = isMarried
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "company", referencedColumnName = "name")
    var company: Company? = company
        protected set

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country", referencedColumnName = "name", nullable = false)
    var country: Country = country
        protected set

    val personId
        get() = _id ?: throw RuntimeException()

    override fun equals(other: Any?): Boolean = kotlinEquals(other, properties = arrayOf(Person::_id))
    override fun hashCode() = kotlinHashCode(properties = arrayOf(Person::_id))
    override fun toString(): String = kotlinToString(
        properties = arrayOf(
            Person::_id,
            Person::age,
            Person::country
        )
    )
}
