package ds.nutgarden.ui.chatroom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ds.nutgarden.R
import ds.nutgarden.data.model.*
import ds.nutgarden.ui.chatroom.adapter.ChatAdapter
import ds.nutgarden.viewmodel.ChatRoomViewModel
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*

class ChatActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(ChatRoomViewModel::class.java) }
    private val chatAdapter = ChatAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        initView()
        observeViewModel()
        setListener()
    }

    private fun initView() {
        viewModel.newChat.value = ChatDate(Date())

        val recVenues = ChatRecVenues(
            listOf(
                Venue(
                    Location("Bandung", 100.00, 100.00),
                    id = "",
                    name = "Pasaga",
                    rating = 4.5,
                    visitors = 10,
                    picture = "http://unpar.ac.id/wp-content/uploads/2015/10/Siang-Hingga-Malam-660x330.jpg",
                    type = "Lapangan Futsal",
                    available = 10,
                    openHour = "08.00",
                    closeHour = "20.00",
                    price = 10_000,
                    version = 1
                ),
                Venue(
                    Location("Bandung", 100.00, 100.00),
                    id = "",
                    name = "Pasaga",
                    rating = 4.5,
                    visitors = 10,
                    picture = "http://unpar.ac.id/wp-content/uploads/2015/10/Siang-Hingga-Malam-660x330.jpg",
                    type = "Lapangan Futsal",
                    available = 10,
                    openHour = "08.00",
                    closeHour = "20.00",
                    price = 10_000,
                    version = 1
                ),
                Venue(
                    Location("Bandung", 100.00, 100.00),
                    id = "",
                    name = "Pasaga",
                    rating = 4.5,
                    visitors = 10,
                    picture = "http://unpar.ac.id/wp-content/uploads/2015/10/Siang-Hingga-Malam-660x330.jpg",
                    type = "Lapangan Futsal",
                    available = 10,
                    openHour = "08.00",
                    closeHour = "20.00",
                    price = 10_000,
                    version = 1
                ),
                Venue(
                    Location("Bandung", 100.00, 100.00),
                    id = "",
                    name = "Pasaga",
                    rating = 4.5,
                    visitors = 10,
                    picture = "http://unpar.ac.id/wp-content/uploads/2015/10/Siang-Hingga-Malam-660x330.jpg",
                    type = "Lapangan Futsal",
                    available = 10,
                    openHour = "08.00",
                    closeHour = "20.00",
                    price = 10_000,
                    version = 1
                ),
                Venue(
                    Location("Bandung", 100.00, 100.00),
                    id = "",
                    name = "Pasaga",
                    rating = 4.5,
                    visitors = 10,
                    picture = "http://unpar.ac.id/wp-content/uploads/2015/10/Siang-Hingga-Malam-660x330.jpg",
                    type = "Lapangan Futsal",
                    available = 10,
                    openHour = "08.00",
                    closeHour = "20.00",
                    price = 10_000,
                    version = 1
                )
            )
        )

        viewModel.newChat.value = recVenues

        rvChat.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeViewModel() {
        viewModel.newChat.observe(this, Observer {
            chatAdapter.addItem(it)
            rvChat.smoothScrollToPosition(chatAdapter.data.size - 1)
        })
    }

    private fun setListener() {
        ibChatSend.setOnClickListener {
            if (tvChatInput.text.isNotEmpty()) {
                viewModel.newChat.value = ChatMessage(tvChatInput.text.toString(), "18.00", false)
                viewModel.newChat.value = ChatMessage("Hallo ${tvChatInput.text.toString()}", "18.01", true)
                tvChatInput.text.clear()
            }
        }
    }


}
