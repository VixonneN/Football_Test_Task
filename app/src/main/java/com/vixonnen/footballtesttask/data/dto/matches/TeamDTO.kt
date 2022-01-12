package com.vixonnen.footballtesttask.data.dto.matches

data class TeamDTO(
    val team_id: Int,
    val name: String,
    val short_code: String,
    val logo: String,
    val country: CountryDTO
)
