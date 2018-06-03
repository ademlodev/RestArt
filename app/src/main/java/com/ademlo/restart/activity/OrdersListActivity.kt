package com.ademlo.restart.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ademlo.restart.R
import com.ademlo.restart.fragment.OrderListFragment

class OrdersListActivity : AppCompatActivity() {

    companion object {

        val EXTRA_TABLE_ID = "EXTRA_TABLE_ID"

        fun intent(context: Context, tableId: String): Intent {
            val intent = Intent(context, OrdersListActivity::class.java)
            intent.putExtra(EXTRA_TABLE_ID, tableId)

            return intent
        }
    }

    lateinit var tableId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders_list)

        tableId = intent.getStringExtra(EXTRA_TABLE_ID)

        if (supportFragmentManager.findFragmentById(R.id.order_list_fragment) == null) {
            // Hay hueco, y habiendo hueco metemos el fragment
            val fragment = OrderListFragment.newInstance(tableId)
            supportFragmentManager.beginTransaction()
                    .add(R.id.order_list_fragment, fragment)
                    .commit()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
