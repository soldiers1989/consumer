package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.AddBuyCommodityModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.project.AddBuyCommodityActivity

@ActivityScope
@Component(modules = arrayOf(AddBuyCommodityModule::class), dependencies = arrayOf(AppComponent::class))
interface AddBuyCommodityComponent {
    fun inject(activity: AddBuyCommodityActivity)
}
