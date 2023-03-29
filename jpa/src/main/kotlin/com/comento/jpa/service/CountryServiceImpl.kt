package com.comento.jpa.service

import com.comento.jpa.domain.country.CountryRepository
import com.comento.jpa.logger
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
) : CountryService {

    override fun getCapitalCityByName(countryName: String): String {
        logger.info { countryName }
        val country = countryRepository.findCountryByName(countryName.uppercase())
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        logger.info { country.capitalCity }
        return country.capitalCity
    }

}
