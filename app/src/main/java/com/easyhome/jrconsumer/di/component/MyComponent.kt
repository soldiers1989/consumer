package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.MyModule

import com.jess.arms.di.scope.FragmentScope
import com.easyhome.jrconsumer.mvp.ui.fragment.MyFragment

@FragmentScope
@Component(modules = arrayOf(MyModule::class), dependencies = arrayOf(AppComponent::class))
interface MyComponent {
    fun inject(fragment: MyFragment)
}
