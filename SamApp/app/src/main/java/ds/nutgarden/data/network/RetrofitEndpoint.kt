package ds.nutgarden.data.network

import ds.nutgarden.data.model.ApiResponse
import ds.nutgarden.data.model.ChatResponse
import ds.nutgarden.data.model.Feed
import retrofit2.Call
import retrofit2.http.*

interface RetrofitEndpoint {

    @GET("/feeds")
    fun listFeed(@Query("userId") userId: String): Call<ApiResponse<List<Feed>?>>

    @FormUrlEncoded
    @POST("/feeds")
    fun createFeed(@Field("message") message: String, @Field("userId") userId: String): Call<ApiResponse<Feed?>>

    @FormUrlEncoded
    @POST("/messages")
    fun postMessage(@Field("message") message: String, @Field("userId") userId: String): Call<ApiResponse<ChatResponse?>>

    @GET("/venues/{venueId}/remind")
    fun sendReminder(@Path("venueId") venueId: String): Call<ApiResponse<String?>>
}