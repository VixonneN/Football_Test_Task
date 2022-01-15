package com.vixonnen.footballtesttask.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vixonnen.footballtesttask.data.data_source.network.Api
import com.vixonnen.footballtesttask.di.annotation.ApiBaseUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        const val BASE_URL = "https://apiv2.allsportsapi.com/"
    }

    @Provides
    @ApiBaseUrl
    fun provideBaseUrl(): String = BASE_URL

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .create()

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        @ApiBaseUrl baseUrl: String,
        client: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    @Singleton
    fun provideServiceApi(
        retrofit: Retrofit,
    ): Api =
        retrofit.create(Api::class.java)


}