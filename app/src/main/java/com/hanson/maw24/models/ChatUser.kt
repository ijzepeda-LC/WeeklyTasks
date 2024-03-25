package com.hanson.maw24.models

import com.google.firebase.firestore.PropertyName

// The following line is enough for local app, but firebase require empty constructor
// data class ChatUser(val name: String, val age: Int)


data class ChatUser(
    @PropertyName("name") val name: String? = "",
    @PropertyName("age") val age: Int = 0,
    @PropertyName("message") val message: String =""
)