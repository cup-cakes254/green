package com.mwikali.greenhub.data

data class UserModel(
    val firstname: String = "",
    val lastname: String = "",
    val email: String = "",
    val password: String = "",
    val bio: String? = "",
    val imageUrl: String? = "",
    val userId: String
)
