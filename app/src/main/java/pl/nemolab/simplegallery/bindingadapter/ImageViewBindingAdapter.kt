package pl.nemolab.simplegallery.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ImageViewBindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(imageView: ImageView, imageUrl: String) {
        Picasso.with(imageView.context).load(imageUrl).into(imageView)
    }

    @BindingAdapter("src")
    @JvmStatic
    fun setSrc(imageView: ImageView, imageUrl: String) {
        Picasso.with(imageView.context).load(imageUrl).into(imageView)
    }
}