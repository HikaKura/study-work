package com.example.mp.services

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.mp.models.User

class DbService(context: Context) : SQLiteOpenHelper(context, "app.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        Log.i("vk", db.toString())
        db?.execSQL(User.CREATE_TABLE)
        Log.i("vk", "db created")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onCreate(db)
    }

    companion object {
        private var instance: DbService? = null

        fun getInstance(context: Context? = null): DbService {
            if (instance == null) {
                instance = DbService(context!!)
            }

            return instance!!
        }
    }
}