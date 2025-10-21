package com.example.usersdk

import retrofit2.Call
import retrofit2.http.*

data class User(
    val id: Int,
    val name: String,
    val email: String
)

interface UserApi {
    @GET("api/users/{id}")
    fun getUser(@Path("id") id: Int): Call<User>

    @POST("api/users")
    fun createUser(@Body user: User): Call<User>

    @PUT("api/users/{id}")
    fun updateUser(@Path("id") id: Int, @Body user: User): Call<User>
}
