package com.example.MyWechat.model

/**
 * 聊天消息数据类
 * 表示一条聊天消息，包含发送状态用于任务检查
 */
data class Message(
    val messageId: String,              // 消息唯一标识
    val senderId: String,               // 发送者用户ID
    val receiverId: String,             // 接收者用户ID
    val content: String,                // 消息内容
    val timestamp: Long,                // 发送时间戳（毫秒）
    val isSent: Boolean = false,        // 是否发送成功（用于任务检查）
    val messageType: MessageType = MessageType.TEXT  // 消息类型
)

/**
 * 消息类型枚举
 */
enum class MessageType {
    TEXT,       // 文本消息
    IMAGE,      // 图片消息
    VOICE,      // 语音消息
    VIDEO       // 视频消息
}
