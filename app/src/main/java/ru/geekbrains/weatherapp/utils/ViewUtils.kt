package ru.geekbrains.weatherapp.utils

import android.view.View
import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(
    text: String,
    actionText: String,
    action: (View) -> Unit,
    length: Int = Snackbar.LENGTH_INDEFINITE
) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}
fun View.loadSvgYa(
    icon: String
) {
    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry {
            add(SvgDecoder(this@loadSvgYa.context))
        }
        .build()
    val request = ImageRequest.Builder(this.context)
        .data("https://yastatic.net/weather/i/icons/blueye/color/svg/${icon}.svg")
        .target(this as ImageView)
        .build()
    imageLoader.enqueue(request)
}