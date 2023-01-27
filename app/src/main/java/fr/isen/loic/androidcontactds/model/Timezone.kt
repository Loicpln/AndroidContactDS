package fr.isen.loic.androidcontactds.model

import java.io.Serializable

data class Timezone(
    var offset: String,
    var description: String
) : Serializable
