package com.vixonnen.footballtesttask.data.mappers

import com.vixonnen.footballtesttask.data.dto.league.DataDTO
import com.vixonnen.footballtesttask.data.dto.league.LeaguesDTO
import com.vixonnen.footballtesttask.data.dto.league.QueryDTO
import com.vixonnen.footballtesttask.domain.entity.league.DataEntity
import com.vixonnen.footballtesttask.domain.entity.league.LeagueEntity
import com.vixonnen.footballtesttask.domain.entity.league.QueryEntity

fun DataDTO.toDataEntity() : DataEntity =
    DataEntity(
        query.toQueryEntity(),
        data.map {
            it.toLeaguesEntity()
        }
    )

fun LeaguesDTO.toLeaguesEntity() : LeagueEntity =
    LeagueEntity(league_id, country_id, name)

fun QueryDTO.toQueryEntity() : QueryEntity =
    QueryEntity(apikey)