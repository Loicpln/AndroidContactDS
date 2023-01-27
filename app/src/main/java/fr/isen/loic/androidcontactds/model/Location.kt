package fr.isen.loic.androidcontactds.model

import java.io.Serializable

data class Location(
    var street: Street,
    var city: String,
    var state: String,
    var country: String,
    var postcode: String,
    var coordinates: Coordinates,
    var timezone: Timezone
) : Serializable
