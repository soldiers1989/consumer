package com.easyhome.jrconsumer.mvp.model.entity

data class LoginArgumentsBean(val codes:String, val isVerify:String,val datas:List<Bean>) {

    data class Bean(val data: List<Map<String, String>>)
}