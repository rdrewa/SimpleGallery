package pl.nemolab.simplegallery.screen.main

import pl.nemolab.simplegallery.SingleFragmentActivity

class MainActivity : SingleFragmentActivity() {

    override fun createFragment() = MainFragment.newInstance()
}
