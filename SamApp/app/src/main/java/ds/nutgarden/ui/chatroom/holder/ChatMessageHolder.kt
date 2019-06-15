package ds.nutgarden.ui.chatroom.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.data.model.Message
import kotlinx.android.synthetic.main.item_chat_incoming.view.*
import kotlinx.android.synthetic.main.item_chat_outgoing.view.*

class ChatMessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Message) {
        if (item.isIncoming) {
            bindIncomingMessage(item)
        } else {
            bindOutgoingMessage(item)
        }
    }

    private fun bindIncomingMessage(item: Message) {
        itemView.tvChatIncomingTime.text = item.time
        itemView.tvChatIncomingContent.text = item.content
    }

    fun bindOutgoingMessage(item: Message) {
        itemView.tvChatOutgoingTime.text = item.time
        itemView.tvChatOutgoingContent.text = item.content
    }

}