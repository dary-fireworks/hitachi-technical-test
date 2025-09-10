package com.test.hitachi.model

import com.google.gson.annotations.SerializedName

data class UserDetail(
    @SerializedName("login") val username: String,
    @SerializedName("id") val userId: String,
    @SerializedName("avatar_url") val avatar: String,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("bio") val bio: String
)
