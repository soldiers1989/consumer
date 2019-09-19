package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.H5Contract
import com.easyhome.jrconsumer.mvp.model.H5Model


@Module
//构建H5Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class H5Module(private val view: H5Contract.View) {
    @ActivityScope
    @Provides
    fun provideH5View(): H5Contract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideH5Model(model: H5Model): H5Contract.Model {
        return model
    }
}
