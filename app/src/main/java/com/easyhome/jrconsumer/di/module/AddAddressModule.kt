package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.AddAddressContract
import com.easyhome.jrconsumer.mvp.model.user.AddAddressModel


@Module
//构建AddAddressModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class AddAddressModule(private val view: AddAddressContract.View) {
    @ActivityScope
    @Provides
    fun provideAddAddressView(): AddAddressContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideAddAddressModel(model: AddAddressModel): AddAddressContract.Model {
        return model
    }
}
