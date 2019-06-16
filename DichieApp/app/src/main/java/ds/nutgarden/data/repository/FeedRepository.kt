package ds.nutgarden.data.repository

import ds.nutgarden.data.model.Feed
import ds.nutgarden.data.network.RetrofitCallback
import ds.nutgarden.data.network.RetrofitClient
import ds.nutgarden.util.AppConstants

class FeedRepository {

    fun list(onComplete: (List<Feed>?, String?) -> Unit) {
        RetrofitClient.getEndpoint().listFeed(AppConstants.USER_ID).enqueue(RetrofitCallback<List<Feed>?>(onComplete))
    }

    fun create(message: String, onComplete: (Feed?, String?) -> Unit) {
        RetrofitClient.getEndpoint().createFeed(message, AppConstants.USER_ID)
            .enqueue(RetrofitCallback<Feed?>(onComplete))
    }

    companion object {
        private var instance: FeedRepository? = null

        fun getInstance(): FeedRepository {
            if (instance == null) instance = FeedRepository()
            return instance!!
        }
    }
}