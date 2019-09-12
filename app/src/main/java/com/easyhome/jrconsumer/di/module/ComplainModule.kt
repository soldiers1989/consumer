package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.ComplainContract
import com.easyhome.jrconsumer.mvp.model.ComplainModel


@Module
//构建ComplainModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ComplainModule(private val view: ComplainContract.View) {
    @ActivityScope
    @Provides
    fun provideComplainView(): ComplainContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideComplainModel(model: ComplainModel): ComplainContract.Model {
        return model
    }
}
