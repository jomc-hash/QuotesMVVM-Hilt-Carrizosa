package dev.cardoso.quotesmvvm.data.model
import com.google.gson.annotations.SerializedName

data class QuoteModel (
    @SerializedName("id") val id: Int,
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String,
)
