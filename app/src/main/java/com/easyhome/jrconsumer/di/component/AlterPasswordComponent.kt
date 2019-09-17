package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.AlterPasswordModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.AlterPasswordActivity

@ActivityScope
@Component(modules = arrayOf(AlterPasswordModule::class), dependencies = arrayOf(AppComponent::class))
interface AlterPasswordComponent {
    fun inject(activity: AlterPasswordActivity)
}
