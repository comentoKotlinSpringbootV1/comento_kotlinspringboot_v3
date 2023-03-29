package com.comento.jpa.service

import com.comento.jpa.domain.company.CompanyRepository
import com.comento.jpa.dto.CompanyDto
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CompanyServiceImpl(
    private val companyRepository: CompanyRepository
) : CompanyService {
    override fun getCompaniesByCountryName(countryName: String): List<CompanyDto> {
        val companies = companyRepository.findByCountryName(countryName.uppercase())

        if (companies.isEmpty()) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }

        return companies.map {
            CompanyDto(it.name, it.foundingDate, it.country.name)
        }
    }

}
