package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.fragment.MessageContract
import com.easyhome.jrconsumer.mvp.model.fragment.MessageModel


@Module
//构建MessageModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class MessageModule(private val view: MessageContract.View) {
    @FragmentScope
    @Provides
    fun provideMessageView(): MessageContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideMessageModel(model: MessageModel): MessageContract.Model {
        return model
    }
}
