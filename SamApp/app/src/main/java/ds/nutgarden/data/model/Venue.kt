package ds.nutgarden.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

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
    @SerializedName("__v") val version: Int,
    @SerializedName("createdAt") val createdAt: Date
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readInt(),
        Date(parcel.readLong())
    ) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeParcelable(location, flags)
        dest?.writeString(id)
        dest?.writeString(name)
        dest?.writeDouble(rating)
        dest?.writeInt(visitors)
        dest?.writeString(picture)
        dest?.writeString(type)
        dest?.writeInt(available)
        dest?.writeString(openHour)
        dest?.writeString(closeHour)
        dest?.writeLong(price)
        dest?.writeInt(version)
        dest?.writeInt(version)
        dest?.writeLong(createdAt.time)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getRecommendationType(): String {
        return "Rekomendasi"
    }

    fun getDistance(): Double {
        return 0.0
    }

    companion object CREATOR : Parcelable.Creator<Venue> {
        override fun createFromParcel(parcel: Parcel): Venue {
            return Venue(parcel)
        }

        override fun newArray(size: Int): Array<Venue?> {
            return arrayOfNulls(size)
        }
    }
}