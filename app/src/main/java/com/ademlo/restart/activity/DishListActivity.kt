package com.ademlo.restart.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ademlo.restart.R
import com.ademlo.restart.adapter.DishAdapter

class DishListActivity : AppCompatActivity() {

    companion object {
        val EXTRA_DISH_ID = "EXTRA_DISH_ID"

        fun intent(context: Context) = Intent(context, DishListActivity::class.java)
    }

    val dishList: RecyclerView by lazy {
        val list: RecyclerView = findViewById(R.id.dish_list)
        list.layoutManager = LinearLayoutManager(this)
        list
    }

    val dishAdapter: DishAdapter by lazy {
        val adapter = DishAdapter{ item, position ->
            val returnIntent = Intent()
            returnIntent.putExtra(EXTRA_DISH_ID, item.id)

            setResult(Activity.RESULT_OK, returnIntent)

            finish()
        }
        adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_list)

        dishList.adapter = dishAdapter
    }
}
