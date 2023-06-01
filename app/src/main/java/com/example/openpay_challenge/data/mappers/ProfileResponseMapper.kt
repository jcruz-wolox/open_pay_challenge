package com.example.openpay_challenge.data.mappers

import com.example.openpay_challenge.domain.models.Profile
import com.example.openpay_challenge.domain.models.RatedMovie
import com.example.openpay_challenge.domain.models.responses.ProfileResponse
import com.example.openpay_challenge.domain.models.responses.RatedMovieResponse

fun ProfileResponse.toModel() =
    Profile(
        this.user,
        this.creation,
        this.ratedMovies.map { it.toModel() }
    )

fun RatedMovieResponse.toModel() =
    RatedMovie(
        this.movieId,
        this.title,
        this.posterPath,
        this.rate
    )