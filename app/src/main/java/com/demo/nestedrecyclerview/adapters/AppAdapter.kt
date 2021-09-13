package com.demo.nestedrecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.demo.nestedrecyclerview.R
import com.demo.nestedrecyclerview.databinding.ItemAppBinding
import com.demo.nestedrecyclerview.models.App
import java.util.*

/**
 *  Create by ThanhPQ
 */
class AppAdapter(itemsList: ArrayList<App>) :
    RecyclerView.Adapter<AppAdapter.SingleItemRowHolder>() {
    private val itemsList: ArrayList<App> = itemsList

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SingleItemRowHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_app, null)
        return SingleItemRowHolder(view)
    }

    override fun onBindViewHolder(holder: SingleItemRowHolder, i: Int) {
        val singleItem: App = itemsList[i]
        holder.setData(singleItem)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    inner class SingleItemRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: ItemAppBinding = ItemAppBinding.bind(view)
        private var layout: View = view

        fun setData(appData: App) {
            layout.setOnClickListener { v ->
                Toast.makeText(v.context, appData.name, Toast.LENGTH_SHORT).show()
            }

            binding.apply {
                app = appData
                executePendingBindings()
            }
        }
    }

}
