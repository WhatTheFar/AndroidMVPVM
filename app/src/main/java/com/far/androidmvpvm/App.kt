package com.far.androidmvpvm

import android.app.Activity
import android.app.Application
import com.far.androidmvpvm.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Far on 9/2/2018 AD.
 */
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        DaggerAppComponent
                .create()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>  = activityInjector

}