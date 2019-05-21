package pl.nemolab.simplegallery.screen.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import pl.nemolab.simplegallery.data.Photo
import pl.nemolab.simplegallery.data.RecentResponse
import pl.nemolab.simplegallery.repository.PhotoRepository

class MainViewModel(): ViewModel() {

    val progressBarVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val photoList: MutableLiveData<List<Photo>> = MutableLiveData()
    private val repository = PhotoRepository
    private lateinit var mediator: MediatorLiveData<RecentResponse>
    private val observer = Observer<RecentResponse> {  }

    fun onViewCreated() {
        progressBarVisibility.value = true
        mediator = MediatorLiveData()
        mediator.observeForever(observer)
        mediator.addSource(repository.getRecent()) {
            progressBarVisibility.value = false
            photoList.value = it.photos.photo
        }
    }

    override fun onCleared() {
        super.onCleared()
        mediator.removeObserver(observer)
    }
}