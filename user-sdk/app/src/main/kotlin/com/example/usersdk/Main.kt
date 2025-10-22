package com.example.usersdk

import com.example.usersdk.model.User

fun main() {
    val sdk = UserSdk("http://localhost:8080/") // ensure trailing slash

    println("Create user...")
    val created = sdk.createUser(User(2, "Irfan", "irfan@example.com"))
    println("Created user: $created")

    println("Fetch user...")
    val fetched = try {
        sdk.getUser(2)
    } catch (e: Exception) {
        println("Exception while fetching user: ${e.message}")
        null
    }
    println("Fetched user: $fetched")
}
