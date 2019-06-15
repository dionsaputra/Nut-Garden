package ds.nutgarden.ui.chatroom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ds.nutgarden.R
import ds.nutgarden.ui.chatroom.adapter.ChatAdapter
import ds.nutgarden.viewmodel.ChatRoomViewModel

class ChatActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(ChatRoomViewModel::class.java) }
    private val chatAdapter = ChatAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.newChat.observe(this, Observer {
            chatAdapter.addItem(it)
        })
    }
}
