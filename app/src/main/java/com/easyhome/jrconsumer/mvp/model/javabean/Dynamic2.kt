package com.easyhome.jrconsumer.mvp.model.javabean

data class Dynamic2(
    val dynamicId: Int, // 1
    val staffId: Int, // 1
    val staffName: String, // 运营1
    val roleName: String, // 运营
    val title: String, // 预约量房
    val content: String, // 1
    val praiseCount: Int, // 1
    val logTime: String, // 2019-09-25 07:34:20
    val isPraises: Int, // 0
    val photosList: Any, // null
    val praisesList: List<Praises>,
    val commentList: List<Comment>
) {
    data class Comment(
        val commentId: Int, // 2
        val dynamicId: Int, // 1
        val userId: Int, // 1
        val userName: String, // 运营1
        val content: String, // 这是第二条评论
        val replyList: List<Any>
    )

    data class Praises(
        val praisesId: Int, // 1
        val userId: Int, // 2
        val userName: String // 店长1
    )
}