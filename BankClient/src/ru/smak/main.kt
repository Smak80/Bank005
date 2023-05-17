package ru.smak

import ru.smak.net.Client
import ru.smak.ui.RegWindow

fun main() {
    val client = Client().apply { start() }
    RegWindow(client).isVisible = true
}
