package com.lesteban.remesitadevapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lesteban.remesitadevapp.R
import com.lesteban.remesitadevapp.data.model.transactions.Item
import com.lesteban.remesitadevapp.data.model.transactions.ItemsTransaction
import com.lesteban.remesitadevapp.ui.screens.start.StartViewModel
import com.lesteban.remesitadevapp.ui.theme.BlueEnd
import com.lesteban.remesitadevapp.ui.theme.BlueStart
import com.lesteban.remesitadevapp.ui.theme.GreyEnd
import com.lesteban.remesitadevapp.ui.theme.GreyStart
import com.lesteban.remesitadevapp.ui.theme.OrangeEnd
import com.lesteban.remesitadevapp.ui.theme.OrangeEndLow
import com.lesteban.remesitadevapp.ui.theme.OrangeStart
import com.lesteban.remesitadevapp.ui.theme.Purple80
import com.lesteban.remesitadevapp.ui.theme.PurpleGrey80
import com.lesteban.remesitadevapp.utils.network.DataState
import com.lesteban.remesitadevapp.utils.round

var cardsTra: List<Item> = emptyList()
@Composable
fun TransactionsSection(startViewModel: StartViewModel) {

    Text(modifier = Modifier.padding(start = 12.dp, bottom = 4.dp),text = "Últimas transacciones")

    if (startViewModel.transRem.value is DataState.Success<ItemsTransaction>) {
        cardsTra = (startViewModel.transRem.value as DataState.Success<ItemsTransaction>).data.items

        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            items(cardsTra.size) { index ->
                CardItemTransaction(index)
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun CardItemTransaction(
    index: Int
) {
    val card = cardsTra[index]
    var brush  = getGradient(GreyStart, OrangeEndLow)
    if (card.type == "CRD"){
        brush  = getGradient(GreyStart, GreyEnd)
    }

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(brush)
                .clickable {}
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 8.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = if (card.type == "CRD") "CRÉDITO" else "DÉBITO",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = card.date,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = "$ "+ card.amountUSD,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )

            Text(
                text = card.payee,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
    }
}