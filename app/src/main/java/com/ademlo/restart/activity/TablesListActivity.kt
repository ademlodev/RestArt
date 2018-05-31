package com.ademlo.restart.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ademlo.restart.R
import com.ademlo.restart.fragment.TableListFragment
import com.ademlo.restart.model.Table

class TablesListActivity : AppCompatActivity(), TableListFragment.onTableListSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tables_list)

        //Comprobar primero si no hay fragment
        if (supportFragmentManager.findFragmentById(R.id.table_list) == null) {
            var tableListFragment = TableListFragment.newInstance()

            supportFragmentManager.beginTransaction()
                    .add(R.id.table_list_fragment, tableListFragment)
                    .commit()
        }
    }

    override fun onTableListSelected(table: Table, menuIndex: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
