package com.ademlo.restart.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.ademlo.restart.R
import com.ademlo.restart.fragment.OrderListFragment
import com.ademlo.restart.fragment.TableListFragment
import com.ademlo.restart.model.Tables

class TablesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables_list)

        if(findViewById<ViewGroup>(R.id.table_list_fragment) != null){
            if (supportFragmentManager.findFragmentById(R.id.table_list_fragment) == null) {
                val table_list_fragment: TableListFragment = TableListFragment.newInstance()

                supportFragmentManager.beginTransaction()
                        .add(R.id.table_list_fragment, table_list_fragment)
                        .commit()
            }
        }

        if(findViewById<ViewGroup>(R.id.order_list_fragment) != null){
            if (supportFragmentManager.findFragmentById(R.id.order_list_fragment) == null) {
                //Selecciono la primera mesa
                val initialTableId :String = Tables.tables[0].id
                val order_list_fragment: Fragment = OrderListFragment.newInstance(initialTableId)

                supportFragmentManager.beginTransaction()
                        .add(R.id.order_list_fragment, order_list_fragment)
                        .commit()
            }
        }
    }
}

