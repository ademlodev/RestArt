package com.ademlo.restart.model

import com.ademlo.restart.R

object Dishes {

    val dishes: List<Dish> = listOf(
            Dish(1,"Ensalada Cesar", "Ensalada con lechuga, pollo, trocitos de pan tostado aderezado con una salsa de yogurth y perejil", "Lechuga, Tiras de pollo, Pan tostado, Salsa", 8f, R.drawable.ensalada_cesar),
            Dish(2,"Ensaladilla Rusa", "Ensalada con patata, guisantes, zanahoria, atún y mahonesa", "patata, guisantes, zanahoria, atún, mahonesa", 5f, R.drawable.ensaladilla_rusa),
            Dish(3,"Paella", "Arroz con pollo y demas ingredientes", "Arroz, pollo", 7.5f, R.drawable.paella)
    )
    val countDishes
        get() = dishes.size

    fun getDish(index: Int) = dishes[index]

    fun getDishById(id: Int): Dish? {
        return dishes.find {
            it.id == id
        }
    }
}