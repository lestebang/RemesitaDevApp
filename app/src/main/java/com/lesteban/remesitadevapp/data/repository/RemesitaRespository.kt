package com.lesteban.remesitadevapp.data.repository

import com.lesteban.remesitadevapp.data.datasource.remote.ApiService
import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.utils.network.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemesitaRespository @Inject constructor(
    private val apiService: ApiService
): RemesitaRespositoryInterface {

    override suspend fun auth(apiKey: String, apiSecret: String): Flow<DataState<AuthModel>> = flow {
        emit(DataState.Loading)
        try {
            val body = mapOf(
                "api_key" to apiKey,
                "api_secret" to apiSecret
            )
            val authResult = apiService.auth(body)
            emit(DataState.Success(authResult))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }


}