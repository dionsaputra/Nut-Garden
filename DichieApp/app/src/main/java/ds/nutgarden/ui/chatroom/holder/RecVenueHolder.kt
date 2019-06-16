package ds.nutgarden.ui.chatroom.holder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import ds.nutgarden.data.model.Venue
import ds.nutgarden.util.AppConstants
import ds.nutgarden.util.round
import kotlinx.android.synthetic.main.item_rec_venue.view.*

class RecVenueHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Venue, onReminderClick: (Venue) -> Unit, onItemClick: (Venue, ImageView) -> Unit) {
        itemView.chipRecVenueCategory.text = item.getRecommendationType()
        itemView.tvVenueCardName.text = item.name
        itemView.tvVenueCardType.text = item.type
        itemView.tvVenueCardDistance.text = item.getDistance().toString()
        itemView.tvRecVenueRating.text = item.rating.round(1).toString()

        Glide.with(itemView).load(AppConstants.BASE_URL + item.picture)
            .apply(RequestOptions().signature(ObjectKey(System.currentTimeMillis().toString())))
            .into(itemView.ivRecVenuePicture)
        itemView.bRecVenueReminder.setOnClickListener { onReminderClick(item) }
        itemView.setOnClickListener { onItemClick(item, itemView.ivRecVenuePicture) }
    }

}