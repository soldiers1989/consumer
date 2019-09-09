package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.CoupleBackContract
import com.easyhome.jrconsumer.mvp.model.user.CoupleBackModel


@Module
//构建CoupleBackModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class CoupleBackModule(private val view: CoupleBackContract.View) {
    @ActivityScope
    @Provides
    fun provideCoupleBackView(): CoupleBackContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideCoupleBackModel(model: CoupleBackModel): CoupleBackContract.Model {
        return model
    }
}
