package com.vixonnen.footballtesttask.data.dto.matches

data class MatchInfoDTO(
    val match_id: Int,
    val status_code: Int,
    val status: String,
    val match_start: String,
    val league_id: Int,
    val season_id: Int,
    val home_team: TeamDTO,
    val away_team: TeamDTO,
    val stats: StatsDTO,
    val venue: VenueDTO
) {

}
