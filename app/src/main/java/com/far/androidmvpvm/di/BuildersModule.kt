package com.far.androidmvpvm.di


import com.far.androidmvpvm.view.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

}