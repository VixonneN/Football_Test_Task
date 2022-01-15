package com.vixonnen.footballtesttask.domain.entity.fixtures

data class ResultFixturesEntity(
    val event_key: String,
    val event_date: String,
    val event_time: String,

    val event_home_team: String,
    val home_team_key: String,
    val event_away_team: String,
    val away_team_key: String,

    val event_final_result: String,
    val league_name: String,
    val home_team_logo: String,
    val away_team_logo: String,
    val event_stadium: String
)