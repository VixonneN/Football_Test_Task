package com.vixonnen.footballtesttask.data.data_source.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vixonnen.footballtesttask.data.dto.league.ResultLeagueDTO

@Dao
interface FootballDao {

    @Query("select * from resultleaguedto")
    suspend fun getLeagues() : List<ResultLeagueDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun putLeagues(resultLeagueDTO: ResultLeagueDTO)
}