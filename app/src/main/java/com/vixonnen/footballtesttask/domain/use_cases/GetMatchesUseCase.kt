package com.vixonnen.footballtesttask.domain.use_cases

import com.vixonnen.footballtesttask.domain.entity.matches.DataMatchesEntity
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(private val repository: FootballNetworkRepository) {

    suspend operator fun invoke() : DataMatchesEntity =
        repository.getMatches()
}