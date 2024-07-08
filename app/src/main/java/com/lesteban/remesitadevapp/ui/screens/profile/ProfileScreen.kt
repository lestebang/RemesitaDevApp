package com.lesteban.remesitadevapp.ui.screens.profile

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.sharp.CreditCard
import androidx.compose.material.icons.sharp.Elevator
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.FormatColorText
import androidx.compose.material.icons.sharp.Language
import androidx.compose.material.icons.sharp.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.lesteban.remesitadevapp.R
import com.lesteban.remesitadevapp.data.domain.UserData
import com.lesteban.remesitadevapp.ui.theme.BlueEnd
import com.lesteban.remesitadevapp.ui.theme.BlueStart
import com.lesteban.remesitadevapp.ui.theme.PurpleGrey40


@Preview(device = "id:Nexus S", showSystemUi = true, showBackground = true)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val profileViewModel = hiltViewModel <ProfileViewModel>()
    LaunchedEffect(key1 = true) {
        profileViewModel.getUser()
    }

    if (profileViewModel.userEnt.value?.isNotEmpty() == true){
        val userData: UserData = profileViewModel.userEnt.value!![0]
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(46.dp))
            AsyncImage(
                model = userData.pictureUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(32.dp))

            Column(
                horizontalAlignment = Alignment.Start
            ) {

                Row(modifier = Modifier) {
                    Icon(imageVector = Icons.Sharp.FormatColorText, contentDescription = "Name", modifier = Modifier
                        .height(22.dp)
                        .padding(top = 6.dp), tint = BlueStart)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = userData.name,Modifier.padding(top = 4.dp),color = BlueStart, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Icon(imageVector = Icons.Sharp.Email, contentDescription = "Correo", modifier = Modifier
                        .height(24.dp)
                        .padding(top = 8.dp), tint = BlueStart)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = userData.email,Modifier.padding(top = 4.dp),color = BlueStart, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Icon(imageVector = Icons.Sharp.Phone, contentDescription = "Telefono", modifier = Modifier
                        .height(24.dp)
                        .padding(top = 8.dp), tint = BlueStart)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = userData.phone,Modifier.padding(top = 4.dp),color = BlueStart, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Icon(imageVector = Icons.Sharp.Elevator, contentDescription = "level", modifier = Modifier
                        .height(24.dp)
                        .padding(top = 8.dp), tint = BlueStart)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = userData.level,Modifier.padding(top = 4.dp),color = BlueStart, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Icon(imageVector = Icons.Sharp.CreditCard, contentDescription = "Tarjeta", modifier = Modifier
                        .height(24.dp)
                        .padding(top = 8.dp), tint = BlueStart)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = userData.mainCard,Modifier.padding(top = 4.dp),color = BlueStart, fontWeight = FontWeight.Bold)
                }
            }
        }
    }else{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "No hay datos",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
            )
        }
    }
}