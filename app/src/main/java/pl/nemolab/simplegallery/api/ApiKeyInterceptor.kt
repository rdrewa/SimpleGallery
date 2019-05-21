package pl.nemolab.simplegallery.api

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val keyName: String, private val keyValue: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(keyName, keyValue)
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}