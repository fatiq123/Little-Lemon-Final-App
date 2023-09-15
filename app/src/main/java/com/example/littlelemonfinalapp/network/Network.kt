package com.example.littlelemonfinalapp.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Network(
    @SerialName("menu")
    val menu: List<Menu>
)