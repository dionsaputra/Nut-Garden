package ds.nutgarden.data.network

import ds.nutgarden.data.model.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitCallback<T>(val onComplete: (T?, String?) -> Unit) : Callback<ApiResponse<T?>> {

    override fun onFailure(call: Call<ApiResponse<T?>>, t: Throwable) {
        call.cancel()
        onComplete(null, t.message.orEmpty())
    }

    override fun onResponse(call: Call<ApiResponse<T?>>, response: Response<ApiResponse<T?>>) {
        if (response.isSuccessful) {
            onComplete(response.body()?.data, null)
        } else {
            onComplete(null, response.message())
        }
    }
}