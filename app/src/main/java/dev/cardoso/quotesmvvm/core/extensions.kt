package dev.cardoso.quotesmvvm.core

import dev.cardoso.quotesmvvm.data.local.entities.QuoteEntity
import dev.cardoso.quotesmvvm.data.model.LoginResponse
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.flow.*

suspend fun <T> Flow<List<T>>.convertToList() =
    flatMapConcat { it.asFlow() }.toList()

fun Flow<QuoteEntity>.toQuoteModel() : Flow<QuoteModel> {
   return this.map {
       QuoteModel(id= it.id,
           quote = it.quote,
           author = it.author)
   }
}

fun  List<QuoteModel>.toQuoteEntity(): List<QuoteEntity> {
    return this.map {
        QuoteEntity(id= it.id,
            quote = it.quote,
            author = it.author)
    }
}

fun LoginResponse.isSuccessful(): Boolean {
    return this.success
}
