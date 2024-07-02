package com.lesteban.remesitadevapp.data.repository

import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.utils.network.DataState
import kotlinx.coroutines.flow.Flow

interface RemesitaRespositoryInterface {

    suspend fun auth(apiKey: String, apiSecret: String): Flow<DataState<AuthModel>>

}