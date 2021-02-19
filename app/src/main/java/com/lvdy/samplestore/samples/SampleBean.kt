package com.lvdy.samplestore.samples

import androidx.fragment.app.Fragment

abstract class SampleBean(val description: String) {
    abstract fun createFragment(): Fragment
}