package com.nyarticles.ui.news

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

import com.nyarticles.BR
import com.nyarticles.R
import com.nyarticles.databinding.ActivityNewsArticleBinding
import com.nyarticles.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_news_article.*

@AndroidEntryPoint
class NewsArticleActivity :
    BaseActivity<NewArticleViewModel, ActivityNewsArticleBinding>(R.layout.activity_news_article) {

    private lateinit var navController: NavController

    override val viewModel: NewArticleViewModel by viewModels()

    override fun getBindingVariable(): Int {
        return BR._all
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController(R.id.nav_host_fragment)
        //setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}