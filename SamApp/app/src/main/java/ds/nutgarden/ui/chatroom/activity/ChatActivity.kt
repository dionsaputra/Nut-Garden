package ds.nutgarden.ui.chatroom.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ds.nutgarden.R
import ds.nutgarden.data.model.*
import ds.nutgarden.ui.chatroom.adapter.ChatAdapter
import ds.nutgarden.ui.feed.activity.FeedActivity
import ds.nutgarden.ui.venuedetail.VenueDetailActivity
import ds.nutgarden.util.toFormattedTime
import ds.nutgarden.viewmodel.ChatRoomViewModel
import kotlinx.android.synthetic.main.activity_chat.*
import java.util.*


class ChatActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(ChatRoomViewModel::class.java) }

    private val onReminderClick: (Venue) -> Unit = {
        val chat = ChatMessage("Ingatkan aku buat ${it.type} di ${it.name} ya", Date().toFormattedTime(), false)
        sendChat(chat)
    }

    private val onItemClick: (Venue, ImageView) -> Unit = { venue, venuePicture ->
        val intent = Intent(this, VenueDetailActivity::class.java)
        val pairImageView = Pair<View, String>(venuePicture, getString(R.string.tn_venue_picture))
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this, pairImageView
        )
        intent.putExtra("venue_detail_id", venue.id)
        startActivity(intent, options.toBundle())
    }

    private val chatAdapter = ChatAdapter(mutableListOf(), onReminderClick, onItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        initView()
        observeViewModel()
        setListener()
    }

    private fun initView() {

        sendChat(ChatDate(Date()))

        Handler().postDelayed({
            sendChat(
                ChatMessage(
                    "Hai. Aku Dichie, teman virtualmu untuk tetap semangat berolahraga :)",
                    Date().toFormattedTime(),
                    true
                )
            )
        }, 1000)
        Handler().postDelayed({
            sendChat(
                ChatMessage(
                    "Kamu bisa tanya-tanya aku tentang tempat-tempat olahraga terdekat ataupun yang lagi recommended buat kamu.",
                    Date().toFormattedTime(),
                    true
                )
            )
        }, 2000)
        Handler().postDelayed({
            sendChat(
                ChatMessage(
                    "Atau kamu juga bisa tanya-tanya seputar tips-tips olahraga yang mungkin kamu butuhkan",
                    Date().toFormattedTime(),
                    true
                )
            )
        }, 3000)


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

        rvChat.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(context)
        }

//        sendChat(recVenues)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
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
                sendChat(ChatMessage(tvChatInput.text.toString(), "18.00", false))
                sendChat(ChatMessage("Hallo ${tvChatInput.text}", "18.01", true))
                tvChatInput.text.clear()
            }
        }

        toolbar.setNavigationOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_feed -> startActivity(Intent(this, FeedActivity::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun sendChat(chat: Chat) {
        viewModel.newChat.value = chat
    }
}
