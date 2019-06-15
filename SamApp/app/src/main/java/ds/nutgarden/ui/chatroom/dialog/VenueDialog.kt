package ds.nutgarden.ui.chatroom.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ds.nutgarden.R
import ds.nutgarden.data.model.Venue

class VenueDialog(private val venue: Venue) : DialogFragment() {

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = activity as Context
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_venue, null)

        val builder = AlertDialog.Builder(activity as Context)
            .setView(dialogView)
            .setPositiveButton(getString(R.string.close)) { _, _ -> dismiss() }

        return builder.create()
    }
}