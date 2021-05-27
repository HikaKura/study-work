package com.example.mp.models

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class User(
    val id: Int = 0,
    val firstName: String = "",
    val lastName: String = "",
    val photo: String = "") {
    companion object {
        fun parse(json: JSONObject)
                = User(id = json.optInt("id", 0),
            firstName = json.optString("first_name", ""),
            lastName = json.optString("last_name", ""),
            photo = json.optString("photo_200", ""))

        private const val TABLE_NAME = "Users"

        const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME(" +
                "id integer primary key autoincrement, " +
                "firstName text, " +
                "lastName text, " +
                "photo text);"

    }
}