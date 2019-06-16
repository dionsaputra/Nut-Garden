package ds.nutgarden.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ds.nutgarden.data.model.Feed
import ds.nutgarden.data.repository.FeedRepository

class FeedListViewModel : ViewModel() {

    var feedRepo = FeedRepository.getInstance()

    val feeds = MutableLiveData<List<Feed>>()
    val errorMessage = MutableLiveData<String>()

    fun listFeed() {
        feedRepo.list() { feeds, errorMessage ->
            feeds?.let { this@FeedListViewModel.feeds.value = feeds }
            errorMessage?.let { this@FeedListViewModel.errorMessage.value = errorMessage }
        }
    }

    fun create(message: String) {
        feedRepo.create(message) { feed, errorMessage ->
            feed?.let { listFeed() }
            errorMessage?.let { this@FeedListViewModel.errorMessage.value = errorMessage }
        }
    }
}