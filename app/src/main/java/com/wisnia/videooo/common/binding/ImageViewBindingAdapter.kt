package com.wisnia.videooo.common.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

enum class Transformation {
    CenterCrop
}

@BindingAdapter("imageSrc", "placeholder", "transformation", requireAll = false)
fun ImageView.setImageSrc(src: Any?, placeholder: Drawable?, transformation: Transformation?) {

    val requestOptions = RequestOptions()
    setTransformation(requestOptions, transformation)
    setPlaceholder(requestOptions, placeholder)

    Glide.with(this)
        .load(src)
        .apply(requestOptions)
        .into(this)
}

private fun setTransformation(requestOptions: RequestOptions, transformation: Transformation?) {
    transformation?.let {
        when (transformation) {
            Transformation.CenterCrop -> requestOptions.centerCrop()
        }
    }
}

private fun setPlaceholder(requestOptions: RequestOptions, placeholder: Drawable?) {
    placeholder?.let { requestOptions.placeholder(placeholder) }
}
