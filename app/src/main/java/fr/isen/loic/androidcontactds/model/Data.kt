package fr.isen.loic.androidcontactds.model

import java.io.Serializable

data class Data(
    var results: Array<Personne>
) : Serializable
