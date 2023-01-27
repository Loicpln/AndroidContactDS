package fr.isen.loic.androidcontactds.model

import java.io.Serializable

data class Registered(
    var date: String,
    var age: Int
) : Serializable
