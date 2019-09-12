package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.MessageInfoContract
import com.easyhome.jrconsumer.mvp.model.MessageInfoModel


@Module
//构建MessageInfoModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MessageInfoModule(private val view: MessageInfoContract.View) {
    @ActivityScope
    @Provides
    fun provideMessageInfoView(): MessageInfoContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMessageInfoModel(model: MessageInfoModel): MessageInfoContract.Model {
        return model
    }
}
