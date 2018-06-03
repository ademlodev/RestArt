package com.ademlo.restart.model

import java.io.Serializable
import java.util.*

data class Table(var id: String = UUID.randomUUID().toString(), var name: String, var dishes: MutableList<Dish>?): Serializable{
    override fun toString() = name
}