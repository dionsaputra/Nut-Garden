package ds.nutgarden.ui.chatroom.holder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.data.model.Venue
import ds.nutgarden.ui.chatroom.adapter.RecVenueAdapter
import kotlinx.android.synthetic.main.item_chat_venues.view.*

class ChatVenuesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: List<Venue>) {
        itemView.rvRecommendationVenues.apply {
            adapter = RecVenueAdapter(item)
            layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

}