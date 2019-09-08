package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.PredetermineContract
import com.easyhome.jrconsumer.mvp.model.PredetermineModel


@Module
//构建PredetermineModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class PredetermineModule(private val view: PredetermineContract.View) {
    @ActivityScope
    @Provides
    fun providePredetermineView(): PredetermineContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun providePredetermineModel(model: PredetermineModel): PredetermineContract.Model {
        return model
    }
}
