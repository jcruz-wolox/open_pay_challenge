package com.example.openpay_challenge.data.mappers

import com.example.openpay_challenge.domain.models.Movie
import com.example.openpay_challenge.domain.models.entitities.MovieEntity

fun MovieEntity.mapToModel() =
    Movie(
        movieId,
        backdropPath,
        originalLanguage,
        title,
        overview,
        posterPath,
        releaseDate,
        voteAverage
    )


fun Movie.mapToEntity() =
    MovieEntity(
        movieId,
        backdropPath,
        originalLanguage,
        title,
        overview,
        posterPath,
        releaseDate,
        voteAverage
    )
