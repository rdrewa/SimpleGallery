package pl.nemolab.simplegallery.screen.item

import androidx.lifecycle.ViewModel
import pl.nemolab.simplegallery.data.Photo

class DetailsViewModel: ViewModel() {

    lateinit var photo: Photo

    val isPublicVisibility = photo.isPublic != 0

    val isFamilyVisibility = photo.isFamily != 0

    val isFriendVisibility = photo.isFriend != 0

    val url = photo.url

    fun onViewCreated() {

    }
}