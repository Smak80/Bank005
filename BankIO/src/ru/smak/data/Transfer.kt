package ru.smak.data

import java.io.Serializable

data class Transfer(
    val accFrom:String,
    val accTo: String,
    val sum: Float,
    val fee: Float,
):Serializable {
}
