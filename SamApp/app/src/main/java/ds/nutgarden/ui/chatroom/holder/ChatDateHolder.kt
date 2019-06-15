package ds.nutgarden.ui.chatroom.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ds.nutgarden.data.model.ChatDate
import kotlinx.android.synthetic.main.item_chat_date.view.*
import java.util.*

class ChatDateHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ChatDate) {
        itemView.tvChatDate.text = item.toString()
    }

}