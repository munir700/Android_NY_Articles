package com.data.remote.models

import com.squareup.moshi.Json

data class MediaMetadata(
    @Json(name = "url")
    val url: String,
    @Json(name = "format")
    val format: String,
    @Json(name = "height")
    val height: Int,
    @Json(name = "width")
    val width: Int
)