package com.example.mp.dao

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.mp.models.User
import com.example.mp.requests.VKUsersRequest
import com.example.mp.services.DbService
import com.example.mp.services.VkApiService

class UserDao {
    private val api: VkApiService = VkApiService.getInstance()

    fun getFriends(onSuccess: (res: List<User>) -> Unit, userId: Int? = null) {
        val req = VKUsersRequest("friends.get")
        if (userId != null) req.addParam("user_id", userId)
        req.addParam("fields", "photo_200")
        req.addParam("count", "5")
        api.execute(req, onSuccess)
    }

    fun saveFriends(friends: List<User>, context: Context) {
        val dbService = DbService.getInstance(context)
        val db = dbService.writableDatabase

        friends.forEach {
            val values = ContentValues().apply {
                put("firstName", it.firstName)
                put("lastName", it.lastName)
                put("photo", it.photo)
            }

            val newRowId = db?.insert("Users", null, values)
        }
    }

    fun getFriendsFromDB(context: Context): List<User> {
        val dbService = DbService.getInstance(context)
        val db = dbService.writableDatabase

        val friends = mutableListOf<User>()
        val cursor = db.query("Users", null, null, null, null, null, null)

        while (cursor?.moveToNext()!!) {
            val id = cursor.getInt(0)
            val firstName = cursor.getString(1)
            val lastName = cursor.getString(2)
            val photo = cursor.getString(3)

            val user = User(id, firstName, lastName, photo)
            friends.add(user)
        }

        return friends
    }
}