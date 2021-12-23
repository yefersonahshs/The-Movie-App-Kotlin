package com.example.movieappservinformacion.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Movie {
    @JvmField
    @SerializedName("id")
    @Expose
    var id: String? = null

    @JvmField
    @SerializedName("title")
    @Expose
    var title: String? = null

    @JvmField
    @SerializedName("poster_path")
    @Expose
    var poster: String? = null

    @JvmField
    @SerializedName("release_date")
    @Expose
    var release: String? = null

    @JvmField
    @SerializedName("overview")
    @Expose
    var overview: String? = null

    @JvmField
    @SerializedName("popularity")
    @Expose
    var popularity: String? = null

    @JvmField
    @SerializedName("vote_average")
    @Expose
    var vote_average: String? = null

    constructor(
        id: String?,
        title: String?,
        poster: String?,
        release: String?,
        overview: String?,
        popularity: String?,
        vote_average: String?
    ) {
        this.id = id
        this.title = title
        this.poster = poster
        this.release = release
        this.overview = overview
        this.popularity = popularity
        this.vote_average = vote_average
    }

    constructor() {}
}