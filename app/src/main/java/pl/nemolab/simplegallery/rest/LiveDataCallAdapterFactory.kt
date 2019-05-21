package pl.nemolab.simplegallery.rest

import androidx.lifecycle.LiveData
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class LiveDataCallAdapterFactory private constructor() : CallAdapter.Factory() {

    companion object {
        fun create(): LiveDataCallAdapterFactory {
            return LiveDataCallAdapterFactory()
        }
    }

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (CallAdapter.Factory.getRawType(returnType) != LiveData::class.java) {
            return null
        }
        if (returnType !is ParameterizedType) {
            throw IllegalStateException("Response must be parametrized as " + "LiveData<Resource> or LiveData<? extends Resource>")
        }

        return LiveDataBodyCallAdapter<Any>(CallAdapter.Factory.getParameterUpperBound(0, returnType))
    }
}