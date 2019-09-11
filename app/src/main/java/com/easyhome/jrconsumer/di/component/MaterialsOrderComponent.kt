package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.MaterialsOrderModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.project.MaterialsOrderActivity

@ActivityScope
@Component(modules = arrayOf(MaterialsOrderModule::class), dependencies = arrayOf(AppComponent::class))
interface MaterialsOrderComponent {
    fun inject(activity: MaterialsOrderActivity)
}
