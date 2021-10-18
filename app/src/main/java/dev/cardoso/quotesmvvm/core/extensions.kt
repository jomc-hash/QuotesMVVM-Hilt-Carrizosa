package dev.cardoso.quotesmvvm.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList

suspend fun <T> Flow<List<T>>.convertToList() =
    flatMapConcat { it.asFlow() }.toList()
