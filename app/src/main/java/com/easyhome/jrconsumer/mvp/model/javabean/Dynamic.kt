package com.easyhome.jrconsumer.mvp.model.javabean

import com.google.gson.annotations.SerializedName

data class Dynamic(
    val sort: Sort,
    val page: Page,
    val data: List<Data>
) {



    data class Sort(
        val fieldName: Any, // null
        val sortord: Any // null
    )

    data class Data(
        @SerializedName("id_6863")
        val id6863: Int, // 1
        @SerializedName("proID_6863")
        val proID6863: String, // 123456789
        @SerializedName("staffID_6863")
        val staffID6863: Int, // 1
        @SerializedName("planID_6863")
        val planID6863: Int, // 1
        @SerializedName("planName_6863")
        val planName6863: String, // 量房
        @SerializedName("startTime_6863")
        val startTime6863: String, // 2019-09-26 11:04:01
        @SerializedName("endTime_6863")
        val endTime6863: String, // 2019-10-20 11:03:22
        @SerializedName("manHour_6863")
        val manHour6863: Double, // 240.0
        @SerializedName("delayed_6863")
        val delayed6863: Int, // 0
        @SerializedName("delayedBegin_6863")
        val delayedBegin6863: String, // 2019-09-26 11:04:01
        @SerializedName("delayedEnd_6863")
        val delayedEnd6863: String, // 2019-09-26 11:04:01
        @SerializedName("delayedNum_6863")
        val delayedNum6863: Any, // null
        @SerializedName("preID_6863")
        val preID6863: Any, // null
        @SerializedName("acceptance_6863")
        val acceptance6863: Int, // 0
        @SerializedName("isAcc_6863")
        val isAcc6863: Int, // 0
        @SerializedName("accStaffID_6863")
        val accStaffID6863: Any, // null
        @SerializedName("status_6863")
        val status6863: Int, // 0
        @SerializedName("isDel_6863")
        val isDel6863: Int, // 0
        @SerializedName("logTime_6863")
        val logTime6863: String // 2019-09-26 11:04:01
    )

    data class Page(
        val allPage: Any, // null
        val count: Int, // 1
        val pageCount: Int, // 10
        val nowPage: Int // 1
    )




}