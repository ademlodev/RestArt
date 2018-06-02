package com.ademlo.restart.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ademlo.restart.R
import com.ademlo.restart.adapter.OrderAdapter
import com.ademlo.restart.adapter.TableAdapter
import com.ademlo.restart.model.Dish
import com.ademlo.restart.model.Tables

class OrdersListActivity : AppCompatActivity() {

    val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"

    val orderList: RecyclerView by lazy {
        val list: RecyclerView = findViewById(R.id.order_list)
        list.layoutManager = LinearLayoutManager(this)

        list
    }

    val orderAdapter: OrderAdapter by lazy {
        val adapter = OrderAdapter()
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders_list)

        val tableId: Int = intent.getIntExtra(EXTRA_TABLE_INDEX,0)

        orderList.adapter = orderAdapter

        val orders: MutableList<Dish>? = Tables.getOrder(tableId)
        orders?.let {
            orderAdapter.setOrders(orders)
        }

    }
}
