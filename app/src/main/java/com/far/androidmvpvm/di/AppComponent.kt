package com.far.androidmvpvm.di

import com.far.androidmvpvm.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        BuildersModule::class
))
interface AppComponent {
    fun inject(app: App)
}