package ds.nutgarden.data.network

import ds.nutgarden.util.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private var instance: Retrofit? = null

        private fun getInstance(): Retrofit {
            if (instance == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
                instance = Retrofit
                    .Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!
        }

        fun getEndpoint(): RetrofitEndpoint {
            return getInstance()
                .create(RetrofitEndpoint::class.java)
        }
    }

}

