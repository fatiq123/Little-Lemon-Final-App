package com.example.littlelemonfinalapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.littlelemonfinalapp.database.Database
import com.example.littlelemonfinalapp.database.Model
import com.example.littlelemonfinalapp.network.Menu
import com.example.littlelemonfinalapp.network.Network
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val database: Database

    init {
        database = Room.databaseBuilder(
            application,
            Database::class.java,
            "database"
        ).build()
    }

    fun getAllDatabaseMenuItems(): LiveData<List<Model>> {
        return database.appDao().getAllData()
    }

    // this function is used to store the data in database locally if internet is not available

    fun fetchMenuDataIfNeeded() {
        viewModelScope.launch(Dispatchers.IO) {
            if (database.appDao().isEmpty()) {
                saveMenuToDatabase(
                    database,
                    fetchMenu("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
                )

            }
        }
    }
}


suspend fun fetchMenu(url: String): List<Menu> {
    val httpClient = HttpClient(Android){
        install(ContentNegotiation){
            json(contentType = ContentType("text", "plain"))
        }
    }
    val  httpResponse: Network = httpClient.get(url).body()
    return httpResponse.menu
}


fun saveMenuToDatabase(database: Database, menu: List<Menu>) {
    val menuItemsRoom = menu.map {
        it.toModel()
    }
    database.appDao().insertAll(*menuItemsRoom.toTypedArray())

}