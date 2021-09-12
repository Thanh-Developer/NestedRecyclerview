package com.demo.nestedrecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.demo.nestedrecyclerview.R
import com.demo.nestedrecyclerview.models.App
import java.util.*

class AppAdapter(itemsList: ArrayList<App>) :
    RecyclerView.Adapter<AppAdapter.SingleItemRowHolder>() {
    private val itemsList: ArrayList<App> = itemsList

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SingleItemRowHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_app, null)
        return SingleItemRowHolder(view)
    }

    override fun onBindViewHolder(holder: SingleItemRowHolder, i: Int) {
        val singleItem: App = itemsList[i]
        holder.tvTitle.text = singleItem.name
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    inner class SingleItemRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView = view.findViewById(R.id.tvTitle)
        var itemImage: ImageView = view.findViewById(R.id.itemImage)

        init {
            view.setOnClickListener { v ->
                Toast.makeText(v.context, tvTitle.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

}