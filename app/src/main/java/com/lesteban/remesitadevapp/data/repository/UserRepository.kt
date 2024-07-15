package com.lesteban.remesitadevapp.data.repository

import com.lesteban.remesitadevapp.data.datasource.ApiResult
import com.lesteban.remesitadevapp.data.datasource.UserDataSource
import com.lesteban.remesitadevapp.ui.screens.activity.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface UserRepository {
    fun insert(user: User): Flow<ApiResult<Unit>>
    fun updateRT(): Flow<ApiResult<Unit>>
}



class DefaultUserRespository @Inject  constructor(
    private val dataSource: UserDataSource
): UserRepository{
    override fun insert(user: User): Flow<ApiResult<Unit>> {
       return dataSource.insert(user)
    }

    override fun updateRT(): Flow<ApiResult<Unit>> {
        return dataSource.realtimeUserDB()
    }

}