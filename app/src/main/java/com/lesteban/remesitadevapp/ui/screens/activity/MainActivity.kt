package com.lesteban.remesitadevapp.ui.screens.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.lesteban.remesitadevapp.data.datasource.ApiResult
import com.lesteban.remesitadevapp.navigation.BottomNavigationBar
import com.lesteban.remesitadevapp.ui.component.CardsSection
import com.lesteban.remesitadevapp.ui.component.WalletSection
import com.lesteban.remesitadevapp.ui.screens.home.HomeScreen
import com.lesteban.remesitadevapp.ui.theme.RemesitaDevAppTheme
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val userViewModel by viewModels<UserViewModel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = User(first_name = "Rollito", last_name = "ricaperri", email = "rolli@gmail.com")
//        userViewModel.insert(user)
        userViewModel.realtimeUserDB()
        observeData()
        enableEdgeToEdge()
        setContent {
            RemesitaDevAppTheme {
                SetBarColor(color = MaterialTheme.colorScheme.background)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }

    private fun observeData(){
        lifecycleScope.launch {
            userViewModel.uiState.collectLatest {data ->
                when(data){
                    is ApiResult.Error -> {
                        Log.e("MainActivity",data.message.toString())
                    }
                    ApiResult.Loading -> {
                        Log.e("MainActivity","Loading")
                    }
                    is ApiResult.Success -> {
                        val users = data.data as List<*>
                        users.forEach{
                            Log.e("MainActivity",it.toString())
                        }
                    }
                }
            }
        }
    }


    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@Serializable
data class User(
    val id: Int = 0,
    val first_name: String = "",
    val last_name: String = "",
    val email: String = "",
)