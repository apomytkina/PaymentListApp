package com.example.paymentlistapp.Api

import com.example.paymentlistapp.Model.AuthResponse
import com.example.paymentlistapp.Model.PaymentResponse
import com.example.paymentlistapp.Model.Response
import retrofit2.http.*

interface PaymentApi {
    @Multipart
    @FormUrlEncoded
    @Headers(
        "app-key: 12345",
        "v: 1"
    )
    @POST("/login")
    suspend fun login(): retrofit2.Response<AuthResponse>

    @Headers(
        "app-key: 12345",
        "v: 1"
    )
    @GET("/payments")
    suspend fun getPaymentResponse(
        @Query("token")
        token: Int = 123456789
    ): retrofit2.Response<PaymentResponse>
}