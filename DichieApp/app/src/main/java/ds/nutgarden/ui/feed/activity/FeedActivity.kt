package ds.nutgarden.ui.feed.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.R
import ds.nutgarden.data.model.Feed
import ds.nutgarden.ui.feed.adapter.FeedAdapter
import ds.nutgarden.viewmodel.FeedListViewModel
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.dialog_add_feed.view.*

class FeedActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(FeedListViewModel::class.java) }

    private var feedAdapter = FeedAdapter(emptyList()) {
        showFeedDetail(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        initView()
        observeViewModel()
        setListener()

        viewModel.listFeed()
    }

    private fun initView() {
        feedRecycler.apply {
            adapter = feedAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        }

        showLoading()
    }

    private fun observeViewModel() {
        viewModel.feeds.observe(this, Observer {
            hideLoading()
            feedAdapter.swapData(it)

            if (feedAdapter.data.isNotEmpty()) {
                feedRecycler.smoothScrollToPosition(feedAdapter.data.size - 1)
            }
        })
    }

    private fun setListener() {
        feedFab.setOnClickListener { showAddFeedDialog() }
    }

    private fun showFeedDetail(feed: Feed) {
    }

    private fun showLoading() {
        lavSearchLoading.visibility = View.VISIBLE
        lavSearchLoading.playAnimation()
    }

    private fun hideLoading() {
        lavSearchLoading.visibility = View.GONE
    }

    private fun showAddFeedDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_feed, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("Ok") { _, _ ->
                val message = dialogView.etAddFeed.text.toString()
                viewModel.create(message)
                showLoading()
            }
        builder.create().show()
    }
}
