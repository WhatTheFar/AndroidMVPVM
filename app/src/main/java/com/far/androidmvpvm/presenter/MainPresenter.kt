package com.far.androidmvpvm.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Handler
import com.far.androidmvpvm.view.ui.MainView
import com.far.androidmvpvm.viewmodel.MainViewModel
import timber.log.Timber

/**
 * Created by Far on 9/2/2018 AD.
 */
class MainPresenter(view: MainView) : BasePresenter<MainView>(view) {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Timber.i("onStart")
    }

    fun bindViewModel(mViewModel: MainViewModel) {
        if (mView is LifecycleOwner) {

            val handler2 = Handler()
            handler2.postDelayed({
                mViewModel.liveData.observe(mView, Observer<String> { newText ->
                    Timber.i("onChanged : $newText")
                    mViewModel.text.set(newText)
                })
            }, 5000)

        }

        val handler = Handler()
        handler.postDelayed({
            Timber.i("bindViewModel: postDelayed")
            mViewModel.count++
            mViewModel.liveData.value = "hello from handler" + mViewModel.count
        }, 2000)
    }
}