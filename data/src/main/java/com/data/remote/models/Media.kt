package com.data.remote.models

import com.squareup.moshi.Json

data class Media(
    @Json(name = "type")
    val type: String,
    @Json(name = "subtype")
    val subtype: String,
    @Json(name = "caption")
    val caption: String,
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "approved_for_syndication")
    val approvedForSyndication: Int,
    @Json(name = "media-metadata")
    val mediaMetadata: List<MediaMetadata>? = null
)
