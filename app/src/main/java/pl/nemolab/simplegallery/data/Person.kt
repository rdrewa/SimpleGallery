package pl.nemolab.simplegallery.data

import com.google.gson.annotations.SerializedName


data class Person(
    @SerializedName("nsid")
    val nsId: String,
    @SerializedName("username")
    val userName: String,
    @SerializedName("realname")
    val realName: String,
    @SerializedName("favedate")
    val faveDate: String,
    @SerializedName("iconserver")
    val iconServer: String,
    @SerializedName("iconfarm")
    val iconFarm: Int,
    val contact: Int,
    val friend: Int,
    val family: Int
)