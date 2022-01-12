package com.vixonnen.footballtesttask.data.network

import com.vixonnen.footballtesttask.data.dto.league.DataDTO
import com.vixonnen.footballtesttask.data.dto.matches.DataMatchesDTO
import retrofit2.http.GET

interface Api {

    @GET
    suspend fun getAllLeagues() : DataDTO

    @GET("soccer/matches?apikey=$API_KEY&season_id=496&date_from=2020-09-19")
    suspend fun getMatches() : DataMatchesDTO

    companion object {
        private const val API_KEY = "141c4c20-730b-11ec-9e72-ad22df84b10c"
    }
}