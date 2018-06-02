package com.ademlo.restart.model

import com.ademlo.restart.R

object Tables {

    val tables: MutableList<Table> = mutableListOf(
            Table(name = "Mesa 1", dishes = mutableListOf(
                    Dish("Ensalada Cesar", "Ensalada con lechuga, pollo, trocitos de pan tostado aderezado con una salsa de yogurth y perejil", "Lechuga, Tiras de pollo, Pan tostado, Salsa", 8f, R.drawable.noimage),
                    Dish("Ensaladilla Rusa", "Ensalada con patata, guisantes, zanahoria, atún y mahonesa", "patata, guisantes, zanahoria, atún, mahonesa", 5f, R.drawable.noimage),
                    Dish("Paella", "Arroz con pollo y demas ingredientes", "Arroz, pollo", 7.5f, R.drawable.noimage)
            )),
            Table(name = "Mesa 2", dishes = null),
            Table(name ="Mesa 3",dishes =  mutableListOf(
                    Dish("Paella", "Arroz con pollo y demas ingredientes", "Arroz, pollo", 7.5f, R.drawable.noimage)
            )),
            Table(name ="Mesa 4",dishes = null),
            Table(name ="Mesa 5",dishes =  null),
            Table(name ="Mesa 6",dishes =  null),
            Table(name ="Mesa 7",dishes =  null),
            Table(name ="Mesa 8",dishes =  null)
    )

    val count: Int
        get() = tables.size

    fun getOrder(index: Int) = tables[index].dishes

    fun toArray() = tables.toTypedArray()
}