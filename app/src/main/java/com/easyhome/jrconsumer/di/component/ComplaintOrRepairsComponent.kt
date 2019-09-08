package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ComplaintOrRepairsModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.ComplaintOrRepairsActivity

@ActivityScope
@Component(modules = arrayOf(ComplaintOrRepairsModule::class), dependencies = arrayOf(AppComponent::class))
interface ComplaintOrRepairsComponent {
    fun inject(activity: ComplaintOrRepairsActivity)
}
