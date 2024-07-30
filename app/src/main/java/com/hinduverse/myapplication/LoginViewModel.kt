package com.hinduverse.myapplication

class LoginViewModel {

    fun validateLogin(username: String, password: String): Boolean {
        return username == "user" && password == "password"
    }
}