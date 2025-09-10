package com.test.hitachi.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login") val username: String,
    @SerializedName("id") val userId: String,
    @SerializedName("avatar_url") val avatar: String
)