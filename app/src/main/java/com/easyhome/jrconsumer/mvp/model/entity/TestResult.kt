package com.easyhome.jrconsumer.mvp.model.entity

import com.google.gson.annotations.SerializedName

data class TestResult(
    val codes: String, // S85237-I02599-C03310-B19613
    val isVerify: String, // 0
    val datas: List<Data>
) {
    data class Data(
        val condition: List<Condition>
    ) {
        data class Condition(
            val fieldName: String,
            val values: String,
            val queryMode: String

        )
    }
}