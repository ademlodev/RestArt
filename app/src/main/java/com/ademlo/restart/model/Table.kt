package com.ademlo.restart.model

import java.util.*

data class Table(var id: String = UUID.randomUUID().toString(), var name: String, var dishes: MutableList<Dish>?){
    override fun toString() = name
}