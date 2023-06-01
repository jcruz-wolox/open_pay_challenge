package com.example.openpay_challenge.usecases.movies

import com.example.openpay_challenge.data.repository.MovieRepository
import com.example.openpay_challenge.domain.models.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    fun invoke(): Flow<List<Movie>> =
        movieRepository.getMovies()
}