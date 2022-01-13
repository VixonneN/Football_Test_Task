package com.vixonnen.footballtesttask.domain.entity.country

data class DataCountriesEntity(
    val query: QueryCountriesEntity,
    val results: List<CountriesResultEntity>?
)