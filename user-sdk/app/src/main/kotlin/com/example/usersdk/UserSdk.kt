package com.example.usersdk

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class UserSdk(baseUrl: String) {

    private val api: UserApi

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl) // ✅ Make sure this ends with a '/'
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        api = retrofit.create(UserApi::class.java)
    }

    fun getUser(id: Int): User? {
        val response = api.getUser(id).execute()
        return if (response.isSuccessful && response.body() != null) {
            println("Fetched user: ${response.body()}")
            response.body()
        } else {
            println("Failed to fetch user. HTTP ${response.code()} - ${response.message()}")
            null
        }
    }

    fun createUser(user: User): User? {
        val response = api.createUser(user).execute()
        return if (response.isSuccessful && response.body() != null) {
            println("Created user: ${response.body()}")
            response.body()
        } else {
            println("Failed to create user. HTTP ${response.code()} - ${response.message()}")
            null
        }
    }

    fun updateUser(id: Int, user: User): User? {
        val response = api.updateUser(id, user).execute()
        return if (response.isSuccessful && response.body() != null) {
            println("Updated user: ${response.body()}")
            response.body()
        } else {
            println("Failed to update user. HTTP ${response.code()} - ${response.message()}")
            null
        }
    }
}
