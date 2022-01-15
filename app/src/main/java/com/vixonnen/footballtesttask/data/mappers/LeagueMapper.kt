package com.vixonnen.footballtesttask.data.mappers

import com.vixonnen.footballtesttask.data.dto.league.DataLeagueDTO
import com.vixonnen.footballtesttask.data.dto.league.ResultLeagueDTO
import com.vixonnen.footballtesttask.domain.entity.league.DataLeagueEntity
import com.vixonnen.footballtesttask.domain.entity.league.ResultLeagueEntity

fun DataLeagueDTO.toEntity() : DataLeagueEntity =
    DataLeagueEntity(
        success,
        result.map {
            it.toEntity()
        }
    )

fun ResultLeagueDTO.toEntity() : ResultLeagueEntity =
    ResultLeagueEntity(league_key, league_name, country_key, country_name, league_logo, country_logo)