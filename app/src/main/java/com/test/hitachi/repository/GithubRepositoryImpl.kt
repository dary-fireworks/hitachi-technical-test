package com.test.hitachi.repository

import com.test.hitachi.model.SearchUser
import com.test.hitachi.model.User
import com.test.hitachi.model.UserDetail
import com.test.hitachi.network.GithubApi
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi
): GithubRepository {

    override suspend fun getUserList(): List<User> = githubApi.getUserList()

    override suspend fun getUserDetail(username: String): UserDetail = githubApi.getUserDetail(username)

    override suspend fun searchUser(query: String): SearchUser = githubApi.searchUser(query)
}