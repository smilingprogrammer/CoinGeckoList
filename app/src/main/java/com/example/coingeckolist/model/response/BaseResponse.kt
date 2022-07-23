package com.example.coingeckolist.model.response

data class BaseResponse<out T>(
    val status: ApiStatus,
    val data: T?,
    val msg: String?
) {
    companion object {
        fun <T> load(data: T?): BaseResponse<T> =
            BaseResponse(status = ApiStatus.LOADING, data = data, msg = null)

        fun <T> successfull(data: T): BaseResponse<T> =
            BaseResponse(status = ApiStatus.SUCCESSFULL, data = data, msg  = null)

        fun <T> error(data: T?, msg: String): BaseResponse<T> =
            BaseResponse(
                status = ApiStatus.ERROR,
                data = data,
                msg = msg
            )
    }
}