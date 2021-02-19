package com.lvdy.samplestore.samples

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    FragSampleFragment.Module::class,
    SecondFragment.Module::class])
abstract class SampleModule {

    @ContributesAndroidInjector
    abstract fun provideSampleFragment(): SampleFragment
}