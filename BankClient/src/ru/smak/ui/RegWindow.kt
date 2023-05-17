package ru.smak.ui

import ru.smak.data.User
import ru.smak.net.Client
import javax.swing.GroupLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

class RegWindow(private val client: Client) : JFrame() {
    val lblPhone:      JLabel
    val lblLastName:   JLabel
    val lblFirstName:  JLabel
    val lblMiddleName: JLabel
    val lblBirth:      JLabel
    val lblLogin:      JLabel
    val lblPassword:   JLabel
    val lblPassword2:  JLabel
    val tfPhone:      JTextField
    val tfLastName:   JTextField
    val tfFirstName:  JTextField
    val tfMiddleName: JTextField
    val tfBirth:      JTextField
    val tfLogin:      JTextField
    val tfPassword:   JTextField
    val tfPassword2:  JTextField
    val btnReg:    JButton
    val btnCancel: JButton

    init{
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(600, 450)
        lblPhone      = JLabel("Номер телефона:")
        lblLastName = JLabel("Фамилия:")
        lblFirstName = JLabel("Имя:")
        lblMiddleName = JLabel("Отчество:")
        lblBirth = JLabel("Дата рождения:")
        lblLogin = JLabel("Логин:")
        lblPassword = JLabel("Пароль:")
        lblPassword2 = JLabel("Повтор пароля:")
        tfPhone = JTextField()
        tfLastName = JTextField()
        tfFirstName = JTextField()
        tfMiddleName = JTextField()
        tfBirth  = JTextField()
        tfLogin     = JTextField()
        tfPassword  = JTextField()
        tfPassword2  = JTextField()
        btnReg = JButton("Зарегистрироваться")
        btnCancel = JButton("Отмена")
        layout = GroupLayout(contentPane).apply {
            setHorizontalGroup(
                createSequentialGroup()
                    .addGap(8, 8, Int.MAX_VALUE)
                    .addGroup(
                        createParallelGroup()
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(lblPhone, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(4)
                                    .addComponent(tfPhone, MAX_SZ, MAX_SZ, MAX_SZ)
                            )
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(lblLastName, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(4)
                                    .addComponent(tfLastName, MAX_SZ, MAX_SZ, MAX_SZ)
                            )
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(lblFirstName, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(4)
                                    .addComponent(tfFirstName, MAX_SZ, MAX_SZ, MAX_SZ)
                            )
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(lblMiddleName, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(4)
                                    .addComponent(tfMiddleName, MAX_SZ, MAX_SZ, MAX_SZ)
                            )
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(lblBirth, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(4)
                                    .addComponent(tfBirth, MAX_SZ, MAX_SZ, MAX_SZ)
                            )
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(lblLogin, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(4)
                                    .addComponent(tfLogin, MAX_SZ, MAX_SZ, MAX_SZ)
                            )
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(lblPassword, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(4)
                                    .addComponent(tfPassword, MAX_SZ, MAX_SZ, MAX_SZ)
                            )
                            .addGroup(
                                createSequentialGroup()
                                    .addComponent(lblPassword2, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(4)
                                    .addComponent(tfPassword2, MAX_SZ, MAX_SZ, MAX_SZ)
                            )
                            .addGroup(
                                createSequentialGroup()
                                    .addGap(8, 8, Int.MAX_VALUE)
                                    .addComponent(btnReg, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(8)
                                    .addComponent(btnCancel, MIN_SZ, MIN_SZ, MIN_SZ)
                                    .addGap(8, 8, Int.MAX_VALUE)
                            )
                    )
                    .addGap(8, 8, Int.MAX_VALUE)
            )
            setVerticalGroup(
                createSequentialGroup()
                    .addGap(8, 8, Int.MAX_VALUE)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(lblPhone, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(tfPhone, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(lblLastName, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(tfLastName, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(lblFirstName, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(tfFirstName, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(lblMiddleName, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(tfMiddleName, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(lblBirth, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(tfBirth, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(lblLogin, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(tfLogin, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(lblPassword, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(tfPassword, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(lblPassword2, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(tfPassword2, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(4)
                    .addGroup(
                        createParallelGroup()
                            .addComponent(btnReg, MIN_SZ, MIN_SZ, MIN_SZ)
                            .addComponent(btnCancel, MIN_SZ, MIN_SZ, MIN_SZ)
                    )
                    .addGap(8, 8, Int.MAX_VALUE)
            )
            linkSize(0, btnReg, btnCancel)
            linkSize(0, lblPassword, lblPhone, lblBirth, lblLogin, lblPassword2, lblLastName, lblFirstName, lblMiddleName)
        }

        btnReg.addActionListener {
            client.regUser(User(
                phone = tfPhone.text,
                lastName = tfLastName.text,
                firstName = tfFirstName.text,
                middleName = tfMiddleName.text,
                birth = tfBirth.text,
                login = tfLogin.text,
                password = tfPassword.text,
                )
            )
        }
    }

    companion object{
        val MIN_SZ = GroupLayout.PREFERRED_SIZE
        val MAX_SZ = GroupLayout.DEFAULT_SIZE
    }
}