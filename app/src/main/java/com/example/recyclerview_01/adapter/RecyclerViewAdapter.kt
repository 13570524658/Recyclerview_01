package com.example.recyclerview_01.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_01.bean.Data
import com.example.recyclerview_01.R


class RecyclerViewAdapter(private val mDataList: ArrayList<Data>?) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    //一个小知识点,当列表为空时赋值0
    private var mSize = mDataList?.size ?: 0

    //默认空布局
    private val TYPE_EMPTY: Int = 0

    //加载数据布局
    private val TYPE_ITEM: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        if (viewType == TYPE_ITEM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.rv_adapter_item, parent, false)
            return MyViewHolder(view)

        }
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_adapter_null_item, parent, false)
        return MyViewHolder.onCreateViewHolder(view as ViewGroup, viewType)
    }

    override fun getItemCount(): Int {
        // getItemCount()=0时 不执行onCreateViewHolder size加1
        if (mSize == 0) {
            mSize = 1
        }
        return mSize
    }

    override fun getItemViewType(position: Int): Int {
        if (mDataList?.size == 0) {
            // getItemCount()=0时 不执行onCreateViewHolder size恢复0
            mSize = 0
            return TYPE_EMPTY
        }
        return TYPE_ITEM
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (holder.itemViewType == TYPE_ITEM) {
            holder.itemView.findViewById<TextView>(R.id.tv_code).text =
                mDataList?.get(position)?.code.toString()
            holder.itemView.findViewById<TextView>(R.id.tv_message).text =
                mDataList?.get(position)?.message
            holder.itemView.findViewById<TextView>(R.id.tv_data).text =
                mDataList?.get(position)?.data.toString()
        }
    }

    class MyViewHolder(itemViews: View) : RecyclerView.ViewHolder(itemViews) {
        companion object {
            fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                return MyViewHolder(parent)
            }
        }
    }
}