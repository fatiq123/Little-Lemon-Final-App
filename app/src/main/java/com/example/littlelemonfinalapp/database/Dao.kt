package com.example.littlelemonfinalapp.database

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.littlelemonfinalapp.network.Network

interface Dao {

    @Query("SELECT * FROM app_database")
    fun getAllData(): LiveData<List<Network>>



}