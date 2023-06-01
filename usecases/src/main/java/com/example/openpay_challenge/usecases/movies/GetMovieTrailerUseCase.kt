package com.example.openpay_challenge.usecases.movies

import com.example.openpay_challenge.data.repository.MovieRepository
import javax.inject.Inject

class GetMovieTrailerUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend fun invoke(movieId: String): String? =
        movieRepository.getMovieTrailer(movieId)
}