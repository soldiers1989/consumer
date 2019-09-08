package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.RepairDetailsModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.RepairDetailsActivity

@ActivityScope
@Component(modules = arrayOf(RepairDetailsModule::class), dependencies = arrayOf(AppComponent::class))
interface RepairDetailsComponent {
    fun inject(activity: RepairDetailsActivity)
}
