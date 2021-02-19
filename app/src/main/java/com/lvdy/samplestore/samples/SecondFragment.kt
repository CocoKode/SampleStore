package com.lvdy.samplestore.samples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import dagger.Provides
import dagger.multibindings.IntoSet

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val textView = TextView(requireContext())
        textView.text = "我是第二个sample"
        return textView
    }

    @dagger.Module
    abstract class Module {

        companion object {
            @Provides
            @IntoSet
            fun provideSecondSample() : SampleBean {
                return object : SampleBean("我是第二个sample") {
                    override fun createFragment(): Fragment {
                        return SecondFragment()
                    }

                }
            }
        }
    }
}