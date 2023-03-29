package com.comento.jpa.service

interface CountryService {

    fun getCapitalCityByName(countryName: String): String
}
