package com.nyarticles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.data.local.models.ResponsePacket
import com.data.local.models.State
import com.data.remote.models.NewsArticle
import com.data.repository.NewsArticleRepository
import com.nyarticles.ui.news.NewArticleViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NewsArticlesViewModelTest {

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var newsArticleRepository: NewsArticleRepository

    private lateinit var newArticleViewModel: NewArticleViewModel

    @Before
    @ExperimentalCoroutinesApi
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(TestCoroutineDispatcher())
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test_getNewsArticlesViewModelResult() {
        runBlocking {
            val observer = mockk<State<ResponsePacket<List<NewsArticle>>>>(relaxed = true)
            ////coEvery { newsArticleRepository.getMostViewedNYTimePopularArticle() } else

        }
    }

}