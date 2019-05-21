package pl.nemolab.simplegallery.rest

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class LiveDataResponseBodyConverterFactory : Converter.Factory() {

    fun create(): LiveDataResponseBodyConverterFactory {
        return LiveDataResponseBodyConverterFactory()
    }

    override fun responseBodyConverter(type: Type, annotations: Array<Annotation>,
                                       retrofit: Retrofit): Converter<ResponseBody, *>? {
        if (type is ParameterizedType) {
            if (type.rawType === Response::class.java) {
                val realType = type.actualTypeArguments[0]
                return retrofit.nextResponseBodyConverter<Any>(this, realType, annotations)
            }
        }

        return retrofit.nextResponseBodyConverter<Any>(this, type, annotations)
    }
}