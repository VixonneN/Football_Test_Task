package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.country.DataCountriesEntity
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val repository: FootballNetworkRepository
) {

    suspend operator fun invoke() : DataCountriesEntity =
        repository.getCountry()
}