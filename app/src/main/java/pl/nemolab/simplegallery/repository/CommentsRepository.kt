package pl.nemolab.simplegallery.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import pl.nemolab.simplegallery.api.FlickrClient
import pl.nemolab.simplegallery.data.Comments
import pl.nemolab.simplegallery.data.CommentsResponse

object CommentsRepository {

    private var flickrService = FlickrClient.service

    fun getList(photoId: Int): LiveData<CommentsResponse> = Transformations.map(flickrService.getComments(photoId)) {
        val response = CommentsResponse(Comments("", emptyList()), "")
        if (it.isSuccess) {
            it?.data?.let {
                response.comments = it.comments
                response.stat = it.stat
            }
        }
        response
    }
}