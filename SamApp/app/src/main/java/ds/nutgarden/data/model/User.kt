package ds.nutgarden.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name: String,
    @SerializedName("avatar") val avatar: String
) {
}