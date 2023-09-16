package com.example.littlelemonfinalapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.littlelemonfinalapp.database.Database
import com.example.littlelemonfinalapp.network.Menu
import com.example.littlelemonfinalapp.network.Network
import com.example.littlelemonfinalapp.ui.theme.LittleLemonFinalAppTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json

class MainActivity : ComponentActivity() {



    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }


    private val sharedPrefsKey = "onboarding_completed"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonFinalAppTheme {

                val navController = rememberNavController()

                val onboardingCompleted = getOnboardingCompletedFlag()
                val startDestination = if (onboardingCompleted) {
                    DestinationImp.home
                } else {
                    DestinationImp.onBoarding
                }

                NavHost(navController = navController, startDestination = startDestination) {
                    composable(DestinationImp.onBoarding) {
                        Onboarding(navController)
                    }
                    composable(DestinationImp.home) {
                        Home(navController)
                    }
                    composable(DestinationImp.profile) {
                        Profile(navController)
                    }
                    // Add more composable entries for other destinations as needed
                }
            }
        }
    }


    private fun getOnboardingCompletedFlag(): Boolean {
        val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean(sharedPrefsKey, false)
    }

    fun setOnboardingCompletedFlag() {
        val sharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(sharedPrefsKey, true)
        editor.apply()
    }


    // fetching response from server
    private suspend fun fetchData(): List<Menu> {
        val url =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
        val menuNetwork = httpClient.get(url).body<Network>()
        return menuNetwork.menu
    }

    private fun saveMenuToDatabase(menu: List<Menu>) {
        val menuItemsRoom = menu.map {
            it.toMenuItem()
        }

    }
}



