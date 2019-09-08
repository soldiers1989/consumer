package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.live.LiveDetailsContract
import com.easyhome.jrconsumer.mvp.model.live.LiveDetailsModel


@Module
//构建LiveDetailsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class LiveDetailsModule(private val view: LiveDetailsContract.View) {
    @ActivityScope
    @Provides
    fun provideLiveDetailsView(): LiveDetailsContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideLiveDetailsModel(model: LiveDetailsModel): LiveDetailsContract.Model {
        return model
    }
}
