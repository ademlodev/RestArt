package com.ademlo.restart.model

import android.media.Image

data class Dish(val id: Int, val name: String,val description: String,val ingredients: String,val price: Float,val image: Int){
    override fun toString() = name
}