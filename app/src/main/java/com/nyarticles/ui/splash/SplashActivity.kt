package com.nyarticles.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.core.utils.launchActivity
import com.nyarticles.R
import com.nyarticles.ui.news.NewsArticleActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycleScope.launch {
            delay(1000)
            launchActivity(this@SplashActivity, NewsArticleActivity::class.java, true)
        }
    }
}