package com.example.littlelemonfinalapp

interface Destinations {
    val onBoarding: String
    val home: String
    val profile: String
}

object DestinationImp: Destinations {
    override val onBoarding: String
        get() = "onboarding"
    override val home: String
        get() = "home"
    override val profile: String
        get() = "profile"

}