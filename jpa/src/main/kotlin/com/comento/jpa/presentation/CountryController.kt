package com.comento.jpa.presentation

import com.comento.jpa.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/countries")
class CountryController(
    private val countryService: CountryService
) {
    @GetMapping("/{countryName}/capital-city")
    fun getCapitalCityByName(@PathVariable countryName: String): String {
        return countryService.getCapitalCityByName(countryName)
    }
}
