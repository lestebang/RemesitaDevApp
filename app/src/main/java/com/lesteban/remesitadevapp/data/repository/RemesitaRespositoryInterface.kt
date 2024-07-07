package com.lesteban.remesitadevapp.data.repository

import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.data.model.Balance
import com.lesteban.remesitadevapp.data.model.ItemsCard
import com.lesteban.remesitadevapp.data.model.transactions.ItemsTransaction
import com.lesteban.remesitadevapp.utils.network.DataState
import kotlinx.coroutines.flow.Flow

interface RemesitaRespositoryInterface {

    suspend fun auth(apiKey: String, apiSecret: String): Flow<DataState<AuthModel>>
    suspend fun getBalance(key: String): Flow<DataState<Balance>>
    suspend fun getCards(key: String): Flow<DataState<ItemsCard>>
    suspend fun getTransactions(key: String, number: String,pg:Int,pgSize:Int): Flow<DataState<ItemsTransaction>>

}