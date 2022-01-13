package com.vixonnen.footballtesttask.data.mappers

import com.vixonnen.footballtesttask.data.dto.countries.CountriesResultDTO
import com.vixonnen.footballtesttask.data.dto.countries.DataCountriesDTO
import com.vixonnen.footballtesttask.data.dto.countries.QueryCountriesDTO
import com.vixonnen.footballtesttask.domain.entity.country.CountriesResultEntity
import com.vixonnen.footballtesttask.domain.entity.country.DataCountriesEntity
import com.vixonnen.footballtesttask.domain.entity.country.QueryCountriesEntity

fun CountriesResultDTO.toEntity() : CountriesResultEntity =
    CountriesResultEntity(id, name, country_code, continent)

fun DataCountriesDTO.toEntity() : DataCountriesEntity =
    DataCountriesEntity(
        query.toEntity(),
        results?.map {
            it.toEntity()
        }
    )

fun QueryCountriesDTO.toEntity() : QueryCountriesEntity =
    QueryCountriesEntity(continent)