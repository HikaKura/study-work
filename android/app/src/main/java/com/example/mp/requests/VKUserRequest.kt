package com.example.mp.requests

import com.example.mp.models.User
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class VKUsersRequest(method: String) : VKRequest<List<User>>(method) {
    override fun parse(r: JSONObject): List<User> {
        val response = r.getJSONObject("response")
        val users = response.getJSONArray("items")
        val result = ArrayList<User>()
        for (i in 0 until users.length()) {
            result.add(User.parse(users.getJSONObject(i)))
        }
        return result
    }
}