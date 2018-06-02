package com.ademlo.restart.model

import com.ademlo.restart.R

object Dishes {

    private val dishes: List<Dish> = listOf(
            Dish("Ensalada Cesar", "Ensalada con lechuga, pollo, trocitos de pan tostado aderezado con una salsa de yogurth y perejil", "Lechuga, Tiras de pollo, Pan tostado, Salsa", 8f, R.drawable.noimage),
            Dish("Ensaladilla Rusa", "Ensalada con patata, guisantes, zanahoria, atún y mahonesa", "patata, guisantes, zanahoria, atún, mahonesa", 5f, R.drawable.noimage),
            Dish("Paella", "Arroz con pollo y demas ingredientes", "Arroz, pollo", 7.5f, R.drawable.noimage)
    )
    val countDishes
        get() = dishes.size

    fun getDish(index: Int) = dishes[index]

}