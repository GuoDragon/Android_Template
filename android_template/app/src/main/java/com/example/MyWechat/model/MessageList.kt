package com.example.MyWechat.model

/**
 * 聊天记录列表数据类
 * 表示与某个联系人的完整聊天记录，用于任务检查
 */
data class MessageList(
    val contactId: String,                    // 联系人用户ID
    val messages: MutableList<Message> = mutableListOf(),  // 消息列表
    val lastUpdateTime: Long = 0L             // 最后更新时间戳
) {
    /**
     * 添加新消息到列表
     */
    fun addMessage(message: Message) {
        messages.add(message)
    }

    /**
     * 获取所有已发送成功的消息
     * 用于检查消息发送任务完成情况
     */
    fun getSentMessages(): List<Message> {
        return messages.filter { it.isSent }
    }

    /**
     * 获取未发送成功的消息
     */
    fun getUnsentMessages(): List<Message> {
        return messages.filter { !it.isSent }
    }

    /**
     * 检查是否有新消息发送成功
     */
    fun hasNewSentMessage(afterTimestamp: Long): Boolean {
        return messages.any { it.isSent && it.timestamp > afterTimestamp }
    }
}
