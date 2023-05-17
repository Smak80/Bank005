package ru.smak.data

import java.io.Serializable
import java.sql.Date

data class User(
    val phone: String,
    val lastName: String,
    val firstName: String,
    val middleName: String?,
    val birth: String,
    val login: String,
    val password: String,
) : Serializable{
    val birthDate: Date = Date.valueOf(birth)
}
