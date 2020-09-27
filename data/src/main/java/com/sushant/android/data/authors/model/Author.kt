package com.sushant.android.data.model

import com.google.gson.annotations.SerializedName

data class Author(
   /* override val id: Int,
    val name: String,
    val userName: String,
    val email: String,
    val avatarUrl: String?*/
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("userName")
        var userName: String? = null,
        @SerializedName("email")
        var email: String? = null,
        @SerializedName("avatarUrl")
        var avatarUrl: String? = null

)
//: RecyclerItem
