package com.demo.nestedrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.nestedrecyclerview.R
import com.demo.nestedrecyclerview.models.App
import com.demo.nestedrecyclerview.models.Section
import java.util.*

class SectionAdapter(context: Context, dataList: ArrayList<Section>) :
    RecyclerView.Adapter<SectionAdapter.ItemRowHolder>() {
    private val dataList: ArrayList<Section> = dataList
    private val mContext: Context = context

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemRowHolder {
        val v: View = LayoutInflater.from(mContext).inflate(R.layout.item_section, viewGroup, false)
        return ItemRowHolder(v)
    }

    override fun onBindViewHolder(itemRowHolder: ItemRowHolder, i: Int) {
        val sectionName: String = dataList[i].headerTitle
        val singleSectionItems: ArrayList<App> = dataList[i].allItemsInSection
        val itemListDataAdapter = AppAdapter(singleSectionItems)

        itemRowHolder.apply {
            itemTitle.text = sectionName
            recyclerSection.setHasFixedSize(true)
            recyclerSection.layoutManager = LinearLayoutManager(
                mContext,
                LinearLayoutManager.HORIZONTAL, false
            )
            recyclerSection.adapter = itemListDataAdapter
            recyclerSection.isNestedScrollingEnabled = false
            btnMore.setOnClickListener { v ->
                Toast.makeText(
                    v.context, "click event on more, $sectionName",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ItemRowHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTitle: TextView = view.findViewById(R.id.itemTitle)
        var recyclerSection: RecyclerView = view.findViewById(R.id.recycler_view_list)
        var btnMore: Button = view.findViewById(R.id.btnMore)
    }

}