package com.ademlo.restart.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.GridLayoutManager
import android.view.*
import com.ademlo.restart.R
import com.ademlo.restart.activity.DishDetailActivity
import com.ademlo.restart.activity.DishListActivity
import com.ademlo.restart.adapter.OrderAdapter
import com.ademlo.restart.model.Dish
import com.ademlo.restart.model.Dishes
import com.ademlo.restart.model.Tables
import kotlinx.android.synthetic.main.fragment_order_list.*

class OrderListFragment : Fragment() {

    companion object {
        val ARG_TABLE = "ARG_TABLE"
        val DISH_LIST_REQUEST = 1

        @JvmStatic
        fun newInstance(tableId: String): Fragment {
            val fragment = OrderListFragment()
            val arguments = Bundle()

            arguments.putString(ARG_TABLE, tableId)
            fragment.arguments = arguments
            return fragment
        }
    }

    var orders: MutableList<Dish>? = null
        set(value) {
            field = value

            if (value != null) {
                val adapter = OrderAdapter(value)
                order_list.adapter = adapter
                setRecyclerViewClickListener()
            }
        }
    lateinit var tableId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater!!, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_order_list, container, false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view!!, savedInstanceState)

        order_list.layoutManager = GridLayoutManager(activity, resources.getInteger(R.integer.order_columns))

        val initialTableId = arguments?.getString(ARG_TABLE)
        tableId = initialTableId!!

        if (initialTableId != null) {
            orders = Tables.getOrder(initialTableId)
        }

        add_dish.setOnClickListener {
            showListDishes()
        }
    }

    fun updateOrders(tableId: String){
        this.tableId = tableId
        orders = Tables.getOrder(tableId)
        if (orders != null){
            order_list.visibility = View.VISIBLE
        }else{
            order_list.visibility = View.GONE
        }
    }

    fun setRecyclerViewClickListener() {
        // Si alguien pulsa un elemento del RecyclerView, nos queremos enterar aquí
        val adapter = order_list?.adapter as? OrderAdapter
        adapter?.onClickListener = View.OnClickListener {
            // Alguien ha pulsado un elemento del RecyclerView
            val dishIndex = order_list.getChildAdapterPosition(it)
            val dishId = orders?.get(dishIndex)?.id

            startActivity(DishDetailActivity.intent(activity!!, dishId!!))
        }
    }

    fun showListDishes(){
        startActivityForResult(DishListActivity.intent(activity!!), DISH_LIST_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            DISH_LIST_REQUEST -> {
                if (resultCode == Activity.RESULT_OK && data != null) {

                    val dishId = data.getIntExtra(DishListActivity.EXTRA_DISH_ID, 0)
                    val dish = Dishes.getDishById(dishId)
                    if (dish != null) {

                        Tables.setOrder(tableId!!, dish)

                        val orderListFragment = fragmentManager?.findFragmentById(R.id.order_list_fragment) as OrderListFragment
                        if (orderListFragment != null) {
                            orderListFragment.updateOrders(tableId)
                        }

                        //Meter SnackBar informativo y para poder deshacer
                        Snackbar.make(view!!, getString(R.string.snackbar_add_dish), Snackbar.LENGTH_LONG)
                                .setAction(getString(R.string.undo)) {
                                    Tables.removeOrder(tableId!!)

                                    val orderListFragment = fragmentManager?.findFragmentById(R.id.order_list_fragment) as OrderListFragment
                                    if (orderListFragment != null) {
                                        orderListFragment.updateOrders(tableId)
                                    }
                                }
                                .show()

                    }

                }
                else {
                    // No se ha seleccionado nada. Insertar mensaje Toast?
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.activity_order,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.calculate_bill -> {

            var bill: Float = 0f

            orders = Tables.getOrder(tableId)
            orders?.let {
                val iterate = orders!!.listIterator()
                while (iterate.hasNext()) {
                    val value = iterate.next()
                    bill += value.price
                }
            }

            AlertDialog.Builder(activity!!)
                    .setTitle("La cuenta")
                    .setMessage("El total de la mesa es: " + bill + " €")
                    .setPositiveButton(android.R.string.ok,null)
                    .show()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}
