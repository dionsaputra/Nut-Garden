package ds.nutgarden.ui.feed.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ds.nutgarden.R
import ds.nutgarden.data.model.Feed
import ds.nutgarden.util.AppConstants
import ds.nutgarden.util.toFormattedDate
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedAdapter(var data: List<Feed>, private val onFeedClick: (Feed) -> Unit) :
    RecyclerView.Adapter<FeedAdapter.FeedHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedHolder {
        return FeedHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_feed,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: FeedHolder, position: Int) {
        holder.bind(data[position], onFeedClick)
    }

    fun swapData(data: List<Feed>) {
        this.data = data
        notifyDataSetChanged()
    }

    class FeedHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(item: Feed, onFeedClick: (Feed) -> Unit) = with(itemView) {
            Glide.with(itemView).load(AppConstants.BASE_URL + item.starter.avatar).into(civStarterAvatar)
            tvFeedStarterName.text = item.starter.name
            tvFeedDate.text = item.date.toFormattedDate()
            tvFeedMessage.text = item.message
            tvFeedCommentCounter.text = "${item.comments.size.toString()} komentar"

            itemView.setOnClickListener { onFeedClick(item) }
        }

    }
}