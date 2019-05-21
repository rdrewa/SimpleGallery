package pl.nemolab.simplegallery.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import pl.nemolab.simplegallery.api.FlickrClient
import pl.nemolab.simplegallery.data.Photo
import pl.nemolab.simplegallery.data.Photos
import pl.nemolab.simplegallery.data.RecentResponse
import retrofit2.Response

object PhotoRepository {

    private var flickrService = FlickrClient.service

    fun getRecent(): LiveData<RecentResponse> = Transformations.map(flickrService.getRecent()) {
        val response = RecentResponse(Photos(0, 0, 0, 0, emptyList()), "")
        if (it.isSuccess) {
            it?.data?.let {
                response.photos = it.photos
                response.stat = it.stat
            }
        }
        response
    }
}