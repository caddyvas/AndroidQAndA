package com.learn.androidqanda.ui.android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.learn.androidqanda.R

class AndroidListAdapter(private val context: Context, private val questionList:ArrayList<String>) : BaseAdapter()  {
    private val inflater: LayoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return questionList.size
    }

    override fun getItem(position: Int): Any {
       return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View
        if (convertView == null) {
            rowView = LayoutInflater.from(context)
                .inflate(R.layout.adapter_android_listview, parent, false)
            val questionText = rowView.findViewById(R.id.adapterAndroidTextView) as TextView
            questionText.text = questionList[position]
        } else {
            rowView = convertView
        }
        return rowView
    }
}