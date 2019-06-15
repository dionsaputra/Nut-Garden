package ds.nutgarden.data.model

import ds.nutgarden.util.toFormattedDate
import java.util.*

data class ChatDate(val date: Date) : Chat {
    override fun toString(): String {
        return date.toFormattedDate()
    }
}