package com.lesteban.remesitadevapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lesteban.remesitadevapp.R
import com.lesteban.remesitadevapp.data.model.Item
import com.lesteban.remesitadevapp.data.model.ItemsCard
import com.lesteban.remesitadevapp.data.model.view.Card
import com.lesteban.remesitadevapp.ui.screens.start.StartViewModel
import com.lesteban.remesitadevapp.ui.theme.BlueEnd
import com.lesteban.remesitadevapp.ui.theme.BlueStart
import com.lesteban.remesitadevapp.ui.theme.GreenEnd
import com.lesteban.remesitadevapp.ui.theme.GreenStart
import com.lesteban.remesitadevapp.ui.theme.PurpleEnd
import com.lesteban.remesitadevapp.ui.theme.PurpleStart
import com.lesteban.remesitadevapp.utils.PreferencesManager
import com.lesteban.remesitadevapp.utils.network.DataState
import com.lesteban.remesitadevapp.utils.round

var cards: List<Item> = emptyList()

@Composable
fun CardsSection(startViewModel: StartViewModel) {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val data = remember { mutableStateOf(preferencesManager.getDataKey("myKey", "")) }

    if (startViewModel.cardsRem.value is DataState.Success<ItemsCard>) {
        cards = (startViewModel.cardsRem.value as DataState.Success<ItemsCard>).data.items

        startViewModel.getTransactions(data, cards[0].number,1,10)

        LazyRow {
            items(cards.size) { index ->
                CardItem(index)
            }
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    val image = painterResource(id = R.drawable.ic_visa)
//    if ("VISA") {
//        image = painterResource(id = R.drawable.ic_mastercard)
//    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(getGradient(BlueStart, BlueEnd))
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = image,
                contentDescription = card.alias,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.alias,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$ ${card.balanceUSD.round(2)}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = if (card.status == "enabled") "Habilitada" else "Desabilitada",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}


