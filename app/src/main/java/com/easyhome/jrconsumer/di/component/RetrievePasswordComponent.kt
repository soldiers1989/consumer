package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.RetrievePasswordModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.RetrievePasswordActivity

@ActivityScope
@Component(modules = arrayOf(RetrievePasswordModule::class), dependencies = arrayOf(AppComponent::class))
interface RetrievePasswordComponent {
    fun inject(activity: RetrievePasswordActivity)
}
