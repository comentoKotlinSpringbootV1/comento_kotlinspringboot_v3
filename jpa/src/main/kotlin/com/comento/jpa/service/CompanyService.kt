package com.comento.jpa.service

import com.comento.jpa.dto.CompanyDto

interface CompanyService {
    fun getCompaniesByCountryName(countryName: String): List<CompanyDto>
}
