package com.lvdy.samplestore

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit

fun FragmentActivity.startFragment(containerId: Int, targetClazz: Class<out Fragment>) {
    supportFragmentManager.commit {
        replace(containerId, targetClazz, null)
        addToBackStack(null)
    }
}

fun FragmentActivity.startFragment(containerId: Int, fragment: Fragment) {
    supportFragmentManager.commit {
        replace(containerId, fragment)
        addToBackStack(null)
    }
}