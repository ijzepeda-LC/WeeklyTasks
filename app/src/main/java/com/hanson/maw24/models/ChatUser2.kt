package com.hanson.maw24.models

import com.google.firebase.firestore.PropertyName



data class ChatUser2 (
    @PropertyName("name") val name: String = "",
    @PropertyName("age") val age: Int = 0,
    @PropertyName("message") val message: String= ""

)