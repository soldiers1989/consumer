package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.AddAddressModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.user.AddAddressActivity

@ActivityScope
@Component(modules = arrayOf(AddAddressModule::class), dependencies = arrayOf(AppComponent::class))
interface AddAddressComponent {
    fun inject(activity: AddAddressActivity)
}
