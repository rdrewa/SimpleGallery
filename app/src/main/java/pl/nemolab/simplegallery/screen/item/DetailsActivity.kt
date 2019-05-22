package pl.nemolab.simplegallery.screen.item

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import pl.nemolab.simplegallery.R
import pl.nemolab.simplegallery.data.Photo
import pl.nemolab.simplegallery.databinding.ActivityDetailsBinding

class DetailsActivity: AppCompatActivity() {

    companion object {
        const val CONTAINER_ID = R.id.header_container

        @JvmStatic
        fun newIntent(context: Context, photo: Photo) = Intent(context, DetailsActivity::class.java).apply {
            putExtra(DetailsFragment.ARG_PHOTO, photo)
        }
    }

    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(CONTAINER_ID)
        if (fragment == null) {
            fragment = DetailsFragment.newInstance(getPhoto())
            fragmentManager
                .beginTransaction()
                .add(CONTAINER_ID, fragment)
                .commit()
        }
        setupTabs()
        title = getPhoto().title
    }

    private fun setupTabs() {
        binding.viewPager.adapter = DetailsTabsPagerAdapter(supportFragmentManager, listOf("Polubienia", "Komentarze"), getPhoto())
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    private fun getPhoto() = intent.getSerializableExtra(DetailsFragment.ARG_PHOTO) as Photo

    @LayoutRes
    private fun getLayoutResId() = R.layout.activity_details
}