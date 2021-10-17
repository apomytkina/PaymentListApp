package com.example.paymentlistapp.Repository

import com.example.paymentlistapp.Api.PaymentApi

class PaymentsRepository(
    private val api: PaymentApi
) {
    suspend fun login() = api.login()

    suspend fun getPaymentResponse() = api.getPaymentResponse()
}