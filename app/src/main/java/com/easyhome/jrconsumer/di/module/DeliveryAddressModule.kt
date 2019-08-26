package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.user.DeliveryAddressContract
import com.easyhome.jrconsumer.mvp.model.user.DeliveryAddressModel


@Module
//构建DeliveryAddressModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class DeliveryAddressModule(private val view: DeliveryAddressContract.View) {
    @ActivityScope
    @Provides
    fun provideDeliveryAddressView(): DeliveryAddressContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideDeliveryAddressModel(model: DeliveryAddressModel): DeliveryAddressContract.Model {
        return model
    }
}
