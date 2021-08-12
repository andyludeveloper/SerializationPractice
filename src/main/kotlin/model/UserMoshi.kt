package model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserMoshi(
    val name: String,
    val age: Int,
    val gender: String = "NA"
)