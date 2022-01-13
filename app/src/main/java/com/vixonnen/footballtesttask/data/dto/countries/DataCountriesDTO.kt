package com.vixonnen.footballtesttask.data.dto.countries

data class DataCountriesDTO(
    val query: QueryCountriesDTO,
    val results: List<CountriesResultDTO>?
)