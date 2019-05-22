package pl.nemolab.simplegallery.screen.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.nemolab.simplegallery.databinding.FragmentListBinding

class ListFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }
}