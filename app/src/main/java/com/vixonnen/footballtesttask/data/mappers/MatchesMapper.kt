package com.vixonnen.footballtesttask.data.mappers

import com.vixonnen.footballtesttask.data.dto.matches.*
import com.vixonnen.footballtesttask.domain.entity.matches.*

fun CountryDTO.toEntity(): CountryEntity =
    CountryEntity(country_id, name, country_code, continent)

fun DataMatchesDTO.toEntity(): DataMatchesEntity =
    DataMatchesEntity(query.toEntity(), data.mapValues {
        it.value.toEntity()
    })

fun MatchInfoDTO.toEntity(): MatchInfoEntity =
    MatchInfoEntity(match_id,
        status_code,
        status,
        match_start,
        league_id,
        season_id,
        home_team.toEntity(),
        away_team.toEntity(),
        stats.toEntity(),
        venue.toEntity())

fun QueryMatchesDTO.toEntity() : QueryMatchesEntity =
    QueryMatchesEntity(season_id, date_from, apikey)

fun StatsDTO.toEntity() : StatsEntity =
    StatsEntity(home_score, away_score, ht_score, ft_score)

fun TeamDTO.toEntity() : TeamEntity =
    TeamEntity(team_id, name, short_code, logo, country.toEntity())

fun VenueDTO.toEntity() : VenueEntity =
    VenueEntity(venue_id, name, capacity, city, country_id)