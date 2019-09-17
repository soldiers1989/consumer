package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ProjectDynamicModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.project.ProjectDynamicActivity

@ActivityScope
@Component(modules = arrayOf(ProjectDynamicModule::class), dependencies = arrayOf(AppComponent::class))
interface ProjectDynamicComponent {
    fun inject(activity: ProjectDynamicActivity)
}
