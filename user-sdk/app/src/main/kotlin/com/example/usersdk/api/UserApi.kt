package com.example.usersdk.api

import com.example.usersdk.model.User
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @GET("api/users/{id}")
    fun getUser(@Path("id") id: Int): Call<User>

    @GET("api/users")
    fun getAllUsers(): Call<List<User>>

    @POST("api/users")
    fun createUser(@Body user: User): Call<User>

    @PUT("api/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body user: User): Call<User>

    @DELETE("api/users/{id}")
    fun deleteUser(@Path("id") id: Int): Call<String>
}
