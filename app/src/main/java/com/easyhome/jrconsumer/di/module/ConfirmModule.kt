package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.ConfirmContract
import com.easyhome.jrconsumer.mvp.model.ConfirmModel


@Module
//构建ConfirmModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ConfirmModule(private val view: ConfirmContract.View) {
    @ActivityScope
    @Provides
    fun provideConfirmView(): ConfirmContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideConfirmModel(model: ConfirmModel): ConfirmContract.Model {
        return model
    }
}
