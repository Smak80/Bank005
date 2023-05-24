package ru.smak.data

import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class DbHelper(
    host: String = "localhost",
    port: Int = 3306,
    user: String = "root",
    password: String = "",
) {
    private val conn = DriverManager.getConnection("jdbc:mysql://$host:$port/bank003a", user, password)

    fun addUser(u: User){
        val sql = "INSERT INTO `users` (phone, lastname, firstname, middlename, birth, password)" +
                "VALUES (?, ?, ?, ?, ?, ?)"
        with(conn.prepareStatement(sql)){
            setString(1, u.phone)
            setString(2, u.lastName)
            setString(3, u.firstName)
            setString(4, u.middleName)
            setDate(5, u.birthDate)
            setString(6, u.password)
            executeUpdate()
        }
    }

    fun doTransfer(t: Transfer) {
        val sql1 = "UPDATE `accounts` SET Balance = Balance + ? WHERE AccId = ?"
        val sql2 = "UPDATE `accounts` SET Balance = Balance - ? WHERE AccId = ?"
        conn.autoCommit = false
        with(conn.prepareStatement(sql1)) {
            setFloat(1, t.sum)
            setString(2, t.accTo)
            try {
                executeUpdate()
            } catch (ex: Throwable) {
                conn.rollback()
                throw ex
            }
        }
        with (conn.prepareStatement(sql2)) {
            setFloat(1, t.sum + t.fee)
            setString(2, t.accFrom)
            try {
                executeUpdate()
            } catch (ex: Throwable) {
                conn.rollback()
                throw ex
            }
        }
        conn.commit()
    }
}