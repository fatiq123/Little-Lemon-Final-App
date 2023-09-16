package com.example.littlelemonfinalapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.room.Room
import com.example.littlelemonfinalapp.database.Database
import com.example.littlelemonfinalapp.network.Menu
import com.example.littlelemonfinalapp.panels.HomeScreen
import com.example.littlelemonfinalapp.panels.TopAppBar
import com.example.littlelemonfinalapp.panels.UpperPanel

@Composable
fun Home(navController: NavController) {

    val context = LocalContext.current

    val database by lazy {
        Room.databaseBuilder(
            context,
            Database::class.java,
            "app_database"
        ).build()
    }

    val databaseMenuItems by database.appDao().getAllData()
        .observeAsState()    // to retrieve data from database

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        TopAppBar(navController = navController)
//        UpperPanel(navController = navController)
        HomeScreen(navController = navController)
    }

}


/* to display home screen items */
@Composable
fun MenuItems(items: List<Menu>) {
    Column {

    }
}


@Preview
@Composable
fun PreviewHome() {
//    Home()

}