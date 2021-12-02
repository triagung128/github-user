package com.triagung.githubuser.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDetail(
    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String,

    @Expose
    @SerializedName("bio")
    val bio: String,

    @Expose
    @SerializedName("blog")
    val blog: String,

    @Expose
    @SerializedName("company")
    val company: String,

    @Expose
    @SerializedName("created_at")
    val createdAt: String,

    @Expose
    @SerializedName("email")
    val email: String,

    @Expose
    @SerializedName("events_url")
    val eventsUrl: String,

    @Expose
    @SerializedName("followers")
    val followers: Int,

    @Expose
    @SerializedName("followers_url")
    val followersUrl: String,

    @Expose
    @SerializedName("following")
    val following: Int,

    @Expose
    @SerializedName("following_url")
    val followingUrl: String,

    @Expose
    @SerializedName("gists_url")
    val gistsUrl: String,

    @Expose
    @SerializedName("gravatar_id")
    val gravatarId: String,

    @Expose
    @SerializedName("hireable")
    val hireable: String,

    @Expose
    @SerializedName("html_url")
    val htmlUrl: String,

    @Expose
    @SerializedName("id")
    val id: Int,

    @Expose
    @SerializedName("location")
    val location: String,

    @Expose
    @SerializedName("login")
    val login: String,

    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("node_id")
    val nodeId: String,

    @Expose
    @SerializedName("organizations_url")
    val organizationsUrl: String,

    @Expose
    @SerializedName("public_gists")
    val publicGists: Int,

    @Expose
    @SerializedName("public_repos")
    val publicRepos: Int,

    @Expose
    @SerializedName("received_events_url")
    val receivedEventsUrl: String,

    @Expose
    @SerializedName("repos_url")
    val reposUrl: String,

    @Expose
    @SerializedName("site_admin")
    val siteAdmin: Boolean,

    @Expose
    @SerializedName("starred_url")
    val starredUrl: String,

    @Expose
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String,

    @Expose
    @SerializedName("twitter_username")
    val twitterUsername: String,

    @Expose
    @SerializedName("type")
    val type: String,

    @Expose
    @SerializedName("updated_at")
    val updatedAt: String,

    @Expose
    @SerializedName("url")
    val url: String
)