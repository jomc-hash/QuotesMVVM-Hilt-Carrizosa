package dev.cardoso.quotesmvvm.presentation.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cardoso.quotesmvvm.data.local.QuoteDB
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.domain.usecase.GetQuoteRandomUseCase
import dev.cardoso.quotesmvvm.domain.usecase.GetQuotesUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(var getQuotesUseCase: GetQuotesUseCase, var getQuoteRandomUseCase: GetQuoteRandomUseCase,
    var quoteDB: QuoteDB
) : ViewModel() {

    private val _quoteModel = MutableStateFlow(QuoteModel(0,"",""))
    val quoteModel: StateFlow<QuoteModel> = _quoteModel

    private lateinit var quoteDAO: QuoteDAO

    fun getQuotes() {
        viewModelScope.launch {
            val quotes= getQuotesUseCase.getQuotes().first()
            val quote= when(quotes.isEmpty()){
                true -> QuoteModel(id=0,"Solo sé que no sé nada","Sócrates")
                else -> quotes[0]
            }
            _quoteModel.value=quote
        }
    }
    //---  Load data from a suspend fun and mutate state
    fun randomQuote() {
        viewModelScope.launch {
            _quoteModel.value = getQuoteRandomUseCase.getQuoteRandom().first()
        }
    }

    fun setContext(context: Context){
       this.quoteDAO = QuoteDB.getDatabase(context, viewModelScope).quoteDao()
       //    this.quoteDAO= quoteDB.quoteDao()
    }
}