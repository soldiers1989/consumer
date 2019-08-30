package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.CalendarModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.CalendarActivity

@ActivityScope
@Component(modules = arrayOf(CalendarModule::class), dependencies = arrayOf(AppComponent::class))
interface CalendarComponent {
    fun inject(activity: CalendarActivity)
}
