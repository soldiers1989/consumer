package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.GradeModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.GradeActivity

@ActivityScope
@Component(modules = arrayOf(GradeModule::class), dependencies = arrayOf(AppComponent::class))
interface GradeComponent {
    fun inject(activity: GradeActivity)
}
