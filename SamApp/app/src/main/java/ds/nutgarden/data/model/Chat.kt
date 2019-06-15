package ds.nutgarden.data.model

import com.google.gson.annotations.SerializedName

data class Chat(
    @SerializedName("message") val message: Message?,
    @SerializedName("venues") val recVenues: List<Venue>?
) {}