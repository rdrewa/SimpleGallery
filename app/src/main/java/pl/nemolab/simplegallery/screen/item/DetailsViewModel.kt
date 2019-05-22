package pl.nemolab.simplegallery.screen.item

import androidx.lifecycle.ViewModel
import pl.nemolab.simplegallery.data.Photo

class DetailsViewModel: ViewModel() {

    var photo: Photo? = null

    fun getPublicVisibility() = photo?.isPublic != 0

    fun getFamilyVisibility() = photo?.isFamily != 0

    fun getFriendVisibility() = photo?.isFriend != 0

    fun getUrlImage() = photo?.url

    fun onViewCreated() {

    }
}