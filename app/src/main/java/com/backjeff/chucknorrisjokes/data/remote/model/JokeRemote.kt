package com.backjeff.chucknorrisjokes.data.remote.model

import com.google.gson.annotations.SerializedName

data class JokeRemote(
    @SerializedName("icon_url")
    val iconUrl: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("value")
    val value: String?
)
