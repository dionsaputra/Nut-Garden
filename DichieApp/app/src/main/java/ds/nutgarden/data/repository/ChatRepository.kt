package ds.nutgarden.data.repository

import ds.nutgarden.data.model.ChatResponse
import ds.nutgarden.data.network.RetrofitCallback
import ds.nutgarden.data.network.RetrofitClient
import ds.nutgarden.util.AppConstants


class ChatRepository {

    fun postMessage(message: String, onComplete: (ChatResponse?, String?) -> Unit) {
        RetrofitClient.getEndpoint().postMessage(message, AppConstants.USER_ID)
            .enqueue(RetrofitCallback<ChatResponse?>(onComplete))
    }

    fun sendReminder(venueId: String, onComplete: (String?, String?) -> Unit) {
        RetrofitClient.getEndpoint().sendReminder(venueId)
            .enqueue(RetrofitCallback<String?>(onComplete))
    }

    companion object {
        private var instance: ChatRepository? = null

        fun getInstance(): ChatRepository {
            if (instance == null) instance = ChatRepository()
            return instance!!
        }
    }
}