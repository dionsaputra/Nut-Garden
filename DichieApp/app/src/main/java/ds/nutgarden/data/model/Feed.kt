package ds.nutgarden.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Feed(
    @SerializedName("_id") val id: String,
    @SerializedName("message") val message: String,
    @SerializedName("date") val date: Date,
    @SerializedName("comments") val comments: List<Comment>,
    @SerializedName("starter") val starter: User,
    @SerializedName("__v") val version: Int
) {}
