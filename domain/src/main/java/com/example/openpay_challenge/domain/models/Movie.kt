package com.example.openpay_challenge.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Movie (
    val movieId: Long,
    val backdropPath: String? = null,
    val originalLanguage: String,
    val title: String,
    val overview: String,
    val posterPath: String? = null,
    val releaseDate: String,
    val voteAverage: Float,
    var list: String? = null
): Parcelable
