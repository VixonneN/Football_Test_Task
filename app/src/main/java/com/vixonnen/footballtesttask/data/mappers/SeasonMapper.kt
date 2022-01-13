package com.vixonnen.footballtesttask.data.mappers

import com.vixonnen.footballtesttask.data.dto.seasons.DataSeasonsDTO
import com.vixonnen.footballtesttask.data.dto.seasons.SeasonQueryDTO
import com.vixonnen.footballtesttask.data.dto.seasons.SeasonsDTO
import com.vixonnen.footballtesttask.domain.entity.seasons.DataSeasonsEntity
import com.vixonnen.footballtesttask.domain.entity.seasons.SeasonQueryEntity
import com.vixonnen.footballtesttask.domain.entity.seasons.SeasonsEntity

fun DataSeasonsDTO.toEntity(): DataSeasonsEntity =
    DataSeasonsEntity(
        query.toEntity(),
        data.map {
            it.toEntity()
        })

fun SeasonQueryDTO.toEntity(): SeasonQueryEntity =
    SeasonQueryEntity(apikey, league_id)

fun SeasonsDTO.toEntity(): SeasonsEntity =
    SeasonsEntity(season_id, name, is_current, country_id, league_id, start_date, end_date)