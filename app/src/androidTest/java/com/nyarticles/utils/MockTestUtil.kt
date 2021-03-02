package com.nyarticles.utils

import com.data.remote.models.NewsArticle

class MockTestUtil {
    companion object {
        fun mockNewsArticle() = NewsArticle(
            "", "", 0, 0, "", "", "", "", "", "", "", "",
            "", "", "", "", null, null, null, null, null, 0
        )
    }
}
