package pl.nemolab.simplegallery.screen.item.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StringAdapter(items: List<String>, empty: String): RecyclerView.Adapter<StringAdapter.StringHolder>() {

    val items = if (items.isEmpty()) listOf(empty) else items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StringHolder(
        LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: StringHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class StringHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val textView = itemView as TextView

        fun bind(item: String) {
            textView.text = item
        }
    }
}