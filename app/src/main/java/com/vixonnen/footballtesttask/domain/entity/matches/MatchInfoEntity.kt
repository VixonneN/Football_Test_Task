package com.vixonnen.footballtesttask.domain.entity.matches

data class MatchInfoEntity(
    val match_id: Int,
    val status_code: Int,
    val status: String,
    val match_start: String,
    val league_id: Int,
    val season_id: Int,
    val home_team: TeamEntity,
    val away_team: TeamEntity,
    val stats: StatsEntity,
    val venue: VenueEntity
) {

}
