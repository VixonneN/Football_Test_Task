package com.vixonnen.footballtesttask.data.data_source.network

import com.vixonnen.footballtesttask.data.dto.fixtures.DataFixturesDTO
import com.vixonnen.footballtesttask.data.dto.league.DataLeagueDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("football/?met=Leagues&APIkey=$API_KEY")
    suspend fun getLeagues(): DataLeagueDTO

    @GET("football/?met=Fixtures&APIkey=$API_KEY&from=2021-05-03&to=2021-05-18")
    suspend fun getFixtures(): DataFixturesDTO

    companion object {
        private const val API_KEY =
            "e3e1c29e1d2d739ba5c0fe632b96f3bfcf3aba00aa4350cadda296548e1eeeba"
    }
}