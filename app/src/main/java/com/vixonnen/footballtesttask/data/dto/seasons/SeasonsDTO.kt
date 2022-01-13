package com.vixonnen.footballtesttask.data.dto.seasons

data class SeasonsDTO(
    val season_id: Int,
    val name: String,
    val is_current: Int,
    val country_id: Int,
    val league_id: Int,
    val start_date: String,
    val end_date: String
)