package com.ademlo.restart.model

import android.media.Image

data class Dish(val name: String,val description: String,val ingredients: String,val price: Float,val images: Int){
    override fun toString() = name
}