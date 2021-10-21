package dev.cardoso.quotesmvvm.di

import android.content.Context
import androidx.annotation.RestrictTo
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.local.QuoteDB
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.domain.QuoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@InstallIn (SingletonComponent::class)
@Module
class DataBaseModule {
    @Provides
    fun provideQuoteDAO(quoteDB: QuoteDB): QuoteDAO {
        return quoteDB.quoteDao()
    }

    @Provides
    fun provideQuoteDB(@ApplicationContext context: Context): QuoteDB {
      //  return QuoteDB.getDatabase(context.applicationContext, CoroutineScope(SupervisorJob() + Dispatchers.IO) )
        return Room.databaseBuilder(
    context.applicationContext,
    QuoteDB::class.java,
    "quotes.dbf"
    ).build()

    }



}