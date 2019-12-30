package com.rmuhamed.params.app.client.fragment

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.rmuhamed.params.app.client.R
import com.rmuhamed.params.providerlibrary.Param

class ParamListAdapter(val params: List<Param>?) : RecyclerView.Adapter<ParamListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(param: Param) {
            (itemView as AppCompatTextView).text = String.format("%s %s", param.name, param.format)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(View.inflate(parent.context, R.layout.param_list_item, null))

    override fun getItemCount(): Int = params?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        params?.let {
            holder.bind(params[position])
        }
    }
}