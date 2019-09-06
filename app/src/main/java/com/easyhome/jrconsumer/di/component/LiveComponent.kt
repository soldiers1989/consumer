package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.LiveModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.live.LiveActivity

@ActivityScope
@Component(modules = arrayOf(LiveModule::class), dependencies = arrayOf(AppComponent::class))
interface LiveComponent {
    fun inject(activity: LiveActivity)
}
