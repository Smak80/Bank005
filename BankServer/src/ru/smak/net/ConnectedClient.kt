package ru.smak.net

import ru.smak.data.DataType
import ru.smak.data.DbHelper
import ru.smak.data.User
import java.io.ByteArrayInputStream
import java.io.ObjectInputStream
import java.net.Socket
import kotlin.concurrent.thread

class ConnectedClient(val client: Socket) {
    private val chio = BankIO(client)
    private val dbh = DbHelper()
    companion object{
        private val clients = mutableListOf<ConnectedClient>()
    }
    init{
        clients.add(this)
    }

    private fun send(data: String) {

    }

    private fun parse(data: ByteArray){
        ObjectInputStream(ByteArrayInputStream(data)).apply {
            when (readInt()){
                DataType.USER_REG_DATA.ordinal -> {
                    val u = readObject() as User
                    dbh.addUser(u)
                }
            }
        }
    }
    fun start(){
        thread {
            try {
                chio.startReceiving {
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
