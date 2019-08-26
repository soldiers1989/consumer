package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.DeliveryAddressModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.DeliveryAddressActivity

@ActivityScope
@Component(modules = arrayOf(DeliveryAddressModule::class), dependencies = arrayOf(AppComponent::class))
interface DeliveryAddressComponent {
    fun inject(activity: DeliveryAddressActivity)
}
