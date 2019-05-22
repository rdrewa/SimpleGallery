package pl.nemolab.simplegallery.api

import okhttp3.Interceptor
import okhttp3.Response

class ParametersInterceptor(private val parameters: Map<String, String>): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val builder = originalHttpUrl.newBuilder()
        parameters.forEach {
            builder.addQueryParameter(it.key, it.value)
        }
        val url = builder.build()

        val requestBuilder = original
            .newBuilder()
            .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}