package pl.nemolab.simplegallery.screen.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.nemolab.simplegallery.data.Photo
import pl.nemolab.simplegallery.databinding.ItemPhotoBinding

class PhotoAdapter(val context: Context, val items: List<Photo>, val clickAction: (Photo) -> (Unit)): RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PhotoHolder(
        ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class PhotoHolder(private val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.viewModel = photo
            binding.executePendingBindings()
        }
    }
}