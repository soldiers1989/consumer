package com.easyhome.jrconsumer.mvp.model.javabean

import com.google.gson.annotations.SerializedName

data class ClassicCase(
    val condition: List<Condition>,
    val sort: Sort,
    val page: Page,
    val data: List<Data>,
    val multiple: List<Multiple>,
    val defaults: Defaults
) {


    data class Condition(
        val fieldName: String, // city_8235
        val values: String, // 138
        val queryMode: String // 1
    )


    data class Page(
        val allPage: Any, // null
        val count: Any, // null
        val pageCount: Any, // null
        val nowPage: Any // null
    )

    data class Multiple(
        val houseType: List<Any>,
        val style: List<Any>
    )

    data class Defaults(
        @SerializedName("browse_volume_8235")
        val browseVolume8235: String, // 0
        @SerializedName("isDel_8235")
        val isDel8235: String, // 0
        @SerializedName("status_8235")
        val status8235: String, // 0
        @SerializedName("praises_count_8235")
        val praisesCount8235: String // 0
    )

    data class Data(
        @SerializedName("erpID_8235")
        val erpID8235: String, // 1
        @SerializedName("staffID_8235")
        val staffID8235: Int, // 2
        @SerializedName("caseTit_8235")
        val caseTit8235: String, // 测试案例
        @SerializedName("province_8235")
        val province8235: Int, // 10
        @SerializedName("city_8235")
        val city8235: Int, // 138
        @SerializedName("counties_8235")
        val counties8235: Int, // 0
        @SerializedName("cover_8235")
        val cover8235: String, // https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1569 240820767&di=348aec679c88845b8e4707104840ab9c&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2F item%2F32fa828ba61ea8d3fcd2e9ce9e0a304e241f5803.jpg
        @SerializedName("lever_8235")
        val lever8235: Int, // 1
        @SerializedName("style_8235")
        val style8235: String, // 2
        @SerializedName("houseType_8235")
        val houseType8235: Int, // 1
        @SerializedName("acreage_8235")
        val acreage8235: Int, // 120
        @SerializedName("weight_8235")
        val weight8235: Int, // 1
        @SerializedName("status_8235")
        val status8235: Int, // 0
        @SerializedName("browse_volume_8235")
        val browseVolume8235: Int, // 0
        @SerializedName("praises_count_8235")
        val praisesCount8235: Int, // 0
        @SerializedName("id_8235")
        val id8235: Int, // 1
        @SerializedName("isDel_8235")
        val isDel8235: Int, // 0
        @SerializedName("logTime_8235")
        val logTime8235: String, // 2019-09-23 17:26:12
        @SerializedName("name_4466")
        val name4466: String, // null
        @SerializedName("icon_4466")
        val icon4466: String // null
    )

    data class Sort(
        val fieldName: Any, // null
        val sortord: Any // null
    )
}