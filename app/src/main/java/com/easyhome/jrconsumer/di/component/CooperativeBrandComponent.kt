package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.CooperativeBrandModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.CooperativeBrandActivity

@ActivityScope
@Component(modules = arrayOf(CooperativeBrandModule::class), dependencies = arrayOf(AppComponent::class))
interface CooperativeBrandComponent {
    fun inject(activity: CooperativeBrandActivity)
}
