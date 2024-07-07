package com.lesteban.remesitadevapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lesteban.remesitadevapp.data.model.Balance
import com.lesteban.remesitadevapp.data.model.ItemsCard
import com.lesteban.remesitadevapp.ui.screens.start.StartViewModel
import com.lesteban.remesitadevapp.utils.network.DataState
import com.lesteban.remesitadevapp.utils.round


@Composable
fun WalletSection(startViewModel: StartViewModel) {
    var balanceCombinedUSD by rememberSaveable { mutableStateOf("0") }

    if (startViewModel.balanceRem.value is DataState.Success<Balance>) {
        balanceCombinedUSD = (startViewModel.balanceRem.value as DataState.Success<Balance>).data.prepaidCardCombinedBalanceUsd.round(2).toString()
    }


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        Column {
            Text(
                text = "Billetera Remesita",
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$ $balanceCombinedUSD",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}