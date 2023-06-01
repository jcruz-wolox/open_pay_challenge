package com.example.openpay_challenge.interceptors

import com.example.openpay_challenge.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * intercepts request to add api key *
 */
class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url().newBuilder().addQueryParameter("api_key", BuildConfig.TMDB_API_KEY).build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}