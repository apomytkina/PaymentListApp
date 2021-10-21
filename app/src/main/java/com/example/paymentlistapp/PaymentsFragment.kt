package com.example.paymentlistapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paymentlistapp.Adapters.PaymentsAdapter
import com.example.paymentlistapp.Api.GetRetrofitInstance
import com.example.paymentlistapp.Api.PaymentApi
import com.example.paymentlistapp.Repository.PaymentsRepository
import kotlinx.android.synthetic.main.fragment_payments.*

class PaymentsFragment : Fragment() {
    private lateinit var paymentsAdapter: PaymentsAdapter
    private lateinit var viewModelFactory: PaymentsViewModelFactory
    private lateinit var viewModel: PaymentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository = PaymentsRepository(GetRetrofitInstance.api)
        viewModelFactory = PaymentsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PaymentsViewModel::class.java)
        setUpRecyclerView()

        viewModel.payments.observe(viewLifecycleOwner, Observer { response ->
            response?.let {

            }
        })

        return inflater.inflate(R.layout.fragment_payments, container, false)
    }

    private fun setUpRecyclerView(){
        paymentsAdapter = PaymentsAdapter(viewModel.payments.value!!)
        rvPayments.apply {
            adapter = paymentsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}