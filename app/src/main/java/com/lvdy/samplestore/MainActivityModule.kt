package com.lvdy.samplestore

import com.lvdy.samplestore.samples.SampleFragment
import com.lvdy.samplestore.samples.SampleModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [SampleModule::class])
    abstract fun provideMainActivity() : MainActivity
}