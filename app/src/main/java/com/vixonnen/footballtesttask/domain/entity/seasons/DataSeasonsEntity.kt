package com.vixonnen.footballtesttask.domain.entity.seasons

data class DataSeasonsEntity(
    val query: SeasonQueryEntity,
    val data: List<SeasonsEntity>
)