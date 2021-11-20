package dev.cardoso.quotesmvvm.data.model

import com.google.gson.annotations.SerializedName

class LoginRequest (@SerializedName ("account") var acocunt:String,  @SerializedName("password") var password:String)