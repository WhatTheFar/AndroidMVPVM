package com.far.androidmvpvm.view.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.far.androidmvpvm.R
import com.far.androidmvpvm.databinding.ActivityMainBinding
import com.far.androidmvpvm.presenter.MainPresenter
import com.far.androidmvpvm.view.BaseView
import com.far.androidmvpvm.viewmodel.MainViewModel
import com.far.androidmvpvm.viewmodel.MainViewModelFactory
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

interface MainView : BaseView<MainPresenter> {
    fun initInstance(savedInstanceState: Bundle?)
}

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    lateinit var mViewModel: MainViewModel
    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.i("onCreate")
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = mViewModel

        presenter.bindViewModel(mViewModel)
    }

    override fun initInstance(savedInstanceState: Bundle?) {

    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy")
    }
}
