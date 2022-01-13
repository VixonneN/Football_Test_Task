package com.vixonnen.footballtesttask.data.network

import com.vixonnen.footballtesttask.data.dto.countries.DataCountriesDTO
import com.vixonnen.footballtesttask.data.dto.league.DataDTO
import com.vixonnen.footballtesttask.data.dto.matches.DataMatchesDTO
import com.vixonnen.footballtesttask.data.dto.seasons.DataSeasonsDTO
import com.vixonnen.footballtesttask.domain.entity.seasons.DataSeasonsEntity
import retrofit2.http.GET

interface Api {

    @GET("soccer/countries?apikey=$API_KEY&continent=$CONTINENT")
    suspend fun getCountries() : DataCountriesDTO

    @GET("soccer/leagues?apikey=$API_KEY")
    suspend fun getAllLeagues() : DataDTO

    @GET("soccer/matches?apikey=$API_KEY&season_id=496&date_from=2020-09-19")
    suspend fun getMatches() : DataMatchesDTO

    @GET("soccer/season?apikey=$API_KEY&league_id=314")
    suspend fun getSeason() : DataSeasonsDTO

    companion object {
        private const val API_KEY = "141c4c20-730b-11ec-9e72-ad22df84b10c"
        private const val CONTINENT = "Europe"
    }
}