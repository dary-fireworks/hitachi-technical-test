package com.test.hitachi.repository

import com.test.hitachi.model.SearchUser
import com.test.hitachi.model.User
import com.test.hitachi.model.UserDetail

interface GithubRepository {

    suspend fun getUserList(): List<User>
    suspend fun getUserDetail(username: String): UserDetail
    suspend fun searchUser(query: String): SearchUser

}