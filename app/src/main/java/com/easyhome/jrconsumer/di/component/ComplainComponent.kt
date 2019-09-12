package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ComplainModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.ComplainActivity

@ActivityScope
@Component(modules = arrayOf(ComplainModule::class), dependencies = arrayOf(AppComponent::class))
interface ComplainComponent {
    fun inject(activity: ComplainActivity)
}
