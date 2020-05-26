package com.byeol.lonnie.stickyheaderrecyclerviewkotlinsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter(private var item: List<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val recyclerItemList: ArrayList<AdapterItem> = ArrayList()

    init {
        setListData()
    }

    companion object {
        const val TYPE_TOP = 0
        const val TYPE_HOLDER = 1
        const val TYPE_EMPTY = 2
        const val TYPE_LIST = 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_TOP
            1 -> TYPE_HOLDER
            2 -> TYPE_EMPTY
            else -> TYPE_LIST
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view: View
        return when (recyclerItemList[position].type) {
            TYPE_TOP -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.top_item, parent, false)
                TopViewHolder(view)
            }
            TYPE_HOLDER -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.hold_item, parent, false)
                HolderViewHolder(view)
            }
            TYPE_EMPTY -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.empty_item, parent, false)
                EmptyViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
                ItemViewHolder(view)
            }
        }

    }

    fun isHolder(position: Int): Boolean {
        return recyclerItemList[position].type == TYPE_HOLDER
    }

    fun getHeaderLayoutView(list: RecyclerView, position: Int): View? {
        val lastIndex =
            if (position < recyclerItemList.size) position else recyclerItemList.size - 1
        for (index in lastIndex downTo 0) {
            val model = recyclerItemList[index]
            if (model.type == TYPE_HOLDER) {
                return LayoutInflater.from(list.context)
                    .inflate(R.layout.hold_item, list, false);
            }
        }
        return null
    }


    private fun setListData() {
        recyclerItemList.clear()
        recyclerItemList.add(AdapterItem(TYPE_TOP, Data("", -1)))
        recyclerItemList.add(AdapterItem(TYPE_HOLDER, Data("", -1)))
        if (item.isEmpty()) {
            recyclerItemList.add(AdapterItem(TYPE_EMPTY, Data("", -1)))
        } else {
            for (data in item) {
                recyclerItemList.add(AdapterItem(TYPE_LIST, data))
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = recyclerItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TopViewHolder -> {
                holder.bindView()
            }
            is HolderViewHolder -> {
                holder.bindView()
            }
            is EmptyViewHolder -> {
                holder.bindView()
            }
            is ItemViewHolder -> {
                val item: Data = recyclerItemList[position].objects
                holder.bindView(item)
            }
        }
    }

    inner class TopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {
        }
    }

    inner class HolderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {
        }
    }

    inner class EmptyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView() {
        }
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Data) {
            itemView.tv_name.text = item.name
            itemView.tv_age.text = item.age.toString()
        }
    }
}