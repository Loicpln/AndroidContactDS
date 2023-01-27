package fr.isen.loic.androidcontactds.model

import java.io.Serializable

data class Street(
    var number: Int,
    var name: String
) : Serializable
