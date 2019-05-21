package pl.nemolab.simplegallery.screen.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import pl.nemolab.simplegallery.data.Photo
import pl.nemolab.simplegallery.databinding.FragmentDetailsBinding

class DetailsFragment: Fragment() {

    companion object {
        const val ARG_PHOTO = "photo"

        @JvmStatic
        fun newInstance(photo: Photo) : DetailsFragment {
            val args = Bundle()
            args.putSerializable(ARG_PHOTO, photo)
            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var binding: FragmentDetailsBinding

    lateinit var viewModel: DetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        viewModel.photo = arguments!![ARG_PHOTO] as Photo
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}