package com.ademlo.restart.model

import com.ademlo.restart.R

object Tables {

    val tables: MutableList<Table> = mutableListOf(
            Table(name = "Mesa 1", dishes = mutableListOf(
                    Dish(1,"Ensalada Cesar", "Ensalada con lechuga, pollo, trocitos de pan tostado aderezado con una salsa de yogurth y perejil", "Lechuga, Tiras de pollo, Pan tostado, Salsa", 8f, R.drawable.ensalada_cesar,false,false,false,true),
                    Dish(3,"Paella", "Arroz con pollo y demas ingredientes", "Arroz, pollo", 7.5f, R.drawable.paella,false,false,false,false)
                )
            ),
            Table(name = "Mesa 2", dishes = null),
            Table(name ="Mesa 3",dishes =  mutableListOf(
                    Dish(3,"Paella", "Arroz con pollo y demas ingredientes", "Arroz, pollo", 7.5f, R.drawable.paella,false,false,false,false),
                    Dish(5,"Flan de huevo", "Flan de huevo casero receta secreta", "Huevo, leche, azucar", 4.5f, R.drawable.flan_huevo,true,true,false,false)
                )
            ),
            Table(name ="Mesa 4",dishes = null),
            Table(name ="Mesa 5",dishes =  null),
            Table(name ="Mesa 6",dishes =  null),
            Table(name ="Mesa 7",dishes =  null),
            Table(name ="Mesa 8",dishes =  null)
    )

    val count: Int
        get() = tables.size

    fun getTableById(id: String): Table?{
        return tables.find {
            it.id == id
        }
    }

    fun getTable(index: Int): Table{
        return Tables.tables[index]
    }
    fun getOrder(id: String): MutableList<Dish>?{
        val table = getTableById(id)
        return table?.dishes
    }
    fun setOrder(id: String, dish:Dish){
        val table: Table? = getTableById(id)
        if (table?.dishes == null){
            table?.dishes = mutableListOf()
        }
        table?.dishes?.add(dish)
    }
    fun removeOrder(id: String){
        val table: Table? = getTableById(id)
        if (table?.dishes?.size  == 1){
            table?.dishes = null
        }else {
            table?.dishes?.dropLast(1)
        }
    }

    fun toArray() = tables.toTypedArray()
}