package com.example.openpay_challenge.data.mappers

import com.example.openpay_challenge.domain.models.Movie
import com.example.openpay_challenge.domain.models.responses.MovieResponse

fun MovieResponse.mapToModel() =
    Movie(
        id,
        backdropPath,
        originalLanguage,
        title,
        overview,
        posterPath,
        releaseDate,
        voteAverage
    )
