package com.example.littlelemonfinalapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.littlelemonfinalapp.network.Network

@Dao
interface Dao {

    @Query("SELECT * FROM app_database")
    fun getAllData(): LiveData<List<Model>>

    @Insert
    fun insertAll(vararg model: Model)

    /*@Query("SELECT (SELECT COUNT(*) FROM Model) == 0")
    fun isEmpty(): Boolean*/

}