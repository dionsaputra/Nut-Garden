package ds.nutgarden.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ds.nutgarden.data.model.Chat
import ds.nutgarden.data.model.ChatMessage
import ds.nutgarden.data.model.ChatRecVenues
import ds.nutgarden.data.repository.ChatRepository
import ds.nutgarden.util.toFormattedTime
import java.util.*

class ChatRoomViewModel : ViewModel() {

    private var chatRepo = ChatRepository.getInstance()
    var newChat = MutableLiveData<Chat>()
    var reminder = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<String>()

    init {
        reminder.value = false
    }

    fun postMessage(message: String) {
        chatRepo.postMessage(message) { chatResponse, errorMessage ->
            chatResponse?.let {
                if (it.message != null) {
                    newChat.value = ChatMessage(it.message, Date().toFormattedTime(), true)
                }

                if (it.venues != null) {
                    newChat.value = ChatRecVenues(it.venues)
                }
            }

            errorMessage?.let { this@ChatRoomViewModel.errorMessage.postValue(it) }
        }
    }

    fun sendReminder(venueId: String) {
        chatRepo.sendReminder(venueId) { message, errorMessage ->
            message?.let {
                newChat.value = ChatMessage(it, Date().toFormattedTime(), true)
                reminder.value = true
            }
            errorMessage?.let { this@ChatRoomViewModel.errorMessage.postValue(it) }
        }
    }
}