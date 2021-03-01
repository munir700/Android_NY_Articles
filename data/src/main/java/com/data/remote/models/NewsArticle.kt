package com.data.remote.models

import com.squareup.moshi.Json


data class NewsArticle(
    @Json(name = "uri")
    val uri: String,

    @Json(name = "url")
    val url: String,

    @Json(name = "id")
    val id: Long,

    @Json(name = "asset_id")
    val assetId: Long,

    @Json(name = "source")
    val source: String,

    @Json(name = "published_date")
    val publishedDate: String,

    @Json(name = "updated")
    val updated: String,

    @Json(name = "section")
    val section: String,

    @Json(name = "subsection")
    val subsection: String,

    @Json(name = "nytdsection")
    val nytdsection: String,

    @Json(name = "adx_keywords")
    val adxKeywords: String,

    @Json(name = "column")
    val column: Any?,

    @Json(name = "byline")
    val byline: String,

    @Json(name = "type")
    val type: String,

    @Json(name = "title")
    val title: String,

    @Json(name = "abstract")
    val abstract: String,

    @Json(name = "des_facet")
    val desFacet: List<String>? = null,

    @Json(name = "org_facet")
    val orgFacet: List<String>? = null,

    @Json(name = "per_facet")
    val perFacet: List<String>? = null,

    @Json(name = "geo_facet")
    val geoFacet: List<String>? = null,

    @Json(name = "media")
    val media: List<Media>? = null,

    @Json(name = "eta_id")
    val etaId: Int
) 
