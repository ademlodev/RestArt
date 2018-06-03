package com.ademlo.restart.model

import java.io.Serializable

data class Dish(val id: Int, val name: String,val description: String,val ingredients: String,val price: Float,val image: Int, val alergenMilk: Boolean, val alergenEgg: Boolean, val alergenFish: Boolean, val alergenGluten: Boolean):Serializable{
    override fun toString() = name
}