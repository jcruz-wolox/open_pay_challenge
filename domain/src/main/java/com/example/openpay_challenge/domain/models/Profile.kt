package com.example.openpay_challenge.domain.models

data class Profile(
    val user: String,
    val creation: Long,
    val ratedMovies: List<RatedMovie>
)