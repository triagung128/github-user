package com.triagung.githubuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class User(
    @ColumnInfo(name = "avatar_url")
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @ColumnInfo(name = "events_url")
    @Expose
    @SerializedName("events_url")
    val eventsUrl: String? = null,

    @ColumnInfo(name = "followers_url")
    @Expose
    @SerializedName("followers_url")
    val followersUrl: String? = null,

    @ColumnInfo(name = "following_url")
    @Expose
    @SerializedName("following_url")
    val followingUrl: String? = null,

    @ColumnInfo(name = "gists_url")
    @Expose
    @SerializedName("gists_url")
    val gistsUrl: String? = null,

    @ColumnInfo(name = "gravatar_id")
    @Expose
    @SerializedName("gravatar_id")
    val gravatarId: String? = null,

    @ColumnInfo(name = "html_url")
    @Expose
    @SerializedName("html_url")
    val htmlUrl: String? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    @Expose
    @SerializedName("id")
    val id: Int = 0,

    @ColumnInfo(name = "login")
    @Expose
    @SerializedName("login")
    val login: String? = null,

    @ColumnInfo(name = "node_id")
    @Expose
    @SerializedName("node_id")
    val nodeId: String? = null,

    @ColumnInfo(name = "organizations_url")
    @Expose
    @SerializedName("organizations_url")
    val organizationsUrl: String? = null,

    @ColumnInfo(name = "received_events_url")
    @Expose
    @SerializedName("received_events_url")
    val receivedEventsUrl: String? = null,

    @ColumnInfo(name = "repos_url")
    @Expose
    @SerializedName("repos_url")
    val reposUrl: String? = null,

    @ColumnInfo(name = "score")
    @Expose
    @SerializedName("score")
    val score: Double = 0.0,

    @ColumnInfo(name = "site_admin")
    @Expose
    @SerializedName("site_admin")
    val siteAdmin: Boolean = false,

    @ColumnInfo(name = "starred_url")
    @Expose
    @SerializedName("starred_url")
    val starredUrl: String? = null,

    @ColumnInfo(name = "subscriptions_url")
    @Expose
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String? = null,

    @ColumnInfo(name = "type")
    @Expose
    @SerializedName("type")
    val type: String? = null,

    @ColumnInfo(name = "url")
    @Expose
    @SerializedName("url")
    val url: String? = null
)