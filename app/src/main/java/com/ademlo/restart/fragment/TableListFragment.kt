package com.ademlo.restart.fragment

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.ademlo.restart.R
import com.ademlo.restart.model.Table
import com.ademlo.restart.model.Tables
import kotlinx.android.synthetic.main.fragment_table_list.*

class TableListFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = TableListFragment()
    }

    private var onTableSelectedListener: onTableListSelectedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter<Table>(
                activity,android.R.layout.simple_list_item_1,
                Tables.toArray()
        )

        table_list.adapter = adapter

        table_list.setOnItemClickListener { _, _, index, _ ->
            // Avisamos al listener que una ciudad ha sido seleccionada
            onTableSelectedListener?.onTableListSelected(Tables.getTable(index), index)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context as Activity)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    private fun commonAttach(activity: Activity?) {
        if (activity is onTableListSelectedListener) {
            onTableSelectedListener = activity
        }
        else {
            onTableSelectedListener = null
        }
    }

    override fun onDetach() {
        super.onDetach()
        onTableSelectedListener = null
    }

    interface onTableListSelectedListener {
        fun onTableListSelected(table: Table, menuIndex: Int)
    }


}
