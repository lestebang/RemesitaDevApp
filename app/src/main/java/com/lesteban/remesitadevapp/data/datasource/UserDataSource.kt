package com.lesteban.remesitadevapp.data.datasource

import android.provider.ContactsContract
import android.util.Log
import com.lesteban.remesitadevapp.ui.screens.activity.User
import com.yourssohail.learnsupabase.data.model.Note
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.filter.FilterOperator
import io.github.jan.supabase.realtime.PostgresAction
import io.github.jan.supabase.realtime.channel
import io.github.jan.supabase.realtime.postgresChangeFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.json.Json
import javax.inject.Inject
import kotlin.Result


class UserDataSource @Inject constructor(
    private val supabaseClient: SupabaseClient
) {

//    fun deleteById(userId: Int): Flow<ApiResult<Unit>>{
//
//        return flow {
//            emit(ApiResult.Loading)
//            try {
//                supabaseClient.postgrest["users-table"].delete {
//                    filter("id", FilterOperator.EQ, userId )
//                }
//                emit(ApiResult.Success(Unit))
//            }catch (e: Exception){
//                emit(ApiResult.Error(e.message))
//            }
//        }
//    }

    fun insert(user: User): Flow<ApiResult<Unit>>{

        return flow {
            emit(ApiResult.Loading)
            try {
                supabaseClient.postgrest["users"].insert(user)
                emit(ApiResult.Success(Unit))
            }catch (e: Exception){
                emit(ApiResult.Error(e.message))
            }
        }
    }

    fun realtimeUserDB(): Flow<ApiResult<Unit>>{
        return flow {
            emit(ApiResult.Loading)
            try {
                val channel = supabaseClient.channel("test")
                val dataFlow = channel.postgresChangeFlow<PostgresAction>(schema = "public")
                emit(ApiResult.Success(Unit))
//                dataFlow.onEach {
//                    when(it){
//                        is PostgresAction.Delete -> TODO()
//                        is PostgresAction.Insert -> {
//
//                        }
//                        is PostgresAction.Select -> TODO()
//                        is PostgresAction.Update -> {
//                            val stringifiedData = it.record.toString()
//                            val data = Json.decodeFromString<Note>(stringifiedData)
//                            _userState.va
//                        }
//                    }
//                }
                channel.subscribe()
            }catch (e: Exception){
                emit(ApiResult.Error(e.message))
            }
        }
    }

//    fun updateById(userId: Int, user: User): Flow<ApiResult<Unit>>{
//
//        return flow {
//            emit(ApiResult.Loading)
//            try {
//                supabaseClient.postgrest["users-table"].update(user) {
//                    filter("id", FilterOperator.EQ, userId )
//                }
//                emit(ApiResult.Success(Unit))
//            }catch (e: Exception){
//                emit(ApiResult.Error(e.message))
//            }
//        }
//    }
}

sealed class ApiResult<out R>{
    data class Success<out R>(val data:R): ApiResult<R>()
    data class Error(val message: String?): ApiResult<Nothing>()
    object Loading: ApiResult<Nothing>()
}