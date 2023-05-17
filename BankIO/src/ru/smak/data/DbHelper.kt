package ru.smak.data

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
}