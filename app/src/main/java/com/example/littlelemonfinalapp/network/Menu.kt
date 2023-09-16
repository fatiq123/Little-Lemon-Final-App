package com.example.littlelemonfinalapp.network

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
    fun toMenuItem() = Menu (
        category,
        description,
        id,
        image,
        price,
        title
    )
    /*The toMenuItem function should use all of the properties of the MenuNetwork class and return an
    instance of the MenuItem class that can be saved to the database.*/
}