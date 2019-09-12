package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.MessageInfoModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.MessageInfoActivity

@ActivityScope
@Component(modules = arrayOf(MessageInfoModule::class), dependencies = arrayOf(AppComponent::class))
interface MessageInfoComponent {
    fun inject(activity: MessageInfoActivity)
}
