package com.example.MyWechat.model

/**
 * 朋友圈动态数据类
 * 表示一条朋友圈动态，包含点赞列表用于任务检查
 */
data class Moment(
    val momentId: String,                         // 动态唯一标识
    val userId: String,                           // 发布者用户ID
    val content: String,                          // 动态文字内容
    val images: List<String> = emptyList(),       // 图片URL列表
    val timestamp: Long,                          // 发布时间戳（毫秒）
    val likeList: MutableList<String> = mutableListOf(),  // 点赞用户ID列表（用于任务检查）
    val comments: MutableList<Comment> = mutableListOf()  // 评论列表
) {
    /**
     * 添加点赞
     * @param userId 点赞用户的ID
     * @return 是否添加成功（如果已点赞则返回false）
     */
    fun addLike(userId: String): Boolean {
        if (userId in likeList) {
            return false  // 已经点赞过
        }
        likeList.add(userId)
        return true
    }

    /**
     * 取消点赞
     * @param userId 取消点赞用户的ID
     * @return 是否取消成功
     */
    fun removeLike(userId: String): Boolean {
        return likeList.remove(userId)
    }

    /**
     * 检查某用户是否已点赞
     * 用于检查点赞任务完成情况
     */
    fun isLikedBy(userId: String): Boolean {
        return userId in likeList
    }

    /**
     * 获取点赞数量
     */
    fun getLikeCount(): Int {
        return likeList.size
    }

    /**
     * 添加评论
     */
    fun addComment(comment: Comment) {
        comments.add(comment)
    }
}

/**
 * 评论数据类
 */
data class Comment(
    val commentId: String,          // 评论唯一标识
    val userId: String,             // 评论者用户ID
    val content: String,            // 评论内容
    val timestamp: Long,            // 评论时间戳
    val replyToUserId: String? = null  // 回复的用户ID（如果是回复评论）
)
