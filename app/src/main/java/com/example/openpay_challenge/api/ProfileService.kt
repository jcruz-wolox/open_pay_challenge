package com.example.openpay_challenge.api

import com.example.openpay_challenge.domain.models.responses.ProfileResponse
import retrofit2.http.GET

interface ProfileService {
    @GET("edbd6efc-4961-40f5-962d-c13f069ec235")
    suspend fun getProfile(): ProfileResponse
}