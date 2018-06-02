package com.ademlo.restart.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ademlo.restart.R
import com.ademlo.restart.model.Dish

class OrderAdapter: RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    private var items = mutableListOf<Dish>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order,parent,false)

        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.order = items[position]
    }

    fun setOrders(orders: MutableList<Dish>){
        items.clear()
        items.addAll(orders)

    }

    inner class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var order: Dish? = null
            set(value) {
                itemView.findViewById<TextView>(R.id.label_order_name).text = value?.name

                field = value
            }
    }
}