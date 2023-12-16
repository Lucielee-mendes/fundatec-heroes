package com.example.fundatecheroes

import android.content.Context
import android.view.View
import android.widget.EditText
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

fun View.gone() {
   visibility = View.GONE
}
fun View.visible() {
   visibility = View.VISIBLE
}

fun EditText.showError(
   @StringRes snackbarMessage: Int,
) {

   error = context.getString(snackbarMessage)
}
fun Context.showSnackBar(
   view: View,
   @StringRes snackbarMessage: Int,
   @ColorRes colorBackground: Int? = null,
   duration: Int = Snackbar.LENGTH_SHORT
) {
   val snackBar = Snackbar.make(
      view,
      snackbarMessage,
      duration
   )

   colorBackground?.let {
      snackBar.setBackgroundTint(ContextCompat.getColor(this, it))
   }

   snackBar.show()
}