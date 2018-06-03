package com.ademlo.restart.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
                value?.image?.let { itemView.findViewById<ImageView>(R.id.item_image_view).setImageResource(it) }
                itemView.findViewById<TextView>(R.id.item_dish_name_txt).text = value?.name
                itemView.findViewById<TextView>(R.id.item_dish_price_txt).text = value?.price.toString() + "€"

                itemView.findViewById<ImageView>(R.id.alergen_egg).visibility = View.INVISIBLE
                value?.alergenEgg.let {
                    if (value!!.alergenEgg) {
                        itemView.findViewById<ImageView>(R.id.alergen_egg).visibility = View.VISIBLE
                    }
                }

                itemView.findViewById<ImageView>(R.id.alergen_milk).visibility = View.INVISIBLE
                value?.alergenMilk.let {
                    if (value!!.alergenMilk) {
                        itemView.findViewById<ImageView>(R.id.alergen_milk).visibility = View.VISIBLE
                    }
                }

                itemView.findViewById<ImageView>(R.id.alergen_gluten).visibility = View.INVISIBLE
                value?.alergenGluten.let {
                    if (value!!.alergenGluten) {
                        itemView.findViewById<ImageView>(R.id.alergen_gluten).visibility = View.VISIBLE
                    }
                }

                itemView.findViewById<ImageView>(R.id.alergen_fish).visibility = View.INVISIBLE
                value?.alergenFish.let {
                    if (value!!.alergenFish) {
                        itemView.findViewById<ImageView>(R.id.alergen_fish).visibility = View.VISIBLE
                    }
                }

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