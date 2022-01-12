package com.vixonnen.footballtesttask.domain.entity.matches

data class TeamEntity(
    val team_id: Int,
    val name: String,
    val short_code: String,
    val logo: String,
    val country: CountryEntity
)
