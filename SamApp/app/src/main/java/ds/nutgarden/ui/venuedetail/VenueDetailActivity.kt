package ds.nutgarden.ui.venuedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Transition
import ds.nutgarden.R

class VenueDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_detail)

        val venueId = intent.getIntExtra("venue_detail_id", 0)
    }
}
