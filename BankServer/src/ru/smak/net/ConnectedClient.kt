package ru.smak.net

import ru.smak.data.*
import java.io.*
import java.net.Socket
import kotlin.concurrent.thread

class ConnectedClient(val client: Socket) {
    private val bio = BankIO(client)
    private val dbh = DbHelper()
    companion object{
        private val clients = mutableListOf<ConnectedClient>()
    }
    init{
        clients.add(this)
    }

    private fun send(data: String) {
        val answer = Answer(data)
        ByteArrayOutputStream().also {
            ObjectOutputStream(it).run{
                writeObject(answer)
            }
            bio.sendData(it.toByteArray())
        }
    }

    private fun parse(data: ByteArray){
        ObjectInputStream(ByteArrayInputStream(data)).apply {
            when (readInt()){
                DataType.USER_REG_DATA.ordinal -> {
                    val u = readObject() as User
                    dbh.addUser(u)
                }
                DataType.TRANSFER.ordinal -> {
                    try {
                        val t = readObject() as Transfer
                        dbh.doTransfer(t)
                        send("Ok")
                    }
                    catch (ex: Exception) {
                        send(ex.message?:"Ошибка")
                    }
                }
            }
        }
    }
    fun start(){
        thread {
            try {
                bio.startReceiving {
                    try {
                        parse(it)
                    } catch (e: Exception) {
                        clients.remove(this)
                    }
                }
            } catch (e: Exception) {
                clients.remove(this)
            }
        }
    }
}
