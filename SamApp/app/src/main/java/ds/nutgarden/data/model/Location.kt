package ds.nutgarden.data.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("address") val address: String,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("lat") val latitude: Double
) : Chat {}