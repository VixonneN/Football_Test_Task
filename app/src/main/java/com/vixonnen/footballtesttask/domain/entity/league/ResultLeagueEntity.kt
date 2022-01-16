package com.vixonnen.footballtesttask.domain.entity.league

import java.io.Serializable

data class ResultLeagueEntity(
    val league_key: String,
    val league_name: String,
    val country_key: String,
    val country_name: String,
    val league_logo: String,
    val country_logo: String
)
