package com.ademlo.restart.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ademlo.restart.R
import com.ademlo.restart.model.Dish
import com.ademlo.restart.model.Table

class OrderAdapter(private var items : MutableList<Dish>): RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order,parent,false)
        view.setOnClickListener {
            onClickListener?.onClick(it)
        }
        return OrderViewHolder(view)
    }

    override fun getItemCount()= items.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bindOrder(items[position])
    }

    /* En landscape no he averiguado como actualizar la lista de la derecha
    fun setOrders(orders: List<Dish>?){
        if (orders != null) {
            items.clear()
            items.addAll(orders)
        }else
            items.clear()
        notifyDataSetChanged()
    }*/

    inner class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var nameOrderText = itemView.findViewById<TextView>(R.id.label_order_name)

        fun bindOrder(order: Dish) {
            // Actualizamos la vista con el modelo
            nameOrderText?.text = order.name
        }
    }
}