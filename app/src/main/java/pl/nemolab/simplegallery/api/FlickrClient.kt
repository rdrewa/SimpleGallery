package pl.nemolab.simplegallery.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.nemolab.simplegallery.rest.LiveDataCallAdapterFactory
import pl.nemolab.simplegallery.rest.LiveDataResponseBodyConverterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FlickrClient {
    val service: FlickrService
    get() {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(ParametersInterceptor(prepareConfiguration()))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(FlickrService.BASE_URL)
            .client(client)
            .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
            .addConverterFactory(LiveDataResponseBodyConverterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(FlickrService::class.java)
    }

    private fun prepareConfiguration() = mapOf(
        "api_key" to FlickrService.API_KEY,
        "format" to "json",
        "nojsoncallback" to "1"
        )
}