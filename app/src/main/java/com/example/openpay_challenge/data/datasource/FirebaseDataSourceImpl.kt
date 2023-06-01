package com.example.openpay_challenge.data.datasource

import android.graphics.Bitmap
import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.CompletableDeferred
import java.io.ByteArrayOutputStream
import java.util.*
import javax.inject.Inject


class FirebaseDataSourceImpl @Inject constructor(
    private val storage: FirebaseStorage
) : FirebaseDataSource {
    override suspend fun uploadPhotoAsync(image: Bitmap): CompletableDeferred<Boolean> {
        return CompletableDeferred<Boolean>().apply {
            val imageRef: StorageReference =
                storage.reference.child("$DEFAULT_PATH_STORAGE/${getRandomName()}")
            imageRef.putBytes(bitmapToByte(image))
                .addOnSuccessListener { _ ->
                    this.complete(true)

                }.addOnFailureListener {
                    it.printStackTrace()
                    this.complete(false)
                }
        }
    }

    override suspend fun uploadPhotoAsync(uri: Uri): CompletableDeferred<Boolean> {
        return CompletableDeferred<Boolean>().apply {
            val imageRef: StorageReference =
                storage.reference.child("$DEFAULT_PATH_STORAGE/${getRandomName()}")
            imageRef.putFile(uri)
                .addOnSuccessListener { _ ->
                    this.complete(true)

                }.addOnFailureListener {
                    it.printStackTrace()
                    this.complete(false)
                }
        }
    }

    private fun bitmapToByte(bitmap: Bitmap): ByteArray {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()
        return data
    }

    private fun getRandomName(): String {
        return UUID.randomUUID().toString()
    }

    companion object {
        private const val DEFAULT_PATH_STORAGE = "media"
    }

}