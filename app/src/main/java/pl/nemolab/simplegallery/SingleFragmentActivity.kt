package pl.nemolab.simplegallery

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class SingleFragmentActivity : AppCompatActivity() {

    companion object {
        const val CONTAINER_ID = R.id.fragment_container
    }

    protected abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(CONTAINER_ID)
        if (fragment == null) {
            fragment = createFragment()
            fragmentManager
                .beginTransaction()
                .add(CONTAINER_ID, fragment)
                .commit()
        }
    }

    @LayoutRes
    protected open fun getLayoutResId() = R.layout.activity_fragment

}