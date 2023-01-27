package fr.isen.loic.androidcontactds.model

import java.io.Serializable

data class Picture(
    var large: String,
    var medium: String,
    var thumbnail: String
) : Serializable
