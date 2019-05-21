package pl.nemolab.simplegallery.rest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.*
import retrofit2.Response as RetroResponse
import java.lang.reflect.Type

class LiveDataBodyCallAdapter<R> internal constructor(private val responseType: Type) : CallAdapter<R, LiveData<Response<R>>> {

    override fun responseType(): Type {
        return responseType
    }

    override fun adapt(call: Call<R>): LiveData<Response<R>> {
        val liveDataResponse = MutableLiveData<Response<R>>()
        call.enqueue(LiveDataBodyCallCallback(liveDataResponse))
        return liveDataResponse
    }

    private class LiveDataBodyCallCallback<T> internal constructor(private val liveData: MutableLiveData<Response<T>>) : Callback<T> {
        override fun onResponse(call: Call<T>, response: RetroResponse<T>) {
            if (call.isCanceled) return

            if (response.isSuccessful) {
                liveData.postValue(Response(data = response.body()))
            } else {
                liveData.postValue(Response(throwable = HttpException(response)))
            }
        }

        override fun onFailure(call: Call<T>, throwable: Throwable) {
            if (call.isCanceled) {
                return
            }
            liveData.postValue(Response(throwable = throwable))
        }
    }
}
