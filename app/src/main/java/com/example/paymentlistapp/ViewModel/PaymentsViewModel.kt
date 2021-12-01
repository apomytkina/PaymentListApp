package com.example.paymentlistapp.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentlistapp.Model.Response
import com.example.paymentlistapp.Repository.PaymentsRepository
import kotlinx.coroutines.launch

class PaymentsViewModel(
    private val repository: PaymentsRepository
): ViewModel() {
    private val _response = MutableLiveData<Boolean>()
    val response: LiveData<Boolean>
        get() = _response

    private val _payments = MutableLiveData<List<Response>>()
    val payments: LiveData<List<Response>>
        get() = _payments

    fun getPaymentResponse() = viewModelScope.launch {
        repository.getPaymentResponse().let { response ->
            if (response.isSuccessful && response.body() != null)
                _payments.postValue(response.body()!!.response)
            else
                Log.d("tag", "getForecast Error: ${response.code()}")
        }
    }

    init {
        getPaymentResponse()
    }
}