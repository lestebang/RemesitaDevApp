package com.lesteban.remesitadevapp.ui.screens.profile

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesteban.remesitadevapp.data.domain.UserData
import com.lesteban.remesitadevapp.data.repository.RemesitaRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repo: RemesitaRespository): ViewModel(){

    val userEnt : MutableState<List<UserData>?> = mutableStateOf(listOf())

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.users.collect { list ->
                withContext(Dispatchers.Main) {
                    userEnt.value = list
                }
            }
        }
    }
}