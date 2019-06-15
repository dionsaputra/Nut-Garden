package ds.nutgarden.ui.chatroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.R
import ds.nutgarden.data.model.*
import ds.nutgarden.ui.chatroom.holder.ChatDateHolder
import ds.nutgarden.ui.chatroom.holder.ChatMessageHolder
import ds.nutgarden.ui.chatroom.holder.ChatVenuesHolder
import java.util.*

class ChatAdapter(val data: MutableList<Chat>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_UNKNOWN = -1
        private const val ITEM_DATE = 0
        private const val ITEM_INCOMING_MESSAGE = 1
        private const val ITEM_OUTGOING_MESSAGE = 2
        private const val ITEM_VENUES = 3
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ChatDateHolder -> holder.bind(data[position] as ChatDate)
            is ChatMessageHolder -> holder.bind(data[position] as ChatMessage)
            is ChatVenuesHolder -> holder.bind(data[position] as ChatRecVenues)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_DATE ->
                ChatDateHolder(inflater.inflate(R.layout.item_chat_date, parent, false))
            ITEM_INCOMING_MESSAGE ->
                ChatMessageHolder(inflater.inflate(R.layout.item_chat_incoming, parent, false))
            ITEM_OUTGOING_MESSAGE ->
                ChatMessageHolder(inflater.inflate(R.layout.item_chat_outgoing, parent, false))
            ITEM_VENUES ->
                ChatVenuesHolder(inflater.inflate(R.layout.item_chat_venues, parent, false))
            else ->
                throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return when {
            data[position] is ChatDate -> ITEM_DATE
            data[position] is ChatMessage ->
                if ((data[position] as ChatMessage).isIncoming) ITEM_INCOMING_MESSAGE else ITEM_OUTGOING_MESSAGE

            data[position] is ChatRecVenues -> ITEM_VENUES
            else -> ITEM_UNKNOWN
        }
    }

    fun addItem(item: Chat) {
        data.add(item)
        notifyItemInserted(data.size - 1)
    }
}