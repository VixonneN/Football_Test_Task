package com.vixonnen.footballtesttask.data.dto.league

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_league")
data class ResultLeagueDTO(
    @PrimaryKey
    val league_key: String,
    val league_name: String,
    val country_key: String,
    val country_name: String,
    val league_logo: String,
    val country_logo: String
)
