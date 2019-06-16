package ds.nutgarden.util

import java.util.*
import kotlin.math.round

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

fun Date?.toFormattedTime(): String {
    this?.let {
        return "${this.hours}:${this.minutes}"
    } ?: return "-"
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}