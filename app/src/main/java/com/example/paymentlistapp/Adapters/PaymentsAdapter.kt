package com.example.paymentlistapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paymentlistapp.Model.Response
import com.example.paymentlistapp.R
import kotlinx.android.synthetic.main.payment_card.view.*

class PaymentsAdapter(private val paymentsList: List<Response>):
    RecyclerView.Adapter<PaymentsAdapter.PaymentsViewHolder>()
{
    inner class PaymentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsViewHolder {
        return PaymentsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.payment_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PaymentsViewHolder, position: Int) {
        val payment = paymentsList[position]


    }

    override fun getItemCount(): Int {
        return paymentsList.size
    }
}