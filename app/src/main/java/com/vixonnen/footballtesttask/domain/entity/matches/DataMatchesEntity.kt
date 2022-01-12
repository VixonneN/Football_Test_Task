package com.vixonnen.footballtesttask.domain.entity.matches

data class DataMatchesEntity(
    val query: QueryMatchesEntity,
    val data: Map<Int, MatchInfoEntity>
)
