package ds.nutgarden.ui.chatroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.R
import ds.nutgarden.data.local.model.Message
import ds.nutgarden.data.remote.model.Venue
import ds.nutgarden.ui.chatroom.holder.BaseChatViewHolder
import ds.nutgarden.ui.chatroom.holder.ChatDateHolder
import ds.nutgarden.ui.chatroom.holder.ChatMessageHolder
import ds.nutgarden.ui.chatroom.holder.ChatVenuesHolder
import java.util.*

class ChatAdapter() : RecyclerView.Adapter<BaseChatViewHolder<*>>() {

    private val data: List<Any> = emptyList()

    companion object {
        private const val ITEM_UNKNOWN = -1
        private const val ITEM_DATE = 0
        private const val ITEM_MESSAGE = 1
        private const val ITEM_VENUES = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseChatViewHolder<*> {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_DATE -> ChatDateHolder(inflater.inflate(R.layout.item_chat_date, parent, false))
            ITEM_MESSAGE -> ChatMessageHolder(inflater.inflate(R.layout.item_chat_message, parent, false))
            ITEM_VENUES -> ChatVenuesHolder(inflater.inflate(R.layout.item_chat_venues, parent, false))
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun getItemCount(): Int = data.size

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseChatViewHolder<*>, position: Int) {
        when (holder) {
            is ChatDateHolder -> holder.bind(data[position] as Date)
            is ChatMessageHolder -> holder.bind(data[position] as Message)
            is ChatVenuesHolder -> holder.bind(data[position] as List<Venue>)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is Date -> ITEM_DATE
            is Message -> ITEM_MESSAGE
            is List<*> -> ITEM_VENUES
            else -> ITEM_UNKNOWN
        }
    }

}