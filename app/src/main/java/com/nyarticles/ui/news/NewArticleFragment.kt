package com.nyarticles.ui.news

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.data.local.models.State
import com.data.remote.models.NewsArticle
import com.nyarticles.BR
import com.nyarticles.R
import com.nyarticles.databinding.FragmentNewsArticleBinding
import com.nyarticles.ui.base.BaseFragment
import com.nyarticles.ui.news.adapter.ListingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewArticleFragment :
    BaseFragment<NewArticleViewModel, FragmentNewsArticleBinding>(R.layout.fragment_news_article) {

    private val newsArticleListAdapter: ListingAdapter by lazy {
        ListingAdapter { newArticle ->
            run {
            }
        }
    }

    override val viewModel: NewArticleViewModel by viewModels()

    override fun getBindingVariable(): Int {
        return BR.newsArticle
    }

    override fun onInitDataBinding() {
        updateProgress()
        viewModel.getMostViewedNYTimePopularArticle();
        bindings.recyclerResults.adapter = newsArticleListAdapter
        bindings.recyclerResults.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val lastPosition = layoutManager.findLastVisibleItemPosition()
                if (lastPosition == newsArticleListAdapter.itemCount - 1) {
                    bindings.recyclerResults.post {
                        /*viewModel.isPerformingNextQuery = true
                        viewModel.searchNextPage()*/
                    }
                }
            }
        })
        viewModel.newsLiveData.observe(viewLifecycleOwner, Observer {
            val copy: List<NewsArticle> = ArrayList(it)
            newsArticleListAdapter.submitList(copy)
        })

        bindings.searchAgainBtn.setOnClickListener {
            val newPeriod = bindings.periodEt.text?.trim().toString()
            newPeriod.takeIf { it.isNotEmpty() }.let {
                viewModel.getMostViewedNYTimePopularArticle(newPeriod.toInt());
            }
        }

        bindings.pullToRefresh.setOnRefreshListener {
            bindings.pullToRefresh.isRefreshing = false
            viewModel.getMostViewedNYTimePopularArticle();
        }

        bindings.button.setOnClickListener {
            val newPeriod = bindings.periodEt.text?.trim().toString()
            newPeriod.takeIf { it.isNotEmpty() }.let {
                viewModel.getMostViewedNYTimePopularArticle(newPeriod.toInt());
            }
        }
    }


    private fun updateProgress() {
        viewModel.newsUiLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is State.Success -> {
                    hideProgress()
                }
                is State.Error -> {
                    hideProgress()
                }
                is State.Loading -> {
                    showProgress()
                }
            }
        })
    }
}

