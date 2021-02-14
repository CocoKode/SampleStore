package com.lvdy.samplestore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SampleFragment : Fragment() {

    val mItemArray = arrayOf(
            SampleItem("Fragment探究", FragActivity::class.java)
    )

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        val view = layoutInflater.inflate(
                R.layout.fragment_sample,
                container,
                false)
        val sampleRecyclerView = view.findViewById<RecyclerView>(R.id.rv_sample)
        sampleRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        sampleRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
        sampleRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
//        sampleRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        sampleRecyclerView.adapter = SampleAdapter()

        return view
    }

    inner class SampleAdapter : RecyclerView.Adapter<SampleViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
            return SampleViewHolder(requireContext(), parent)
        }

        override fun getItemCount(): Int {
            return mItemArray.size
        }

        override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
            holder.bind(requireContext(), position)
        }


    }

    inner class SampleViewHolder : RecyclerView.ViewHolder {
        fun bind(context: Context, position: Int) {
            description.text = mItemArray[position].description
            itemView.setOnClickListener(View.OnClickListener {
                context.startActivity(Intent(context, mItemArray[adapterPosition].targetClazz))
            })
        }

        var description: TextView = itemView.findViewById(R.id.tv_description)

        constructor(context: Context, parent: ViewGroup)
                : super(LayoutInflater.from(context).inflate(R.layout.item_sample, parent, false))
    }


    class SampleItem(val description: String, val targetClazz: Class<FragActivity>) {}

}