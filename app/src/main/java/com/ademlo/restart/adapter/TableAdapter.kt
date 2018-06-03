package com.ademlo.restart.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ademlo.restart.R
import com.ademlo.restart.model.Table

class TableAdapter(private var items : List<Table>): RecyclerView.Adapter<TableAdapter.TableViewHolder>() {

    var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_table,parent,false)
        // Le decimos a este view que cuando lo pulsen avise a nuestro onClickListener
        view.setOnClickListener {
            onClickListener?.onClick(it)
        }
        return TableViewHolder(view)
    }

    override fun getItemCount()= items.size

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.bindTable(items[position])
    }

    inner class TableViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var nameTableText = itemView.findViewById<TextView>(R.id.label_table_name)

        fun bindTable(table: Table) {
            // Actualizamos la vista con el modelo
            nameTableText?.text = table.name
        }
    }
}