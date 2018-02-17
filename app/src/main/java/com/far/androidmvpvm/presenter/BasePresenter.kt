package com.far.androidmvpvm.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

/**
 * Created by Far on 9/2/2018 AD.
 */
abstract class BasePresenter<V>(val mView: V) : LifecycleObserver {

    enum class RequestState {
        IDLE,
        LOADING,
        COMPLETE,
        ERROR
    }

    private val disposables = CompositeDisposable()

    init {
        initLifecycle()
    }

    private fun initLifecycle() {
        if (mView is LifecycleOwner) {
            mView.lifecycle.addObserver(this)
        }
    }

    /**
     * Contains common setup actions needed for all presenters, if any.
     * Subclasses may override this.
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Timber.i("start")
    }

    /**
     * Contains common cleanup actions needed for all presenters, if any.
     * Subclasses may override this.
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        Timber.i("stop")
        disposables.clear()
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

}