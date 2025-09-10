package com.test.hitachi.network

import com.test.hitachi.model.User
import retrofit2.http.GET

interface GithubApi {
    @GET("users")
    suspend fun getUserList(): List<User>

}