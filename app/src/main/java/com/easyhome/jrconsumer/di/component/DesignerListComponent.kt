package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.DesignerListModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.recommend.DesignerListActivity

@ActivityScope
@Component(modules = arrayOf(DesignerListModule::class), dependencies = arrayOf(AppComponent::class))
interface DesignerListComponent {
    fun inject(activity: DesignerListActivity)
}
