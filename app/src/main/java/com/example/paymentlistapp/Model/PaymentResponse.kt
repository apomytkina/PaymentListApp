package com.example.paymentlistapp.Model

data class PaymentResponse(
    val response: List<Response>,
    val success: String
)