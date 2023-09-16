package com.example.littlelemonfinalapp.network

import com.example.littlelemonfinalapp.database.Model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Menu(
    @SerialName("category")
    val category: String,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("price")
    val price: String,
    @SerialName("title")
    val title: String
) {
    fun toModel() = Model (
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        title = title
    )
    /*The toMenuItem function should use all of the properties of the MenuNetwork class and return an
    instance of the MenuItem class that can be saved to the database.*/
}