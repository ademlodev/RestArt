package com.ademlo.restart.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ademlo.restart.R
import com.ademlo.restart.adapter.TableAdapter
import com.ademlo.restart.model.Table
import com.ademlo.restart.model.Tables

class TablesListActivity : AppCompatActivity() {

    val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"

    val tableList: RecyclerView by lazy {
        val list: RecyclerView = findViewById(R.id.table_list)
        list.layoutManager = LinearLayoutManager(this)

        list
    }

    val tableAdapter: TableAdapter by lazy {
        val adapter = TableAdapter{ item, position ->
            showOrderList(position)
        }
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables_list)

        tableList.adapter = tableAdapter

        val tables: MutableList<Table> = Tables.tables
        tableAdapter.setTables(tables)

    }

    fun showOrderList(tableId: Int){
        val intent: Intent  = Intent(this,OrdersListActivity::class.java)
        intent.putExtra(EXTRA_TABLE_INDEX,tableId)
        startActivity(intent)
    }

}
