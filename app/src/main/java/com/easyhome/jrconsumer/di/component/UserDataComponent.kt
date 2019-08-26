package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.UserDataModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.UserDataActivity

@ActivityScope
@Component(modules = arrayOf(UserDataModule::class), dependencies = arrayOf(AppComponent::class))
interface UserDataComponent {
    fun inject(activity: UserDataActivity)
}
