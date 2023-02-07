package com.inhohyun.listview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List:MutableList<ListViewModel>): BaseAdapter() {

    //ListView에 담을 데이터의 개수(item의 개수)
    override fun getCount(): Int {

        return List.size
    }
    //특별히 신경쓸 필요는 없음(어떤 데이터인지)
    override fun getItem(position: Int): Any {
        return List[position]
    }

    //크게 신경쓸 필요는 없음(데이터의 위치)
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }


    //item과 어댑터를 연결
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var converView = convertView

        if (converView == null){
            converView == LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)
        }

        val title = converView!!.findViewById<TextView>(R.id.listviewItem)
        val content = converView!!.findViewById<TextView>(R.id.listviewItem2)

        title.text = List[position].title // listViewModel에 title을 가져옮
        content.text = List[position].content
        //List[0] -> ListViewModel("a","b")
        //List[1] -> ListViewModel("c","d")
        //List[2] -> ListViewModel("e","f")


        return convertView!!
    }


}