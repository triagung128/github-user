package com.triagung.githubuser.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.triagung.githubuser.model.User

data class SearchResponse(
    @Expose
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,

    @Expose
    @SerializedName("items")
    val users: List<User>,

    @Expose
    @SerializedName("total_count")
    val totalCount: Int
)