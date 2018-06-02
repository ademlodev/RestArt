package com.ademlo.restart.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.ademlo.restart.R
import com.ademlo.restart.adapter.OrderAdapter
import com.ademlo.restart.model.Dish
import com.ademlo.restart.model.Dishes
import com.ademlo.restart.model.Tables
import kotlinx.android.synthetic.main.activity_orders_list.*

class OrdersListActivity : AppCompatActivity() {

    val EXTRA_TABLE_INDEX = "EXTRA_TABLE_INDEX"
    val EXTRA_DISH_INDEX = "EXTRA_DISH_INDEX"
    val DISH_LIST_REQUEST = 1

    var orders: MutableList<Dish>? = null
    lateinit var tableId: String

    val orderList: RecyclerView by lazy {
        val list: RecyclerView = findViewById(R.id.order_list)
        list.layoutManager = LinearLayoutManager(this)

        list
    }

    val orderAdapter: OrderAdapter by lazy {
        val adapter = OrderAdapter{ item, position ->
            showDishDetail(item.id)
        }
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders_list)

        tableId = intent.getStringExtra(EXTRA_TABLE_INDEX)

        orderList.adapter = orderAdapter

        orders = Tables.getOrder(tableId)
        orders?.let {
            orderAdapter.setOrders(orders!!)
        }

        add_dish.setOnClickListener {
            showListDishes()
        }
    }

    fun showDishDetail(dishId: Int){
        val intent: Intent = Intent(this,DishDetailActivity::class.java)
        intent.putExtra(EXTRA_DISH_INDEX,dishId)
        startActivity(intent)
    }

    fun showListDishes(){
        /*val intent: Intent = Intent(this,DishListActivity::class.java)
        startActivity(intent)*/

        startActivityForResult(DishListActivity.intent(this), DISH_LIST_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            DISH_LIST_REQUEST -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val dishId = data.getIntExtra(DishListActivity.EXTRA_DISH_ID, 0)
                    val dish = Dishes.getDishById(dishId)

                    if (dish != null) {
                        Tables.setOrder(tableId, dish)
                        orders = Tables.getOrder(tableId)
                        orders?.let {
                            orderAdapter.setOrders(orders!!)
                        }
                        orderAdapter.notifyDataSetChanged()
                    }
                    //TODO Meter SnackBar para poder deshacer
                }
                else {
                    //TODO No se ha seleccionado nada.
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_order,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            R.id.calculate_bill -> {
                //TODO Calcular el precio de la mesa y mostrarlo en un alert
                var bill: Float = 0f
                orders?.let {
                    val iterate = orders!!.listIterator()
                    while (iterate.hasNext()) {
                        val value = iterate.next()
                        bill += value.price
                    }
                }

                AlertDialog.Builder(this)
                        .setTitle("La cuenta")
                        .setMessage("El total de la mesa es: " + bill)
                        .setPositiveButton(android.R.string.ok,null)
                        .show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
