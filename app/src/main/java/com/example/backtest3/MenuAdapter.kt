package com.example.backtest3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(val context: Context, val menu_list: ArrayList<Menu_Model>) : RecyclerView.Adapter<MenuAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.rc_item,parent,false)
        return Holder(view/*, itemClick*/)
    }

    override fun getItemCount(): Int {
        return menu_list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(menu_list[position],context)
        holder.itemView.setOnClickListener{
            val intent = Intent(context, Detail_orderActivity::class.java)
            intent.putExtra("drinkname",menu_list[position].drink_name)
            intent.putExtra("drinkprice",menu_list[position].drink_price)
            intent.putExtra("count","0")
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
        }
    }

    inner class Holder(itemView: View?/*,itemClick: (Menu_Model) -> Unit*/) : RecyclerView.ViewHolder(itemView!!) {
        val drink_img = itemView?.findViewById<ImageView>(R.id.drink_img)
        val drink_name = itemView?.findViewById<TextView>(R.id.drink_name)
        val drink_price = itemView?.findViewById<TextView>(R.id.drink_price)

        fun bind(menu : Menu_Model, context: Context){
            if (menu.drink_img != ""){
                val resourceId = context.resources.getIdentifier(menu.drink_img,"drawable",context.packageName)
                drink_img?.setImageResource(resourceId)
            } else{
                drink_img?.setImageResource(R.mipmap.ic_launcher)
            }
            drink_name?.text = menu.drink_name
            drink_price?.text = menu.drink_price
            /*itemView.setOnClickListener{ itemClick() }*/
            //https://hamzzibari.tistory.com/109?category=802914
        }
    }
}