package ru.smak.net

import java.net.Socket

class BankIO(private val socket: Socket) {
    private var isActive = true
    fun startReceiving(parse: (ByteArray)->Unit){
        isActive = true
        while (isActive){
            socket.getInputStream().apply {
                val ba = ByteArray(10240)
                read(ba)
                parse(ba)
            }
        }
    }

    fun sendData(data: ByteArray){
        socket.getOutputStream().apply {
            write(data)
            flush()
        }
    }

    fun stop(){
        isActive = false
    }
}