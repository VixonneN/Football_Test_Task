package com.vixonnen.footballtesttask.di

import com.vixonnen.footballtesttask.data.repository.FootballNetworkRepositoryImpl
import com.vixonnen.footballtesttask.domain.repository.FootballNetworkRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {

    @Singleton
    @Binds
    fun bindNetworkRepository(impl: FootballNetworkRepositoryImpl) : FootballNetworkRepository

}