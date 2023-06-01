package com.example.openpay_challenge.data.datasource

import android.graphics.Bitmap
import android.net.Uri
import kotlinx.coroutines.Deferred

interface FirebaseDataSource {
    suspend fun uploadPhotoAsync(image: Bitmap): Deferred<Boolean>
    suspend fun uploadPhotoAsync(uri: Uri): Deferred<Boolean>
}