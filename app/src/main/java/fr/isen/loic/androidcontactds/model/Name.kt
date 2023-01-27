package fr.isen.loic.androidcontactds.model

import java.io.Serializable

data class Name(
    var title: String,
    var first: String,
    var last: String
) : Serializable
