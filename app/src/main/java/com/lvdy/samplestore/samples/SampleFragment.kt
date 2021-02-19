package com.lvdy.samplestore.samples

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lvdy.samplestore.R
import com.lvdy.samplestore.startFragment
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SampleFragment : DaggerFragment() {

    /**
     *  注意
     *  kotlin会默认将泛型中的类型设置上界，需要添加jvmsuppresswildcards，否则找不到
     *  https://github.com/google/dagger/issues/668#issuecomment-289713497
     */
    @Inject lateinit var mSampleSet: Set<@JvmSuppressWildcards SampleBean>;

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        val view = layoutInflater.inflate(
                R.layout.fragment_sample,
                container,
                false)
        val sampleRecyclerView = view.findViewById<RecyclerView>(R.id.rv_sample)
        sampleRecyclerView.adapter = SampleAdapter(mSampleSet.toList())
        sampleRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        sampleRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
        sampleRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))

        return view
    }

    inner class SampleAdapter(list: List<SampleBean>) : RecyclerView.Adapter<SampleViewHolder>() {

        private val sampleList: List<SampleBean> = list

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
            return SampleViewHolder(requireContext(), parent)
        }

        override fun getItemCount(): Int {
            return sampleList.size
        }

        override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
            holder.bind(requireContext(), sampleList[position])
        }
    }

    inner class SampleViewHolder(context: Context, parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sample, parent, false)) {
        fun bind(context: Context, sampleBean: SampleBean) {
            description.text = sampleBean.description
            itemView.setOnClickListener(View.OnClickListener {
                requireActivity().startFragment(
                        R.id.main_frag_container,
                        sampleBean.createFragment())
            })
        }

        var description: TextView = itemView.findViewById(R.id.tv_description)

    }

}