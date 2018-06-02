package com.ademlo.restart.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ademlo.restart.R
import com.ademlo.restart.model.Dish
import com.ademlo.restart.model.Dishes

class DishAdapter: RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    constructor(): super(){
        itemClickListener = null
    }

    constructor(itemClickListener: ((Dish, Int) -> Unit)): super(){
        this.itemClickListener = itemClickListener
    }

    private var items = Dishes.dishes
    private val itemClickListener: ((Dish, Int) -> Unit)?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish,parent,false)
        return DishViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.dish = items[position]
    }


    inner class DishViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var dish: Dish? = null
            set(value) {
                itemView.findViewById<TextView>(R.id.label_dish_name).text = value?.name

                field = value
            }

        init {
            itemView.setOnClickListener {
                dish?.let {
                    itemClickListener?.invoke(dish as Dish,adapterPosition)
                }
            }
        }
    }
}