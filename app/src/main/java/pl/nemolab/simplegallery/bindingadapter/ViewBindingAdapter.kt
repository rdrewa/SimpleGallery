package pl.nemolab.simplegallery.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindingAdapter {

    const val FADE_DURATION = 1000L

    @BindingAdapter("isVisibleOrGone")
    @JvmStatic
    fun isVisibleOrGone(view: View, visibility: Boolean) {
        view.visibility = if (visibility) View.VISIBLE else View.GONE
    }

    @BindingAdapter("isVisibleOrInvisible")
    @JvmStatic
    fun isVisibleOrInvisible(view: View, visibility: Boolean) {
        view.visibility = if (visibility) View.VISIBLE else View.INVISIBLE
    }

}