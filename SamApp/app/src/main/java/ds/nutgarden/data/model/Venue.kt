package ds.nutgarden.data.model

import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("location") val location: Location,
    @SerializedName("_id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("visitors") val visitors: Int,
    @SerializedName("picture") val picture: String,
    @SerializedName("type") val type: String,
    @SerializedName("available") val available: Int,
    @SerializedName("openHour") val openHour: String,
    @SerializedName("closeHour") val closeHour: String,
    @SerializedName("price") val price: Long,
    @SerializedName("__v") val version: Int
) {
    fun getRecommendationType(): String {
        return "Populer"
    }

    fun getDistance(): Double {
        return 0.0
    }
}