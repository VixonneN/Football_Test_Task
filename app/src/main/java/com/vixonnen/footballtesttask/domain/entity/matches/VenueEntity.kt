package com.vixonnen.footballtesttask.domain.entity.matches


data class VenueEntity(
    val venue_id: Int,
    val name: String,
    val capacity: Int,
    val city: String,
    val country_id: Int
) {

}
