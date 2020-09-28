package com.sushant.android.data.authors.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Post(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("body")
    var body: String? = null,
    @SerializedName("imageUrl")
    var imageUrl: String? = null,
    @SerializedName("authorId")
    var authorId: Int? = null,
) : Serializable