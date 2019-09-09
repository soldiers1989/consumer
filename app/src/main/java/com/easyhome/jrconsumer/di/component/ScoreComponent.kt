package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ScoreModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.ScoreActivity

@ActivityScope
@Component(modules = arrayOf(ScoreModule::class), dependencies = arrayOf(AppComponent::class))
interface ScoreComponent {
    fun inject(activity: ScoreActivity)
}
