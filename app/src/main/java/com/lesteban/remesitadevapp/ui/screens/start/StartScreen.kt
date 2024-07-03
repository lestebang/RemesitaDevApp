package com.lesteban.remesitadevapp.ui.screens.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lesteban.remesitadevapp.ui.component.CardsSection
import com.lesteban.remesitadevapp.ui.component.WalletSection

@Composable
fun StartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        WalletSection()
        CardsSection()
        Spacer(modifier = Modifier.height(16.dp))
//            FinanceSection()
//            CurrenciesSection()
    }
}
