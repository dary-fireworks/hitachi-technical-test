package com.test.hitachi.network

import com.test.hitachi.model.SearchUser
import com.test.hitachi.model.User
import com.test.hitachi.model.UserDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET("users")
    suspend fun getUserList(): List<User>

    @GET("users/{username}")
    suspend fun getUserDetail(@Path("username") username: String): UserDetail

    @GET("search/users")
    suspend fun searchUser(@Query("q") query: String): SearchUser

}