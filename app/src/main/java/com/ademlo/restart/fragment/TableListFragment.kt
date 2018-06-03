package com.ademlo.restart.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ademlo.restart.R
import com.ademlo.restart.activity.OrdersListActivity
import com.ademlo.restart.adapter.TableAdapter
import com.ademlo.restart.model.Table
import com.ademlo.restart.model.Tables
import kotlinx.android.synthetic.main.fragment_table.*

class TableListFragment: Fragment() {

    val EXTRA_TABLE_ID = "EXTRA_TABLE_ID"

    companion object {
        @JvmStatic
        fun newInstance() = TableListFragment()
    }

    var tables: List<Table>? = null
        set(value) {
            field = value

            if (value != null) {
                val adapter = TableAdapter(value)
                table_list.adapter = adapter
                setRecyclerViewClickListener()
            }
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater!!, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_table,container,false)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view!!, savedInstanceState)

        table_list.layoutManager = GridLayoutManager(activity, resources.getInteger(R.integer.table_columns))

        tables = Tables.tables

    }

    fun setRecyclerViewClickListener() {
        // Si alguien pulsa un elemento del RecyclerView, nos queremos enterar aquí
        val adapter = table_list?.adapter as? TableAdapter
        adapter?.onClickListener = View.OnClickListener {

            val tableIndex = table_list.getChildAdapterPosition(it)
            val table = Tables.getTable(tableIndex)

            val orderListFragment = fragmentManager?.findFragmentById(R.id.order_list_fragment) as? OrderListFragment
            if (orderListFragment != null) {
                orderListFragment.updateOrders(table.id)
            }else {
                startActivity(OrdersListActivity.intent(activity!!, table.id))
            }
        }
    }
}