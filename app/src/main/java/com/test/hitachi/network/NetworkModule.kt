package com.test.hitachi.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(
                ChuckerInterceptor.Builder(context)
                    .maxContentLength(250_000L)
                    .redactHeaders("Authorization", "Cookie")
                    .alwaysReadResponseBody(true)
                    .build()
            )
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGithubApi(retrofit: Retrofit): GithubApi =
        retrofit.create(GithubApi::class.java)
}