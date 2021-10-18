package dev.cardoso.quotesmvvm.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "quote")
data class QuoteEntity (
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("quote")
    var quote: String = "",
    @SerializedName("author")
    var author: String = "",
)