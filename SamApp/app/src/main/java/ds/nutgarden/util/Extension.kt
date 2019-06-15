package ds.nutgarden.util

import java.util.*

fun Date?.toFormattedDate(): String {
    this?.let {
        val dayNames = listOf("Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu")
        val monthNames = listOf(
            "Januari", "Februari", "Maret",
            "April", "Mei", "Juni",
            "Juli", "Agustus", "September",
            "Oktober", "November", "Desember"
        )
        return "${dayNames[day]}, ${date} ${monthNames[month]} ${year + 1900}"
    } ?: return "Tanggal tidak tercantum"
}