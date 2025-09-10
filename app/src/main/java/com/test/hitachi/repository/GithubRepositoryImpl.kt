package com.test.hitachi.repository

import com.test.hitachi.model.User
import com.test.hitachi.network.GithubApi
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
): GithubRepository {

    override suspend fun getUserList(): List<User> = githubApi.getUserList()

}