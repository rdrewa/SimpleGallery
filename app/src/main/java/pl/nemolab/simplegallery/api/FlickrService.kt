package pl.nemolab.simplegallery.api

import androidx.lifecycle.LiveData
import pl.nemolab.simplegallery.data.RecentResponse
import pl.nemolab.simplegallery.rest.Response
import retrofit2.http.GET

interface FlickrService {

    companion object {
        const val BASE_URL = "https://api.flickr.com/services/rest/"
        const val API_KEY = "b0d46110ce0f3b6c934c4f8e984a5dd0"
    }

    @GET("?method=flickr.photos.getRecent&extras=url_s")
    fun getRecent(): LiveData<Response<RecentResponse>>
}