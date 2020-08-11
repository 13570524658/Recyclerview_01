package com.example.recyclerview_01

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_01.adapter.RecyclerViewAdapter
import com.example.recyclerview_01.bean.Data
import kotlinx.android.synthetic.main.activity_main.*

/**
 * ?加在变量名后，系统在任何情况不会报它的空指针异常。
 */
class MainActivity : AppCompatActivity() {
    private var mDataList: ArrayList<Data>? = ArrayList()

    //一个小知识点,当列表为空时赋值0
    private var mSize = mDataList?.size ?: 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_use.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        btn_loading.setOnClickListener {
            for (i in 0..99) {
                val data =
                    Data(i, "message$i", "data$i")
                mDataList?.add(data)
            }
            rv_use.adapter = RecyclerViewAdapter(mDataList)
        }

        btn_null.setOnClickListener {
            mDataList?.clear()
            rv_use.adapter = RecyclerViewAdapter(mDataList)
        }
    }
}