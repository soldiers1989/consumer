package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.AlterPhoneNumberModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.AlterPhoneNumberActivity

@ActivityScope
@Component(modules = arrayOf(AlterPhoneNumberModule::class), dependencies = arrayOf(AppComponent::class))
interface AlterPhoneNumberComponent {
    fun inject(activity: AlterPhoneNumberActivity)
}
