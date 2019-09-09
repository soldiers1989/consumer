package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.message.MessageCenterContract
import com.easyhome.jrconsumer.mvp.model.message.MessageCenterModel


@Module
//构建MessageCenterModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MessageCenterModule(private val view: MessageCenterContract.View) {
    @ActivityScope
    @Provides
    fun provideMessageCenterView(): MessageCenterContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideMessageCenterModel(model: MessageCenterModel): MessageCenterContract.Model {
        return model
    }
}
