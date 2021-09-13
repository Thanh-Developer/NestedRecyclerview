package com.demo.nestedrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.nestedrecyclerview.adapters.SectionAdapter
import com.demo.nestedrecyclerview.models.App
import com.demo.nestedrecyclerview.models.Section

/**
 *  Create by ThanhPQ
 */
class MainActivity : AppCompatActivity() {
    var allSampleData: ArrayList<Section> = ArrayList()
    lateinit var sectionRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        showData()
    }

    private fun showData() {
        val sectionAdapter = SectionAdapter(this, allSampleData)
        sectionRecyclerView = findViewById(R.id.my_recycler_view)

        sectionRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = sectionAdapter
        }
    }

    private fun initData() {
        for (i in 1..5) {
            val sectionName = "Section $i"
            val singleItem: ArrayList<App> = ArrayList()
            for (j in 0..5) {
                singleItem.add(App("Item $j", "URL $j"))
            }
            allSampleData.add(Section(sectionName, singleItem))
        }
    }
}
