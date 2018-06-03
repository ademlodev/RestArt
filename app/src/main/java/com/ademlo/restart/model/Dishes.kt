package com.ademlo.restart.model

import com.ademlo.restart.R

object Dishes {

    val dishes: List<Dish> = listOf(
            Dish(1,"Ensalada Cesar", "Ensalada con lechuga, pollo, trocitos de pan tostado aderezado con una salsa de yogurth y perejil", "Lechuga, Tiras de pollo, Pan tostado, Salsa", 8f, R.drawable.ensalada_cesar,false,false,false,true),
            Dish(2,"Ensaladilla Rusa", "Ensalada con patata, guisantes, zanahoria, atún y mahonesa", "patata, guisantes, zanahoria, atún, mahonesa", 5f, R.drawable.ensaladilla_rusa,false,true,false,false),
            Dish(3,"Paella", "Arroz con pollo y demas ingredientes", "Arroz, pollo", 7.5f, R.drawable.paella,false,false,false,false),
            Dish(4,"Salmon marinado", "Salmon al horno con especias y la salsa especial del cocinero", "Salmon y especias", 12.9f, R.drawable.salmon_marinado,false,false,true,false),
            Dish(5,"Flan de huevo", "Flan de huevo casero receta secreta", "Huevo, leche, azucar", 4.5f, R.drawable.flan_huevo,true,true,false,false)
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