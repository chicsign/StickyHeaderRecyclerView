package com.byeol.lonnie.stickyheaderrecyclerviewkotlinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private val peopleInfoList = listOf(
        Data("apple", 17),
        Data("banana", 31),
        Data("car", 26),
        Data("dog", 26),
        Data("egg", 24),
        Data("fish", 33),
        Data("great", 40),
        Data("happy", 10),
        Data("ice", 20),
        Data("juice", 32),
        Data("key", 50),
        Data("lonnie", 30),
        Data("mom", 58),
        Data("notice", 11),
        Data("object", 36),
        Data("people", 38),
        Data("queen", 15),
        Data("right", 22),
        Data("sight", 27),
        Data("tiger", 13),
        Data("uv", 29),
        Data("virus", 44),
        Data("wow", 36),
        Data("xylitol", 24),
        Data("yes", 26),
        Data("zoo", 36)
    )

    private fun setupAdapter() {
        adapter = MainAdapter(peopleInfoList)
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        val sectionItemDecoration = RecyclerSectionItemDecoration(getSectionCallback())
        recycler.addItemDecoration(sectionItemDecoration)
    }

    private fun getSectionCallback(): RecyclerSectionItemDecoration.SectionCallback {
        return object : RecyclerSectionItemDecoration.SectionCallback {
            override fun isSection(position: Int): Boolean {
                return adapter.isHolder(position)
            }

            override fun getHeaderLayoutView(list: RecyclerView, position: Int): View? {
                return adapter.getHeaderLayoutView(list, position)
            }
        }
    }
}
