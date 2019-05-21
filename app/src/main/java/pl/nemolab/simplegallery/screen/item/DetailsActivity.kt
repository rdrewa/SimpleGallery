package pl.nemolab.simplegallery.screen.item

import android.content.Intent
import pl.nemolab.simplegallery.SingleFragmentActivity
import pl.nemolab.simplegallery.data.Photo

class DetailsActivity : SingleFragmentActivity() {

    companion object {
        @JvmStatic
        fun newIntent(photo: Photo) = Intent(act)
    }


    override fun createFragment() = DetailsFragment.newInstance()
}
