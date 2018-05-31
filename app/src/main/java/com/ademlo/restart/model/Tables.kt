package com.ademlo.restart.model

object Tables {

    private val tables: List<Table> = listOf(
            Table("Mesa 1"),
            Table("Mesa 2"),
            Table("Mesa 3"),
            Table("Mesa 4"),
            Table("Mesa 5"),
            Table("Mesa 6"),
            Table("Mesa 7"),
            Table("Mesa 8")
    )

    val count: Int
        get() = tables.size

    fun getTable(index: Int) = tables[index]



    fun toArray() = tables.toTypedArray()
}