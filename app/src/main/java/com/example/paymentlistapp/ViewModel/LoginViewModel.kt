package com.example.paymentlistapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paymentlistapp.Repository.PaymentsRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: PaymentsRepository
): ViewModel() {
    private val _token = MutableLiveData<String>()
    val token: LiveData<String>
        get() = _token

    fun login() = viewModelScope.launch {
        repository.login().let { response ->
            if (response.isSuccessful && response.body() != null)
                _token.postValue(response.body()!!.response.token)
        }
    }
}