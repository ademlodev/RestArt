package com.ademlo.restart.model

import android.media.Image

data class Dish(val id: Int, val name: String,val description: String,val ingredients: String,val price: Float,val image: Int, val alergenMilk: Boolean, val alergenEgg: Boolean, val alergenFish: Boolean, val alergenGluten: Boolean){
    override fun toString() = name
}