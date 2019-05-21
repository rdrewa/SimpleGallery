package pl.nemolab.simplegallery.rest

open class Response<T>(val data: T? = null, val throwable: Throwable? = null) {
    val isSuccess: Boolean
        get() = throwable == null
}