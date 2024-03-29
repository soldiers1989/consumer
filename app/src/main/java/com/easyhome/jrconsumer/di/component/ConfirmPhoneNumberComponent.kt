package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.ConfirmPhoneNumberModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.ConfirmPhoneNumberActivity

@ActivityScope
@Component(modules = arrayOf(ConfirmPhoneNumberModule::class), dependencies = arrayOf(AppComponent::class))
interface ConfirmPhoneNumberComponent {
    fun inject(activity: ConfirmPhoneNumberActivity)
}
