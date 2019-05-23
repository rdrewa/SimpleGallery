package pl.nemolab.simplegallery.data


import com.google.gson.annotations.SerializedName

data class Comment(
    val id: String,
    val author: String,
    @SerializedName("author_is_deleted")
    val authorIsDeleted: Int,
    @SerializedName("authorname")
    val authorName: String,
    @SerializedName("iconserver")
    val iconServer: String,
    @SerializedName("iconfarm")
    val iconFarm: Int,
    @SerializedName("datecreate")
    val dateCreate: String,
    @SerializedName("permalink")
    val permaLink: String,
    @SerializedName("path_alias")
    val pathAlias: String,
    @SerializedName("realname")
    val realName: String,
    @SerializedName("_content")
    val content: String
)