package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.PredetermineModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.PredetermineActivity

@ActivityScope
@Component(modules = arrayOf(PredetermineModule::class), dependencies = arrayOf(AppComponent::class))
interface PredetermineComponent {
    fun inject(activity: PredetermineActivity)
}
