package pl.nemolab.simplegallery.screen.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import pl.nemolab.simplegallery.databinding.FragmentMainBinding
import pl.nemolab.simplegallery.screen.item.DetailsActivity
import pl.nemolab.simplegallery.screen.item.DetailsFragment
import pl.nemolab.simplegallery.screen.main.adapter.PhotoAdapter

class MainFragment: Fragment() {

    companion object {
        const val SPAN_COUNT = 3

        @JvmStatic
        fun newInstance() = MainFragment()
    }

    lateinit var binding: FragmentMainBinding

    lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
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
        initList()
        subscribe()
    }

    private fun initList() {
        binding.recycler.layoutManager = GridLayoutManager(activity!!, SPAN_COUNT)
    }

    private fun subscribe() {
        viewModel.photoList.observe(this, Observer { photoList ->
            photoList?.let {
                binding.recycler.adapter = PhotoAdapter(context!!, photoList) {
                    val args = Bundle()
                    args.putSerializable(DetailsFragment.ARG_PHOTO, it)
                    startActivity(Intent(activity, DetailsActivity::class.java), args)
                }
                binding.recycler.adapter?.notifyDataSetChanged()
            }
        })
    }
}