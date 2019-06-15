package ds.nutgarden.ui.feed.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ds.nutgarden.R

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        initView()
        observeViewModel()
        setListener()
    }

    private fun initView() {

    }

    private fun observeViewModel() {

    }

    private fun setListener() {

    }

}
