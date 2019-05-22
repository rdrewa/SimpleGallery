package pl.nemolab.simplegallery.screen.item

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pl.nemolab.simplegallery.data.Photo

class DetailsTabsPagerAdapter(fragmentManager: FragmentManager, val titles: List<String>, photo: Photo) : FragmentPagerAdapter(fragmentManager) {

    companion object {
        const val TAB_COUNTER = 2
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> ListFragment.newInstance(arrayListOf("Stefan Telefan", "Pan Ambroży", "Tytus, Romek i Atomek"), "Nic nie ma")
        1 -> ListFragment.newInstance(arrayListOf(), "Nikt nie skomentował :(")
        else -> Fragment()
    }

    override fun getCount() = TAB_COUNTER

    override fun getPageTitle(position: Int) = if (titles.isNotEmpty() && position < titles.size) titles[position] else "#$position#"

}
