package com.example.backtest3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (val context: Context, val list : ArrayList<Category_Model>) :
    RecyclerView.Adapter<CategoryAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.vertical_rc_item,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryAdapter.Holder, position: Int) {
        holder?.bind(list[position],context)
    }
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView!!) {

        val category_name  = itemView.findViewById<TextView>(R.id.category)
        val horizon_rc = itemView.findViewById<RecyclerView>(R.id.horizon_rc)
        fun bind(vertical_list: Category_Model, context: Context){

            category_name.text = vertical_list.category
            val adapter1 = MenuAdapter(context,vertical_list.menus)
            /*{ Menu_Model ->
                Toast.makeText(itemView.context,"item!!!!!",Toast.LENGTH_SHORT).show()
                val intent = Intent(itemView.context,Detail_orderActivity::class.java)
                intent.putExtra("drink_name",Menu_Model.drink_name)
                intent.putExtra("drink_price",Menu_Model.drink_price)
                startActivity(intent)
            }*/
            horizon_rc.adapter = adapter1
            val lm = LinearLayoutManager(context)
            horizon_rc.layoutManager = lm.also { it.orientation = LinearLayoutManager.HORIZONTAL }
            horizon_rc.isNestedScrollingEnabled = true
            horizon_rc.setHasFixedSize(true)
        }
    }


}
