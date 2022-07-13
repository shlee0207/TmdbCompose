package com.junipapa.tmdbcompse.network

import com.junipapa.tmdbcompse.BuildConfig
import java.util.Locale
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url = originalUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .addQueryParameter("language", Locale.getDefault().language)
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
