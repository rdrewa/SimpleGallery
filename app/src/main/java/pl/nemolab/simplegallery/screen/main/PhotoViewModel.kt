package pl.nemolab.simplegallery.screen.main

import pl.nemolab.simplegallery.data.Photo

class PhotoViewModel(private val photo: Photo, private val clickAction: (Photo) -> (Unit)) {

    val urlImage = photo.url

    fun onClick() = clickAction.invoke(photo)
}