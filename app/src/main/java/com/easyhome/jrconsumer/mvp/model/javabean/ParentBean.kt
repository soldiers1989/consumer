package com.easyhome.jrconsumer.mvp.model.javabean

import com.google.gson.annotations.SerializedName

 data class ParentBean<T>(
    val traceId: String, // adf0394c76254945b17a82c81339f7bc
    val code: Int, // 0
    val msg: String/*,// 成功
    val data: List<T>*/
)