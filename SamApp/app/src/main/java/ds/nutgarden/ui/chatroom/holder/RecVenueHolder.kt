package ds.nutgarden.ui.chatroom.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ds.nutgarden.data.model.Venue
import kotlinx.android.synthetic.main.item_rec_venue.view.*

class RecVenueHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Venue) {
        itemView.chipRecVenueCategory.text = item.getRecommendationType()
        itemView.tvVenueCardName.text = item.name
        itemView.tvVenueCardType.text = item.type
        itemView.tvVenueCardDistance.text = item.getDistance().toString()
        itemView.tvRecVenueRating.text = item.rating.toString()

        Glide.with(itemView).load(item.picture).into(itemView.ivRecVenuePicture)
    }

}