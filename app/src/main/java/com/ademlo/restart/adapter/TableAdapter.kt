package com.ademlo.restart.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import com.ademlo.restart.R
import com.ademlo.restart.model.Table
import kotlinx.android.synthetic.main.activity_tables_list.view.*

class TableAdapter: RecyclerView.Adapter<TableAdapter.TableViewHolder> {

    constructor(): super(){
        itemClickListener = null
    }

    constructor(itemClickListener: ((Table, Int) -> Unit)): super(){
        this.itemClickListener = itemClickListener
    }

    private var items = mutableListOf<Table>()
    private val itemClickListener: ((Table, Int) -> Unit)?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_table,parent,false)

        return TableViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.table = items[position]
    }

    fun setTables(tables: MutableList<Table>){
        items.clear()
        items.addAll(tables)

    }

    inner class TableViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var table: Table? = null
            set(value) {
                itemView.findViewById<TextView>(R.id.label_table_name).text = value?.name

                field = value
            }

        init {
            itemView.setOnClickListener {
                table?.let {
                    itemClickListener?.invoke(table as Table,adapterPosition)
                }
            }
        }


    }
}