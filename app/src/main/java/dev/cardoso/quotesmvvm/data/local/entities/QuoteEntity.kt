package dev.cardoso.quotesmvvm.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import dev.cardoso.quotesmvvm.data.model.QuoteModel

@Entity(tableName = "quote")
data class QuoteEntity (
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("quote")
    var quote: String = "",
    @SerializedName("author")
    var author: String = "",
){
    fun toQuoteModel():QuoteModel{
        return QuoteModel(
                id = this.id,
                quote = this.quote,
                author = this.author
        )
    }
}
