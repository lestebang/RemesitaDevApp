package com.lesteban.remesitadevapp.ui.screens.start

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesteban.remesitadevapp.data.model.Balance
import com.lesteban.remesitadevapp.data.model.ItemsCard
import com.lesteban.remesitadevapp.data.repository.RemesitaRespository
import com.lesteban.remesitadevapp.utils.network.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val repo: RemesitaRespository) : ViewModel() {
    val balanceRem: MutableState<DataState<Balance>?> = mutableStateOf(null)
    val cardsRem: MutableState<DataState<ItemsCard>?> = mutableStateOf(null)

    fun getBalance(data: MutableState<String>) {
        viewModelScope.launch {
            repo.getBalance(data.value).onEach {
                balanceRem.value = it
            }.launchIn(viewModelScope)
        }
    }

    fun getCards(data: MutableState<String>) {
        viewModelScope.launch {
            repo.getCards(data.value).onEach {
                cardsRem.value = it
            }.launchIn(viewModelScope)
        }
    }


}