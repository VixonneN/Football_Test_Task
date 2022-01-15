package com.vixonnen.footballtesttask.data.mappers

import com.vixonnen.footballtesttask.data.dto.fixtures.DataFixturesDTO
import com.vixonnen.footballtesttask.data.dto.fixtures.ResultFixturesDTO
import com.vixonnen.footballtesttask.domain.entity.fixtures.DataFixturesEntity
import com.vixonnen.footballtesttask.domain.entity.fixtures.ResultFixturesEntity

fun DataFixturesDTO.toEntity(): DataFixturesEntity =
    DataFixturesEntity(
        success,
        result.map {
            it.toEntity()
        }
    )

fun ResultFixturesDTO.toEntity(): ResultFixturesEntity =
    ResultFixturesEntity(event_key,
        event_date,
        event_time,
        event_home_team,
        home_team_key,
        event_away_team,
        away_team_key,
        event_final_result,
        league_name,
        home_team_logo,
        away_team_logo,
        event_stadium)

fun List<ResultFixturesDTO>.toEntity(): List<ResultFixturesEntity> =
    map {
        it.toEntity()
    }

fun ResultFixturesEntity.toDTO(): ResultFixturesDTO =
    ResultFixturesDTO(event_key,
        event_date,
        event_time,
        event_home_team,
        home_team_key,
        event_away_team,
        away_team_key,
        event_final_result,
        league_name,
        home_team_logo,
        away_team_logo,
        event_stadium)
