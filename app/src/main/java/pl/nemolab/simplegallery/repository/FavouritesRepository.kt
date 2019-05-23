package pl.nemolab.simplegallery.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import pl.nemolab.simplegallery.api.FlickrClient
import pl.nemolab.simplegallery.data.FavouritesResponse
import pl.nemolab.simplegallery.data.Photo
import pl.nemolab.simplegallery.data.Photos
import pl.nemolab.simplegallery.data.RecentResponse

object FavouritesRepository {

    private var flickrService = FlickrClient.service

    fun getList(photoId: Int): LiveData<FavouritesResponse> = Transformations.map(flickrService.getFavourites(photoId)) {
        val response = FavouritesResponse(Photo(emptyList(), "", "", "", "", 0, "", 0, 0, 0, "", ""), "")
        if (it.isSuccess) {
            it?.data?.let {
                response.photo = it.photo
                response.stat = it.stat
            }
        }
        response
    }
}