package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.CooperativeBrandContract
import com.easyhome.jrconsumer.mvp.model.CooperativeBrandModel


@Module
//构建CooperativeBrandModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class CooperativeBrandModule(private val view: CooperativeBrandContract.View) {
    @ActivityScope
    @Provides
    fun provideCooperativeBrandView(): CooperativeBrandContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideCooperativeBrandModel(model: CooperativeBrandModel): CooperativeBrandContract.Model {
        return model
    }
}
