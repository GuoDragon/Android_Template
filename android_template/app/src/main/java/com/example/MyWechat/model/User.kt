package com.example.MyWechat.model

/**
 * 用户/联系人数据类
 * 表示微信中的一个联系人或用户
 */
data class User(
    val userId: String,           // 用户唯一标识
    val username: String,         // 用户名
    val avatar: String = "",      // 头像URL或路径
    val nickname: String = "",    // 昵称
    val signature: String = ""    // 个性签名
)
