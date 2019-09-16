package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.GradeListModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.GradeListActivity

@ActivityScope
@Component(modules = arrayOf(GradeListModule::class), dependencies = arrayOf(AppComponent::class))
interface GradeListComponent {
    fun inject(activity: GradeListActivity)
}
