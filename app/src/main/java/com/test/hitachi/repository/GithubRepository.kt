package com.test.hitachi.repository

import com.test.hitachi.model.User

interface GithubRepository {

    suspend fun getUserList(): List<User>

}