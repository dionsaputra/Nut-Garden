package ds.nutgarden.data.network

import ds.nutgarden.data.model.ApiResponse
import ds.nutgarden.data.model.Feed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitEndpoint {

    @GET("/feeds")
    fun listFeed(@Query("userId") userId: String): Call<ApiResponse<Feed>>

}