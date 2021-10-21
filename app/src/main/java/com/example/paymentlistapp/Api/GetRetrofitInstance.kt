package com.example.paymentlistapp.Api

import com.example.paymentlistapp.Util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetRetrofitInstance {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy {
            retrofit.create(PaymentApi::class.java)
        }
    }
}