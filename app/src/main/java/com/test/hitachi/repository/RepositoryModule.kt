package com.test.hitachi.repository

import com.test.hitachi.network.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesGithubRepository(githubApi: GithubApi): GithubRepository =
        GithubRepositoryImpl(githubApi)

}