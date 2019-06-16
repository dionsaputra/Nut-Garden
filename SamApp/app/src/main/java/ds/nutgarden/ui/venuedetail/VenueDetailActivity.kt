package ds.nutgarden.ui.venuedetail

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.squareup.picasso.Picasso
import ds.nutgarden.R
import ds.nutgarden.data.model.Venue
import ds.nutgarden.util.AppConstants
import ds.nutgarden.util.round
import ds.nutgarden.util.toFormattedDate
import kotlinx.android.synthetic.main.activity_venue_detail.*

class VenueDetailActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_detail)

        val venue = intent.getParcelableExtra<Venue>("venue")

        Glide.with(this).load(AppConstants.BASE_URL + venue.picture)
            .into(ivVenueDetailPicture)

        tvVenueDetailName.text = venue.name
        tvVenueDetailRating.text = "Rating: ${venue.rating.round(1)} (${venue.visitors} kunjungan)"
        tvVenueDetailType.text = venue.type
        tvVenueDetailCreatedAt.text = "Bergabung bersama Dichie semenjak ${venue.createdAt.toFormattedDate()}"
        tvVenueDetailAddress.text = venue.location.address
        tvVenueDetailAvailability.text = "Tersedia ${venue.available} tempat (${venue.openHour}-${venue.closeHour})"
    }
}
