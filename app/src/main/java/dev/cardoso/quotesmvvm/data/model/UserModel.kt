package dev.cardoso.quotesmvvm.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("id") val id:Int,
    @SerializedName("account") val account: String,
    @SerializedName("password") val password: String

)