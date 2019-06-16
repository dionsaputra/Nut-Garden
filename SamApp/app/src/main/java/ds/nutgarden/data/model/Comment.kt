package ds.nutgarden.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class Comment(
    @SerializedName("_id") val id: String,
    @SerializedName("message") val message: String,
    @SerializedName("date") val date: Date,
    @SerializedName("sender") val sender: User
) {}