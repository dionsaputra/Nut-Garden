package ds.nutgarden.ui.chatroom.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chat_date.view.*
import java.util.*

class ChatDateHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Date) {
        itemView.tvChatDate.text = item.toString()
    }

}