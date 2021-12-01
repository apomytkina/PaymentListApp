package com.example.paymentlistapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.paymentlistapp.Repository.PaymentsRepository

class PaymentsViewModelFactory(
    private val repository: PaymentsRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PaymentsViewModel(repository) as T
    }
}