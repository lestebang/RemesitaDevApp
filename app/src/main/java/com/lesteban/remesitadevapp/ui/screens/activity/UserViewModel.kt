package com.lesteban.remesitadevapp.ui.screens.activity

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesteban.remesitadevapp.data.datasource.ApiResult
import com.lesteban.remesitadevapp.data.repository.UserRepository
import com.yourssohail.learnsupabase.data.model.Note
import com.yourssohail.learnsupabase.data.model.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.realtime.PostgresAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<ApiResult<*>>(ApiResult.Loading)
    val uiState: StateFlow<ApiResult<*>>
        get() = _uiState

    private val _userState = mutableStateOf<UserState>(UserState.Loading)
    val userState: State<UserState> = _userState

    fun insert(user: User){
        viewModelScope.launch {
            repository.insert(user).collectLatest { data ->
                _uiState.update { data }
            }
        }
    }

    fun realtimeUserDB(){
        viewModelScope.launch {
            repository.updateRT().collectLatest {data ->
//                data.onEach {
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
            }

        }
    }
}