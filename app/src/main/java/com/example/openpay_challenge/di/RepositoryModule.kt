package com.example.openpay_challenge.di

import com.example.openpay_challenge.data.repository.MovieRepository
import com.example.openpay_challenge.data.repository.MoviesRepositoryImpl
import com.example.openpay_challenge.data.repository.ProfileRepository
import com.example.openpay_challenge.data.repository.ProfileRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun providesMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MovieRepository = moviesRepositoryImpl

    @Provides
    fun providesProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository = profileRepositoryImpl

}