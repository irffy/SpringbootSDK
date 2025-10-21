package com.example.usersdk

fun main() {
    val sdk = UserSdk("http://localhost:8080/") // ✅ must end with '/'
    sdk.createUser(User(2, "Irfan", "irfan@example.com"))
    sdk.getUser(2)
}
