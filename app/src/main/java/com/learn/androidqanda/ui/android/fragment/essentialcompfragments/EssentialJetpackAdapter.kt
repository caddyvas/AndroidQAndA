package com.learn.androidqanda.ui.android.fragment.essentialcompfragments

import android.graphics.text.LineBreaker
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.learn.androidqanda.R

class EssentialJetpackAdapter : RecyclerView.Adapter<EssentialJetpackAdapter.TextViewHolder>() {

    private val items = mutableListOf<CharSequence>() // always use CharSequence because html tags are handled properly

    inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textItem: TextView = itemView.findViewById(R.id.essentialAdapterTextItem)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EssentialJetpackAdapter.TextViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.essentials_frag_item_layout, parent, false)
        return TextViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBindViewHolder(holder: EssentialJetpackAdapter.TextViewHolder, position: Int) {
        holder.textItem.text = items[position]
        holder.textItem.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD // justify text
    }

    override fun getItemCount(): Int = items.size

    fun addTextContent(newItems: List<CharSequence>) {
        items.clear()
        items.addAll(newItems)
    }
}