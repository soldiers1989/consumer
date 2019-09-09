package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.MessageCenterModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.message.MessageCenterActivity

@ActivityScope
@Component(modules = arrayOf(MessageCenterModule::class), dependencies = arrayOf(AppComponent::class))
interface MessageCenterComponent {
    fun inject(activity: MessageCenterActivity)
}
