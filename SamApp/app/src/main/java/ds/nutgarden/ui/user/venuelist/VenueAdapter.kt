package ds.nutgarden.ui.user.venuelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.R
import ds.nutgarden.data.remote.model.Venue

class VenueAdapter(var data: List<Venue>) : RecyclerView.Adapter<VenueAdapter.VenueHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueHolder {
        return VenueHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_venue, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: VenueHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<Venue>) {
        this.data = data
        notifyDataSetChanged()
    }

    class VenueHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Venue) = with(itemView) {
            // TODO: bind model to itemView
        }
    }
}