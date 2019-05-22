package pl.nemolab.simplegallery.screen.item

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pl.nemolab.simplegallery.data.Photo

class DetailsTabsPagerAdapter(fragmentManager: FragmentManager, photo: Photo) : FragmentPagerAdapter(fragmentManager) {

    companion object {
        const val TAB_COUNTER = 2
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> ListFragment.newInstance()
        1 -> ListFragment.newInstance()
        else -> Fragment()
    }

    override fun getCount() = TAB_COUNTER

}
