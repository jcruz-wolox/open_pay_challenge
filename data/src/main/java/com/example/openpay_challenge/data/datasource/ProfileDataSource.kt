package com.example.openpay_challenge.data.datasource

import com.example.openpay_challenge.data.util.Result
import com.example.openpay_challenge.domain.models.Profile

interface ProfileDataSource {
    suspend fun getProfile(): Result<Profile>
}