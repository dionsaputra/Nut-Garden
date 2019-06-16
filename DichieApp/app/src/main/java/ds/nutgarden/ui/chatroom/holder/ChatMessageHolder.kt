package ds.nutgarden.ui.chatroom.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.data.model.ChatMessage
import kotlinx.android.synthetic.main.item_chat_incoming.view.*
import kotlinx.android.synthetic.main.item_chat_outgoing.view.*

class ChatMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ChatMessage) {
        if (item.isIncoming) {
            bindIncomingMessage(item)
        } else {
            bindOutgoingMessage(item)
        }
    }

    private fun bindIncomingMessage(item: ChatMessage) {
        itemView.tvChatIncomingTime.text = item.time
        itemView.tvChatIncomingContent.text = item.content
    }

    fun bindOutgoingMessage(item: ChatMessage) {
        itemView.tvChatOutgoingTime.text = item.time
        itemView.tvChatOutgoingContent.text = item.content
    }

}