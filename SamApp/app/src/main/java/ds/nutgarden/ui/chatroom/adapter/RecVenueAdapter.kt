package ds.nutgarden.ui.chatroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.R
import ds.nutgarden.data.model.Venue
import ds.nutgarden.ui.chatroom.holder.RecVenueHolder

class RecVenueAdapter(private val venues: List<Venue>) : RecyclerView.Adapter<RecVenueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecVenueHolder {
        return RecVenueHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rec_venue, parent, false))
    }

    override fun getItemCount(): Int = venues.size

    override fun onBindViewHolder(holder: RecVenueHolder, position: Int) {
        holder.bind(venues[position])
    }
}