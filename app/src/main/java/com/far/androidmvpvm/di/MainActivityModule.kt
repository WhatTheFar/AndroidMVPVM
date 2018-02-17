package com.far.androidmvpvm.di

import com.far.androidmvpvm.presenter.MainPresenter
import com.far.androidmvpvm.view.ui.MainActivity
import com.far.androidmvpvm.view.ui.MainView
import com.far.androidmvpvm.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    fun provideMainView(mainActivity: MainActivity): MainView = mainActivity

    @Provides
    fun providesMainPresenter(mainView: MainView): MainPresenter {
        return MainPresenter(mainView)
    }

    @Provides
    fun providesMainViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory()
    }
}