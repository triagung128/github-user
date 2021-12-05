package com.triagung.githubuser.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class UserDetail(
    @ColumnInfo(name = "avatar_url")
    @Expose
    @SerializedName("avatar_url")
    var avatarUrl: String = "",
    
    @ColumnInfo(name = "bio")
    @Expose
    @SerializedName("bio")
    var bio: String = "",
    
    @ColumnInfo(name = "blog")
    @Expose
    @SerializedName("blog")
    var blog: String = "",
    
    @ColumnInfo(name = "company")
    @Expose
    @SerializedName("company")
    var company: String = "",
    
    @ColumnInfo(name = "created_at")
    @Expose
    @SerializedName("created_at")
    var createdAt: String = "",
    
    @ColumnInfo(name = "email")
    @Expose
    @SerializedName("email")
    var email: String = "",
    
    @ColumnInfo(name = "events_url")
    @Expose
    @SerializedName("events_url")
    var eventsUrl: String = "",
    
    @ColumnInfo(name = "followers")
    @Expose
    @SerializedName("followers")
    var followers: Int = 0,
    
    @ColumnInfo(name = "followers_url")
    @Expose
    @SerializedName("followers_url")
    var followersUrl: String = "",
    
    @ColumnInfo(name = "following")
    @Expose
    @SerializedName("following")
    var following: Int = 0,
    
    @ColumnInfo(name = "following_url")
    @Expose
    @SerializedName("following_url")
    var followingUrl: String = "",
    
    @ColumnInfo(name = "gists_url")
    @Expose
    @SerializedName("gists_url")
    var gistsUrl: String = "",
    
    @ColumnInfo(name = "gravatar_id")
    @Expose
    @SerializedName("gravatar_id")
    var gravatarId: String = "",
    
    @ColumnInfo(name = "hireable")
    @Expose
    @SerializedName("hireable")
    var hireable: String = "",
    
    @ColumnInfo(name = "html_url")
    @Expose
    @SerializedName("html_url")
    var htmlUrl: String = "",
    
    @PrimaryKey
    @ColumnInfo(name = "id")
    @Expose
    @SerializedName("id")
    var id: Int = 0,
    
    @ColumnInfo(name = "location")
    @Expose
    @SerializedName("location")
    var location: String = "",
    
    @ColumnInfo(name = "login")
    @Expose
    @SerializedName("login")
    var login: String = "",
    
    @ColumnInfo(name = "name")
    @Expose
    @SerializedName("name")
    var name: String = "",
    
    @ColumnInfo(name = "node_id")
    @Expose
    @SerializedName("node_id")
    var nodeId: String = "",
    
    @ColumnInfo(name = "organizations_url")
    @Expose
    @SerializedName("organizations_url")
    var organizationsUrl: String = "",
    
    @ColumnInfo(name = "public_gists")
    @Expose
    @SerializedName("public_gists")
    var publicGists: Int = 0,
    
    @ColumnInfo(name = "public_repos")
    @Expose
    @SerializedName("public_repos")
    var publicRepos: Int = 0,
    
    @ColumnInfo(name = "received_events_url")
    @Expose
    @SerializedName("received_events_url")
    var receivedEventsUrl: String = "",
    
    @ColumnInfo(name = "repos_url")
    @Expose
    @SerializedName("repos_url")
    var reposUrl: String = "",
    
    @ColumnInfo(name = "site_admin")
    @Expose
    @SerializedName("site_admin")
    var siteAdmin: Boolean = false,
    
    @ColumnInfo(name = "starred_url")
    @Expose
    @SerializedName("starred_url")
    var starredUrl: String = "",
    
    @ColumnInfo(name = "subscriptions_url")
    @Expose
    @SerializedName("subscriptions_url")
    var subscriptionsUrl: String = "",
    
    @ColumnInfo(name = "twitter_username")
    @Expose
    @SerializedName("twitter_username")
    var twitterUsername: String = "",
    
    @ColumnInfo(name = "type")
    @Expose
    @SerializedName("type")
    var type: String = "",
    
    @ColumnInfo(name = "updated_at")
    @Expose
    @SerializedName("updated_at")
    var updatedAt: String = "",
    
    @ColumnInfo(name = "url")
    @Expose
    @SerializedName("url")
    var url: String = ""
)