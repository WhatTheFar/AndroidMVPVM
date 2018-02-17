package com.far.androidmvpvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log
import timber.log.Timber

/**
 * Created by Far on 9/2/2018 AD.
 */
class MainViewModel : ViewModel() {

    var count = 0
    val text: ObservableField<String> = ObservableField("start" + count)
    val liveData: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        Timber.i("onCleared")
    }

}