package com.example.littlelemonfinalapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity(tableName = "app_database")
data class Model(
    @SerialName("category")
    val category: String,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("price")
    val price: String,
    @SerialName("title")
    val title: String
)
