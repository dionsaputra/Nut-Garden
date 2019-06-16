package ds.nutgarden.data.model

import com.google.gson.annotations.SerializedName

data class ChatResponse(
    @SerializedName("message") val message: String?, @SerializedName("venues") val venues: List<Venue>?) {
}