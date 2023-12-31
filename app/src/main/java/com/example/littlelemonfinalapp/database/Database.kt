package com.example.littlelemonfinalapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Model::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {

    abstract fun appDao(): Dao

}