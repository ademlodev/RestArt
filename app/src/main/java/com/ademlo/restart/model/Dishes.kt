package com.ademlo.restart.model

import com.ademlo.restart.R

object Dishes {

    private val dishes: List<Dish> = listOf(
            Dish("Ensalada Cesar", "Ensalada con lechuga, pollo, trocitos de pan tostado aderezado con una salsa de yogurth y perejil", "Lechuga, Tiras de pollo, Pan tostado, Salsa", 8f, R.drawable.noimage),
            Dish("Ensalada Cesar", "Ensalada con lechuga, pollo, trocitos de pan tostado aderezado con una salsa de yogurth y perejil", "Lechuga, Tiras de pollo, Pan tostado, Salsa", 8f, R.drawable.noimage),
            Dish("Ensalada Cesar", "Ensalada con lechuga, pollo, trocitos de pan tostado aderezado con una salsa de yogurth y perejil", "Lechuga, Tiras de pollo, Pan tostado, Salsa", 8f, R.drawable.noimage)
    )
    val countDishes
        get() = dishes.size

    fun getDish(index: Int) = dishes[index]

}