package com.example.openpay_challenge.data.datasource

import com.example.openpay_challenge.data.util.Result
import com.example.openpay_challenge.domain.models.Movie

interface MoviesRemoteDataSource {
    suspend fun getTopRatedMovies(page: Int): Result<List<Movie>>
    suspend fun getMovieTrailer(movieId: String): Result<List<String>>
    suspend fun getPopularMovies(page: Int): Result<List<Movie>>
    suspend fun getRecommendedMovies(page: Int, region: String): Result<List<Movie>>
}