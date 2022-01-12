package com.vixonnen.footballtesttask.data.dto.matches

data class DataMatchesDTO(
    val query: QueryMatchesDTO,
    val data: Map<Int, MatchInfoDTO>
)
