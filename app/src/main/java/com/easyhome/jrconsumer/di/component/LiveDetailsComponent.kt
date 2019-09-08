package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.LiveDetailsModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.live.LiveDetailsActivity

@ActivityScope
@Component(modules = arrayOf(LiveDetailsModule::class), dependencies = arrayOf(AppComponent::class))
interface LiveDetailsComponent {
    fun inject(activity: LiveDetailsActivity)
}
