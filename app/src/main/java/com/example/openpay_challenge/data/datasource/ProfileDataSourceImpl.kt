package com.example.openpay_challenge.data.datasource

import com.example.openpay_challenge.api.ProfileService
import com.example.openpay_challenge.data.mappers.toModel
import com.example.openpay_challenge.data.util.Result
import com.example.openpay_challenge.data.util.safeApiCall
import com.example.openpay_challenge.domain.models.Profile
import javax.inject.Inject

class ProfileDataSourceImpl @Inject constructor(
    private val profileService: ProfileService
) : ProfileDataSource {

    override suspend fun getProfile(): Result<Profile> {
        return safeApiCall {
            profileService.getProfile().toModel()
        }
    }
}