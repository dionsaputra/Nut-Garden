package ds.nutgarden.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ds.nutgarden.data.model.Chat

class ChatRoomViewModel : ViewModel() {

    var newChat = MutableLiveData<Chat>()

}