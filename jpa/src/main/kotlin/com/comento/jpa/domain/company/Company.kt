package com.comento.jpa.domain.company

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import com.comento.jpa.domain.country.Country
import org.springframework.data.annotation.CreatedDate
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "company")

class Company(
    name: String,
    country: Country
) : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private var _id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String = name
        protected set

    @CreatedDate
    @Column(name = "founding_date", nullable = false, updatable = false)
    val foundingDate: LocalDateTime = LocalDateTime.MIN

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country", referencedColumnName = "name", nullable = false)
    var country: Country = country
        protected set

    val id
        get() = _id ?: throw RuntimeException()

    override fun equals(other: Any?): Boolean = kotlinEquals(other, properties = arrayOf(Company::_id))
    override fun hashCode() = kotlinHashCode(properties = arrayOf(Company::_id))
    override fun toString(): String = kotlinToString(
        properties = arrayOf(
            Company::_id,
            Company::name,
            Company::country
        )
    )
}
