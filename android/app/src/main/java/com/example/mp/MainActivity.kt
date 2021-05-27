package com.example.mp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mp.dao.UserDao
import com.example.mp.friends.ListAdapter
import com.example.mp.models.User
import com.example.mp.services.DbService
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS))
        var friendsList = listOf<User>()

        buttonUsers.setOnClickListener {
            val userDao = UserDao()
            userDao.getFriends({ friends: List<User> ->
                run {
                    Log.i("vk", friends.toString())
                    listView.adapter = ListAdapter(this, friends)
                    friendsList = friends
                }
            })
        }

        buttonSave.setOnClickListener {
            val userDao = UserDao()
            userDao.saveFriends(friendsList, this)
        }
        
        buttonLoad.setOnClickListener {
            val userDao = UserDao()
            val friends = userDao.getFriendsFromDB(this)
            Log.i("vk", friends.toString())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object: VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                // User passed authorization
            }

            override fun onLoginFailed(errorCode: Int) {
                // User didn't pass authorization
            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}


