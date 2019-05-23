package pl.nemolab.simplegallery.data


import com.google.gson.annotations.SerializedName

data class Comments(
    @SerializedName("photo_id")
    var photoId: String,
    var comment: List<Comment>
)