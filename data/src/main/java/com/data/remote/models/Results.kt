package com.data.remote.models

import com.squareup.moshi.Json


data class Results(
    @Json(name = "status")
    private val status: String,

    @Json(name = "copyright")
    private val copyright: String,

    @Json(name = "num_results")
    private val numResults: Int,

    @Json(name = "results")
    private val results: List<NewsArticle>? = null
)
