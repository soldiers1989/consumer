package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.ShareContract
import com.easyhome.jrconsumer.mvp.model.user.ShareModel


@Module
//构建ShareModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ShareModule(private val view: ShareContract.View) {
    @ActivityScope
    @Provides
    fun provideShareView(): ShareContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideShareModel(model: ShareModel): ShareContract.Model {
        return model
    }
}
