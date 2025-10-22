package com.example.usersdk

import com.example.usersdk.api.UserApi
import com.example.usersdk.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserSdk(baseUrl: String) {

    private val api: UserApi

    init {
        // Logging interceptor - prints request/response headers and body (useful for debugging)
        val logging = HttpLoggingInterceptor { message -> println(message) }
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(ensureTrailingSlash(baseUrl))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(UserApi::class.java)
    }

    // Helper to ensure baseUrl ends with '/'
    private fun ensureTrailingSlash(url: String): String {
        return if (url.endsWith("/")) url else "$url/"
    }

    // Safe GET
    fun getUser(id: Int): User? {
        val call = api.getUser(id)
        val response = call.execute()
        val code = response.code()
        // If not successful, log and return null
        if (!response.isSuccessful) {
            println("getUser failed: HTTP $code - ${response.message()}. errorBody=${response.errorBody()?.string()}")
            return null
        }
        // If body is null or empty, log and return null (avoid Gson EOF)
        val body = response.body()
        if (body == null) {
            println("getUser: successful HTTP $code but empty body")
            return null
        }
        return body
    }

    // Safe POST
    fun createUser(user: User): User? {
        val call = api.createUser(user)
        val response = call.execute()
        val code = response.code()
        if (!response.isSuccessful) {
            println("createUser failed: HTTP $code - ${response.message()}. errorBody=${response.errorBody()?.string()}")
            return null
        }
        val body = response.body()
        if (body == null) {
            println("createUser: successful HTTP $code but empty body")
            return null
        }
        return body
    }

    // Safe PUT
    fun updateUser(id: Int, user: User): User? {
        val call = api.updateUser(id, user)
        val response = call.execute()
        val code = response.code()
        if (!response.isSuccessful) {
            println("updateUser failed: HTTP $code - ${response.message()}. errorBody=${response.errorBody()?.string()}")
            return null
        }
        val body = response.body()
        if (body == null) {
            println("updateUser: successful HTTP $code but empty body")
            return null
        }
        return body
    }

    // Safe DELETE (if your API returns body or message)
    fun deleteUser(id: Int): String? {
        val call = api.deleteUser(id)
        val response = call.execute()
        val code = response.code()
        if (!response.isSuccessful) {
            println("deleteUser failed: HTTP $code - ${response.message()}. errorBody=${response.errorBody()?.string()}")
            return null
        }
        // try to read any body text (may be empty)
        val respBody = response.body()
        return respBody?.let { it } ?: response.errorBody()?.string() ?: ""
    }
}
