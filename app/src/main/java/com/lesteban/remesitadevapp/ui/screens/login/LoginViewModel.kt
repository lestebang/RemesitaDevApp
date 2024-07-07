package com.lesteban.remesitadevapp.ui.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesteban.remesitadevapp.data.model.AuthModel
import com.lesteban.remesitadevapp.data.repository.RemesitaRespository
import com.lesteban.remesitadevapp.utils.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: RemesitaRespository): ViewModel(){
    val authM: MutableState<DataState<AuthModel>?> = mutableStateOf(null)

    fun auth(apiKey: String, apiSecret: String) {
        viewModelScope.launch {
            repo.auth(apiKey,apiSecret).onEach {
                authM.value = it
            }.launchIn(viewModelScope)
        }
    }

    fun insertUser(authResult: AuthModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.refreshUsers(authResult)
        }
    }

}