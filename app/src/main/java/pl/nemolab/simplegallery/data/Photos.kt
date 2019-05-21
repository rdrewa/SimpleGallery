package pl.nemolab.simplegallery.data

import com.google.gson.annotations.SerializedName


data class Photos(
    val page: Int,
    val pages: Int,
    @SerializedName("perpage")
    val perPage: Int,
    val total: Int,
    val photo: List<Photo>
)