package com.vixonnen.footballtesttask.di.modules

import android.content.Context
import androidx.room.Room
import com.vixonnen.footballtesttask.data.data_source.database.FootballDatabase
import com.vixonnen.footballtesttask.data.repository.FootballDatabaseRepositoryImpl
import com.vixonnen.footballtesttask.domain.repository.FootballDatabaseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context) : FootballDatabase =
        Room.databaseBuilder(
            context,
            FootballDatabase::class.java,
            FootballDatabase.DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(db: FootballDatabase): FootballDatabaseRepository {
        return FootballDatabaseRepositoryImpl(db)
    }
}