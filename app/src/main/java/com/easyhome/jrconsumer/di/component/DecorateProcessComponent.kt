package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.DecorateProcessModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.project.DecorateProcessActivity

@ActivityScope
@Component(modules = arrayOf(DecorateProcessModule::class), dependencies = arrayOf(AppComponent::class))
interface DecorateProcessComponent {
    fun inject(activity: DecorateProcessActivity)
}
