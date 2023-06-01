package com.example.openpay_challenge.usecases.profile

import com.example.openpay_challenge.data.repository.ProfileRepository
import com.example.openpay_challenge.domain.models.Profile
import javax.inject.Inject

class GetProfileUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend fun invoke(): Profile? =
        profileRepository.getProfile()
}