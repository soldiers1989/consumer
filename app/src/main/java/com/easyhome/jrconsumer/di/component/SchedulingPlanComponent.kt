package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.SchedulingPlanModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.project.SchedulingPlanActivity

@ActivityScope
@Component(modules = arrayOf(SchedulingPlanModule::class), dependencies = arrayOf(AppComponent::class))
interface SchedulingPlanComponent {
    fun inject(activity: SchedulingPlanActivity)
}
