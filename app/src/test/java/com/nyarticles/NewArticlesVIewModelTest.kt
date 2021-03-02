package com.nyarticles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.data.manager.DataManager
import com.data.repository.NewsArticleRepository
import com.nhaarman.mockitokotlin2.mock
import com.nyarticles.ui.news.NewArticleViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NewArticlesVIewModelTest {

    private lateinit var viewModel: NewArticleViewModel

    private lateinit var repository: NewsArticleRepository

    private val dataManager = mock<DataManager>()

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        repository = NewsArticleRepository(dataManager)
        viewModel = NewArticleViewModel(repository)
    }

    @Test
    fun loadNewsList() {

    }


}
