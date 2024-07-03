package com.lesteban.remesitadevapp.data.repository

import android.content.Context
import com.lesteban.remesitadevapp.data.datasource.database.AppDatabase
import com.lesteban.remesitadevapp.data.datasource.database.asDomainModel
import com.lesteban.remesitadevapp.data.datasource.remote.ApiService
import com.lesteban.remesitadevapp.data.domain.UserData
import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.data.model.asDatabaseModel
import com.lesteban.remesitadevapp.utils.network.DataState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class RemesitaRespository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
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


    val users: Flow<List<UserData>?> =
        appDatabase.userDao.getUsers().map { it?.asDomainModel() }

    suspend fun refreshUsers(authResult: AuthModel) {
        try {
            val users: List<AuthModel> = listOf(authResult)
            appDatabase.userDao.insertUser(users.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }


}