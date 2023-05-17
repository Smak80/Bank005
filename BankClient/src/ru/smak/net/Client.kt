package ru.smak.net

import ru.smak.data.DataType
import ru.smak.data.User
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.Socket
import kotlin.concurrent.thread

class Client(
    host: String = "127.0.0.1",
    port: Int = 5005,
) {

    private val s: Socket = Socket(host, port)
    private val bankIO = BankIO(s)

    fun start(){
        thread {
            //bankIO.startReceiving(::parse)
        }
    }

    fun regUser(user: User){
        ByteArrayOutputStream().also {
            ObjectOutputStream(it).run{
                writeInt(DataType.USER_REG_DATA.ordinal)
                writeObject(user)
            }
            bankIO.sendData(it.toByteArray())
        }
    }

    private fun parse(data: ByteArray){

    }
}