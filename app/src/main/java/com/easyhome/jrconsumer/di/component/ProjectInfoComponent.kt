package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ProjectInfoModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.ProjectInfoActivity

@ActivityScope
@Component(modules = arrayOf(ProjectInfoModule::class), dependencies = arrayOf(AppComponent::class))
interface ProjectInfoComponent {
    fun inject(activity: ProjectInfoActivity)
}
