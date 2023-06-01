package com.example.openpay_challenge.usecases.movies

import com.example.openpay_challenge.data.repository.MovieRepository
import com.example.openpay_challenge.domain.models.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecommendedMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend fun invoke(page: Int, region: String): Flow<List<Movie>> =
        movieRepository.getRecommended(page, region)
}