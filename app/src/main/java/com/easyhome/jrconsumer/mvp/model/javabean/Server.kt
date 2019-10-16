package com.easyhome.jrconsumer.mvp.model.javabean

import com.google.gson.annotations.SerializedName

data class Server(
    val roleID: String, // 6
    val fwID: String, // 2
    val staRoleName: String, // 客户顾问
    val staUserName: String, // 李都
    val staMobile: String, // 13661246371
    val workTypeID: Any, // null
    val workName: WorkName
) {
    data class WorkName(
        @SerializedName("1")
        val w1: String, // 方华军,舒宏
        @SerializedName("2")
        val w2: String, // 常善勤
        @SerializedName("3")
        val w3: String, // 柯琼彦,平明奇,平璐
        @SerializedName("4")
        val w4: String, // 戚轮伯
        @SerializedName("5")
        val w5: String // 狄彪树
    )
}