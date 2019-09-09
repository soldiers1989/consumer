package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.MaterialsListModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.project.MaterialsListActivity

@ActivityScope
@Component(modules = arrayOf(MaterialsListModule::class), dependencies = arrayOf(AppComponent::class))
interface MaterialsListComponent {
    fun inject(activity: MaterialsListActivity)
}
