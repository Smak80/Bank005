package ru.smak.net

import ru.smak.data.Answer
import ru.smak.data.DataType
import ru.smak.data.Transfer
import ru.smak.data.User
import java.io.*
import java.net.Socket
import kotlin.concurrent.thread

class Client(
    host: String = "127.0.0.1",
    port: Int = 5005,
) {

    private val messageRecievedListeners = mutableListOf<(String)->Unit>()
    fun addMessageReceivedListener(l: (String)->Unit){
        messageRecievedListeners.add(l)
    }
    fun removeMessageReceivedListener(l: (String)->Unit){
        messageRecievedListeners.remove(l)
    }

    private val s: Socket = Socket(host, port)
    private val bankIO = BankIO(s)

    fun start(){
        thread {
            bankIO.startReceiving(::parse)
        }
    }

    fun sendData(data: Serializable){
        ByteArrayOutputStream().also {
            ObjectOutputStream(it).run{
                writeInt(when (data){
                    is User -> DataType.USER_REG_DATA
                    is Transfer -> DataType.TRANSFER
                    else -> DataType.UNKNOWN
                }.ordinal)
                writeObject(data)
            }
            bankIO.sendData(it.toByteArray())
        }
    }

    private fun parse(data: ByteArray){
        ObjectInputStream(ByteArrayInputStream(data)).apply {
            val answer = readObject() as Answer
            messageRecievedListeners.forEach { it(answer.message) }
        }
    }
}