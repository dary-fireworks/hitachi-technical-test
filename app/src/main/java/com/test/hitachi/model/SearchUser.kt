package com.test.hitachi.model

import com.google.gson.annotations.SerializedName

data class SearchUser(
    @SerializedName("total_count") val totalCount: String,
    @SerializedName("incomplete_results") val incompleteResults: Boolean,
    @SerializedName("items") val users: List<User>
)
