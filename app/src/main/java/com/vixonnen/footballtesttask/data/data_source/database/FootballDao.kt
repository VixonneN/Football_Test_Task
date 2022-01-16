package com.vixonnen.footballtesttask.data.data_source.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vixonnen.footballtesttask.data.dto.fixtures.ResultFixturesDTO
import com.vixonnen.footballtesttask.data.dto.league.ResultLeagueDTO

@Dao
interface FootballDao {

    @Query("select * from result_league")
    suspend fun getLeagues() : List<ResultLeagueDTO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun putLeagues(resultLeagueDTO: ResultLeagueDTO)

    @Query("select * from result_fixtures")
    suspend fun getFixtures() : List<ResultFixturesDTO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun putFixtures(fixturesDTO: ResultFixturesDTO)

    @Query("select * from result_fixtures where league_name = :leagueName")
    suspend fun getFixturesByLeague(leagueName: String) : List<ResultFixturesDTO>

    @Query("select count(*) from result_league")
    suspend fun checkLeaguesForData() : Int

    @Query("select count(*) from result_fixtures")
    suspend fun checkFixturesForData() : Int
}