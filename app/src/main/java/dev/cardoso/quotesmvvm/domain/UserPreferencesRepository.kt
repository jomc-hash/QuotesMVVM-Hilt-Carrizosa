package dev.cardoso.quotesmvvm.domain

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.=re
import kotlinx.coroutines.flow.Flow

class UserPreferencesRepository(val context: Context) {
    val USER_DATASTORE = "preferencesquotesmvvm"
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)

    companion object{
        val TOKEN = StringPreferencesKey("TOKEN")
    }

    suspend fun saveTokenToDataStore(token: String){
        context.dataStore.edit{
            it[TOKEN]= token
        }
    }

    suspend fun getTokenFromDataStore(): Flow<String> = context.datastore.data
        .map{
            preferences->preferences[TOKEN]?:""
        }

}