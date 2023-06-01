package com.example.openpay_challenge.data.repository

import com.example.openpay_challenge.domain.models.Profile

interface ProfileRepository {
    suspend fun getProfile(): Profile?
}