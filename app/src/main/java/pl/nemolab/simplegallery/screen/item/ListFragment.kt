package pl.nemolab.simplegallery.screen.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pl.nemolab.simplegallery.databinding.FragmentListBinding
import pl.nemolab.simplegallery.screen.item.adapter.StringAdapter

class ListFragment: Fragment() {

    companion object {
        const val ARG_ITEMS = "items"
        const val ARG_EMPTY = "empty"

        @JvmStatic
        fun newInstance(items: ArrayList<String>, empty: String) = ListFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ARG_ITEMS, items)
                putString(ARG_EMPTY, empty)
            }
        }
    }

    lateinit var binding: FragmentListBinding

    var items = emptyList<String>()

    var empty = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        items = arguments!!.getSerializable(ARG_ITEMS) as List<String>
        empty = arguments!!.getString(ARG_EMPTY)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.list.layoutManager = LinearLayoutManager(context)
        binding.list.adapter = StringAdapter(items, "Nooo")
    }
}