package com.vixonnen.footballtesttask.data.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vixonnen.footballtesttask.data.dto.fixtures.ResultFixturesDTO
import com.vixonnen.footballtesttask.data.dto.league.ResultLeagueDTO

@Database(
    entities =
    [ResultLeagueDTO::class,
    ResultFixturesDTO::class],
    version = 1
)
abstract class FootballDatabase: RoomDatabase() {

    abstract val footballDao: FootballDao

    companion object {
        const val DATABASE_NAME = "football_database"
    }

}