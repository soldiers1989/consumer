package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.OuterMaterialsModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.OuterMaterialsActivity

@ActivityScope
@Component(modules = arrayOf(OuterMaterialsModule::class), dependencies = arrayOf(AppComponent::class))
interface OuterMaterialsComponent {
    fun inject(activity: OuterMaterialsActivity)
}
