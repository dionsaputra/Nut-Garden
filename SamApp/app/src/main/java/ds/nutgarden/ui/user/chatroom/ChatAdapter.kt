package ds.nutgarden.ui.user.chatroom

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ds.nutgarden.R
import ds.nutgarden.data.model.Chat

class ChatAdapter(var data: List<Chat>) : RecyclerView.Adapter<ChatAdapter.ChatHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        return ChatHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ChatHolder, position: Int) = holder.bind(data[position])

    fun swapData(data: List<Chat>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Chat) = with(itemView) {
            // TODO: bind model to itemView
        }
    }
}