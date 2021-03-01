package com.yyusufsefa.dependencyinjection.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}


@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}
