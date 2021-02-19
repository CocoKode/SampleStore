package com.lvdy.samplestore.samples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import dagger.Provides
import dagger.multibindings.IntoSet

class FragSampleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(requireContext())
        textView.text = "Fragment探究"
        return textView
    }

    @dagger.Module
    abstract class Module {

        companion object {
            @Provides
            @IntoSet
            fun provideSample(): SampleBean {
                return object : SampleBean("Fragment探究") {
                    override fun createFragment(): Fragment {
                        return FragSampleFragment()
                    }
                }
            }
        }
    }
}