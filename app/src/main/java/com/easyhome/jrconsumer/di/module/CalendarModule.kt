package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.CalendarContract
import com.easyhome.jrconsumer.mvp.model.CalendarModel


@Module
//构建CalendarModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class CalendarModule(private val view: CalendarContract.View) {
    @ActivityScope
    @Provides
    fun provideCalendarView(): CalendarContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideCalendarModel(model: CalendarModel): CalendarContract.Model {
        return model
    }
}
