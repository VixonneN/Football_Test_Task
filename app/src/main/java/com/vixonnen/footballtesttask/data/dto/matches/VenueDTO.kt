package com.vixonnen.footballtesttask.data.dto.matches


data class VenueDTO(
    val venue_id: Int,
    val name: String,
    val capacity: Int,
    val city: String,
    val country_id: Int
) {

}
